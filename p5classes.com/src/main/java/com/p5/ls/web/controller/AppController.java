package com.p5.ls.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.p5.ls.web.mail.IEmailService;
import com.p5.ls.web.model.CustomUser;
import com.p5.ls.web.model.User;
import com.p5.ls.web.service.IUserService;
import com.p5.ls.web.util.Const;
import com.p5.ls.web.util.UserUtil;

@Controller
@RequestMapping("/")
public class AppController  {

	private static final Logger LOGGER = LoggerFactory.getLogger(AreaController.class);

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	@Autowired
	IUserService userService;
	
	
	/**
	 * This method handles login GET requests. If users is already logged-in and
	 * tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = {"/login", "/welcome"})
	public String loginPage(Model model) {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
		} else {
			return "welcome";
		}
	}


	/**
	 * This method handles logout requests. Toggle the handlers if you are
	 * RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			// new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}


	/**
	 * This method returns true if users is already authenticated [logged-in],
	 * else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}

	@RequestMapping(value = {"/rolePermissions/{role}"})
	public String getRolePage(@PathVariable("role") String role, Authentication auth) {
		CustomUser customUser =null;
		if (auth.getPrincipal() instanceof CustomUser) {
			customUser = (CustomUser) auth.getPrincipal();
		}
		if(customUser.hasRole(role)) {
			role=role.replace("ROLE_", "").toLowerCase();
			return  "/rolePermissions/"+role+"_permissions";
		/*	
			if(Const.ROLE_SUPER_USER_ID.equals(roleId))
				return  "/rolePermissions/super_permissions"; 
			else if(Const.ROLE_DBA_USER_ID.equals(roleId))
				return  "/rolePermissions/dba_permissions"; 
			else if(Const.ROLE_ORG_USER_ID.equals(roleId))
				return  "/rolePermissions/org_permissions"; 
			else if(Const.ROLE_BRANCH_USER_ID.equals(roleId))
				return  "/rolePermissions/branch_permissions"; 
			else if(Const.ROLE_ADMIN_USER_ID.equals(roleId))
				return  "/rolePermissions/admin_permissions"; 
			else if(Const.ROLE_PRINCIPLE_USER_ID.equals(roleId))
				return  "/rolePermissions/principle_permissions"; 
			else if(Const.ROLE_TEACHER_USER_ID.equals(roleId))
				return  "/rolePermissions/teacher_permissions"; 
			else if(Const.ROLE_PARENT_USER_ID.equals(roleId))
				return  "/rolePermissions/parent_permissions"; 
			else if(Const.ROLE_STUDENT_USER_ID.equals(roleId))
				return  "/rolePermissions/student_permissions";
			else
				return "accessDenied"; 
			*/
		}
		return "redirect:/accessDenied";
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		return "access_denied";
	}

	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/devHelp", method = RequestMethod.GET)
	public String devHelp(ModelMap model) {
		return "dev_help";
	}
	
	/** 
	 * If two methods have same uri - Then RE occurs
	 * Caused by: java.lang.IllegalStateException: Ambiguous mapping. 
	 * Cannot map 'appController' method
	 */
	@RequestMapping(value = "/devHelp1", method = RequestMethod.GET)
	public String devHelp1() {
		return "dev_help1";
	}

	@RequestMapping(value = "/devHelp2", method = RequestMethod.GET)
	public String devHelp2() {
		return "dev_help2";
	}

	
}