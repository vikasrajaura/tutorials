package com.p5.ls.web.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.aerogear.security.otp.api.Base32;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.mail.IEmailService;
import com.p5.ls.web.model.AuditAttributes;
import com.p5.ls.web.model.CustomUser;
import com.p5.ls.web.model.User;
import com.p5.ls.web.model.VerificationToken;
import com.p5.ls.web.service.IUserService;
import com.p5.ls.web.service.IVerificationTokenService;
import com.p5.ls.web.util.Const;
import com.p5.ls.web.util.UserUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private static final String C_ENTITY = "User";
	private static final String C_ENTITIES = "Users";
	private static final String S_ENTITY = "user";
	private static final String S_ENTITIES = "users";
	private static final String _S_ENTITY = Const.UNDERSCORE + S_ENTITY;
	private static final String _S_ENTITIES = Const.UNDERSCORE + S_ENTITIES;
	private static final String ENTITY_SLASH = S_ENTITY + Const.SLASH;
	private static final String ENTITY_ID = S_ENTITY + "Id";
	private static final String URI_ID = "/{" + ENTITY_ID + "}";

	/* URIs of this controller */
	private static final String ADD_ENTITY = Const.SLASH_ADD + C_ENTITY;
	private static final String SAVE_ENTITY = Const.SLASH_SAVE + C_ENTITY;
	private static final String EDIT_ENTITY = Const.SLASH_EDIT + C_ENTITY + URI_ID;
	private static final String UPDATE_ENTITY = Const.SLASH_UPDATE + C_ENTITY;
	private static final String EDIT_ENTITIES = Const.SLASH_EDIT + C_ENTITIES;
	private static final String UPDATE_ENTITIES = Const.SLASH_UPDATE + C_ENTITIES;
	private static final String VIEW_ENTITY = Const.SLASH_VIEW + C_ENTITY + URI_ID;
	private static final String VIEW_ENTITIES = Const.SLASH_VIEW + C_ENTITIES;
	private static final String DELETE_ENTITY = Const.SLASH_DELETE + C_ENTITY + URI_ID;
	private static final String DELETE_ENTITIES = Const.SLASH_DELETE + C_ENTITIES;

	/* return view names */
	private static final String VW_ADD_ENTITY_FORM = ENTITY_SLASH + Const.ADD + _S_ENTITY;
	private static final String VW_EDIT_ENTITY_FORM = ENTITY_SLASH + Const.EDIT + _S_ENTITY;
	private static final String VW_EDIT_ENTITIES_FORM = ENTITY_SLASH + Const.EDIT + _S_ENTITIES;
	private static final String VW_VIEW_ENTITIES = ENTITY_SLASH + Const.VIEW + _S_ENTITIES;
	private static final String VW_VIEW_ENTITY = ENTITY_SLASH + Const.VIEW + _S_ENTITY;

	@Autowired
	IUserService userService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	IEmailService emailServie;
	
	@Autowired
	IVerificationTokenService verificationTokenService;
	
	@RequestMapping(value = { ADD_ENTITY }, method = RequestMethod.GET)
	public ModelAndView newEntityForm(@ModelAttribute User entity) {
		ModelAndView mv = new ModelAndView(VW_ADD_ENTITY_FORM);
		mv.addObject(S_ENTITY, entity);
		return mv;
	}

	@RequestMapping(value = { SAVE_ENTITY }, method = RequestMethod.POST)
	public ModelAndView saveEntity(@Valid @ModelAttribute User entity, BindingResult result, Authentication auth, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView(VW_ADD_ENTITY_FORM);
		if (result.hasErrors()) {
			mv.addObject(Const.MSG_ERROR, result);
			return mv;
		}
		try {
			entity.setEnabled(false);
			entity.setBranch(UserUtil.getUserBranch(auth));
			entity.setAuditAttributes(new AuditAttributes(UserUtil.getUser(auth).getUserId(), new Date(), null, null));
			entity.setSecret(Base32.random());
			userService.save(entity);

			// create a token and save it and send verification email
			// generate and save token
			final String token = verificationTokenService.createTokenForUser(entity);
			
			String verificationUrl = "http://" + req.getServerName()+":"+req.getServerPort()
			+ req.getContextPath()+"/user/confirmRegistration?token="+token;
			
			LOGGER.info("Verification Url: "+verificationUrl);
			System.out.println("---Entering in sendTestEmail---");
			//emailServie.sendSimpleMessage(user.getEmail(), "Registration Confirmation Link", verificationUrl);
			System.out.println("---Exiting in sendTestEmail---");

			//mv = new ModelAndView(VW_VIEW_ENTITY);
			mv = new ModelAndView("qrcode", "user", entity);
			
			mv.addObject(Const.MSG_SUCCESS, C_ENTITY + " successfully Registered");
			mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}
		return mv;
	}
	
	@RequestMapping(value = "/confirmRegistration", method = RequestMethod.GET)
	public ModelAndView confirmRegistration(@RequestParam("token") String token, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("login");
		final VerificationToken verToken = verificationTokenService.findByToken(token);
		if(verToken!=null) {
			User user = verToken.getUser();
			userService.enableOrDisableUser(true, user.getUserId());
			mv.addObject(Const.MSG_SUCCESS, "Hi, "+user.getUserName()+", your account verified successfully");
		}
		else {
			mv = new ModelAndView("/access_deniend");
			mv.addObject(Const.MSG_ERROR, "Access Denied");
		}
		return mv;
	}	

	@RequestMapping(value = { EDIT_ENTITY }, method = RequestMethod.GET)
	public ModelAndView editEntityForm(@PathVariable(ENTITY_ID) Long id) {
		ModelAndView mv = new ModelAndView(VW_EDIT_ENTITY_FORM);
		try {
			User entity = userService.findById(id);
			mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}
		return mv;
	}

	@RequestMapping(value = { UPDATE_ENTITY }, method = RequestMethod.POST)
	public ModelAndView updateEntity(@Valid @ModelAttribute User entity, BindingResult result, Authentication auth) {

		ModelAndView mv = new ModelAndView(VW_EDIT_ENTITY_FORM);
		if (result.hasErrors()) {
			mv.addObject(Const.MSG_ERROR, result);
			return mv;
		}
		try {
			if (entity.getAuditAttributes() != null) {
				entity.getAuditAttributes().setModifiedBy(UserUtil.getUser(auth).getUserId());
				entity.getAuditAttributes().setModifiedDate(new Date());
			}
			entity = userService.update(entity);
			//entity = userService.findById(entity.getUserId());
			mv = new ModelAndView(VW_VIEW_ENTITY);
			mv.addObject(Const.MSG_SUCCESS, C_ENTITY + " successfully updated");
			mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}
		return mv;
	}

	@RequestMapping(value = { EDIT_ENTITIES }, method = RequestMethod.GET)
	public ModelAndView editEntitiesForm() {
		ModelAndView mv = new ModelAndView(VW_EDIT_ENTITIES_FORM);
		return mv;
	}

	@RequestMapping(value = { UPDATE_ENTITIES }, method = RequestMethod.POST)
	public ModelAndView updateEntities() {
		ModelAndView mv = new ModelAndView(VW_VIEW_ENTITIES);
		return mv;
	}
	
	@RequestMapping(value = { VIEW_ENTITY }, method = RequestMethod.GET)
	public ModelAndView viewEntity(@PathVariable(ENTITY_ID) Long id) {
		ModelAndView mv = new ModelAndView(VW_VIEW_ENTITY);
		try {
			User entity = userService.findById(id);
			mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}
		return mv;
	}

	@RequestMapping(value = { VIEW_ENTITIES }, method = RequestMethod.GET)
	public ModelAndView viewEntities(Authentication auth, Principal principal) {
		ModelAndView mv = new ModelAndView(VW_VIEW_ENTITIES);
		try {
			CustomUser customUser = UserUtil.getCustomUser(auth);
			List<User> entities = null;
			if (customUser.hasRole(Const.ROLE_SUPER_USER)) {
				entities = userService.findAll();
			} else if (customUser.hasRole(Const.ROLE_DBA_USER)) {
				entities = userService.findAll();
			} else if (customUser.hasRole(Const.ROLE_ORG_USER)) {
				entities = userService.findByOrgId(UserUtil.getUserOrgId(auth));
			} else if (customUser.hasRole(Const.ROLE_BRANCH_USER) 
					|| customUser.hasRole(Const.ROLE_ADMIN_USER)
					|| customUser.hasRole(Const.ROLE_PRINCIPLE_USER)) {
				entities = userService.findByBranchId(UserUtil.getUserBranchId(auth));
			} else if (customUser.hasRole(Const.ROLE_TEACHER_USER)) {
				return null;
			}
			mv.addObject(S_ENTITIES, entities);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}
		return mv;
	}
	
	

	@RequestMapping(value = { DELETE_ENTITY }, method = RequestMethod.GET)
	public ModelAndView deleteEntity(@PathVariable(ENTITY_ID) Long id) {
		ModelAndView mv = new ModelAndView(VW_VIEW_ENTITY);
		try {
			userService.deleteById(id);
			mv.addObject(Const.MSG_SUCCESS, C_ENTITY + " successfully deleted");
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}
		return mv;
	}

	@RequestMapping(value = { DELETE_ENTITIES }, method = RequestMethod.GET)
	public ModelAndView deleteEntities() {
		ModelAndView mv = new ModelAndView(VW_VIEW_ENTITY);
		return mv;
	}

	//////////////////////////
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String resetPassword() {
		return "change_password";
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView resetPasswordAction(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword, Authentication auth) {
		ModelAndView mv = new ModelAndView("change_password");
		User user = UserUtil.getUser(auth);
		if(!passwordEncoder.matches(oldPassword, user.getPassword())) {
			mv.addObject(Const.MSG_ERROR, "Please Enter correct password");
		} else if(!newPassword.equals(confirmPassword)){
			mv.addObject(Const.MSG_ERROR, "New Password and Confirm Password does not match");
		}else {
			userService.changePassword(passwordEncoder.encode(newPassword), user.getUserId());
			mv = new ModelAndView("/login");
			mv.addObject(Const.MSG_SUCCESS, "Password Changed Successfully");
		}
		return mv;
	}

	@RequestMapping(value = "/sendPasswordResetLink", method = RequestMethod.POST)
	public ModelAndView sendPasswordResetLink(@RequestParam("userName") String userName, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("login");
		User user = userService.findByUserName(userName);
		if (user == null) {
			mv = new ModelAndView("/forget_password");
			mv.addObject(Const.MSG_ERROR, "User not found");
		} else {
			
			// generate and save token
			final String token = verificationTokenService.createTokenForUser(user);

			// send forget password email to user
			String passwordResetLink = "http://" + req.getServerName() + ":" + req.getServerPort()
					+ req.getContextPath()+"/user/forgetPassword?token="+token;
			LOGGER.info("Verification Url: "+passwordResetLink);
			System.out.println("---sending Email---");
			emailServie.sendSimpleMessage(user.getEmail(), "Forget Password Link", passwordResetLink);
			System.out.println("---Exiting sendEmail---");
			mv.addObject(Const.MSG_SUCCESS, "Hi "+user.getUserName()+", reset password link sent on your email");
		}
		return mv;
	}
	
	
	// forrget password get, it will display form to change password
	// it will be called by forget password link
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public ModelAndView forgetPasswordForm(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("forget_password");
		String token = req.getParameter("token");
		if(token==null) {
			return mv;
		}
		final VerificationToken verToken = verificationTokenService.findByToken(token);
		if(verToken!=null) {
			User user = verToken.getUser();
			mv.addObject(Const.MSG_SUCCESS, "Hi "+user.getUserName()+", change your password");
			mv.addObject("token", token);
		}
		else {
			mv = new ModelAndView("/access_deniend");
			mv.addObject(Const.MSG_ERROR, "Access Denied");
		}
		return mv;
	}
	

	// forget password action post method, on success it will change password.
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	public ModelAndView forgetPasswordAction(@RequestParam("token") String token, @RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword, Authentication auth) {
		ModelAndView mv = new ModelAndView("forget_password");
		
		final VerificationToken verToken = verificationTokenService.findByToken(token);
		if(verToken!=null) {
			User user = verToken.getUser();
			mv.addObject("token", token);
			if(!newPassword.equals(confirmPassword)) {
				mv.addObject(Const.MSG_ERROR, "Hi "+user.getUserName()+", change your password.<br> New Password and Confirm Password does not match");
				mv.addObject("token", token);
			} else {
				userService.changePassword(passwordEncoder.encode(newPassword), user.getUserId());
				mv = new ModelAndView("login");
				mv.addObject(Const.MSG_SUCCESS, "Password Changed Successfully");
			}			
		} else {
			mv = new ModelAndView("login");
			mv.addObject(Const.MSG_ERROR, "Unauthorized Access");
		}
		return mv;
	}
		
	
}
