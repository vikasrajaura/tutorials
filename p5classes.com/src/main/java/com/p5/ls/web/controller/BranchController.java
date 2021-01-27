package com.p5.ls.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Branch;
import com.p5.ls.web.model.Org;
import com.p5.ls.web.service.IBranchService;
import com.p5.ls.web.service.IOrgService;
import com.p5.ls.web.service.IUserService;
import com.p5.ls.web.util.Const;

@Controller
@RequestMapping("/branch")
public class BranchController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BranchController.class);
	private static final String UPLOADED_FOLDER = "C:/fileserver/";
	
	private static final String C_ENTITY = "Branch";
	private static final String C_ENTITIES = "Branches";
	private static final String S_ENTITY = "branch";
	private static final String S_ENTITIES = "branches";
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
	IBranchService branchService;

	@Autowired
	IOrgService orgService;
	
	@Autowired
	IUserService userService;

	@RequestMapping(value = { ADD_ENTITY }, method = RequestMethod.GET)
	public ModelAndView newEntityForm(@ModelAttribute Branch entity) {
		ModelAndView mv = new ModelAndView(VW_ADD_ENTITY_FORM);
		try {
		List<Org> orgList = orgService.findAll();
		Map<Long, String> orgMap = orgList.stream().collect(Collectors.toMap(Org::getOrgId, Org::getOrgName, (a, b) -> a, TreeMap::new));
		mv.addObject("orgMap", orgMap);
		mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}

		return mv;
	}

	@RequestMapping(value = { SAVE_ENTITY }, method = RequestMethod.POST)
	public ModelAndView saveEntity(@Valid @ModelAttribute Branch entity, @RequestParam("file") MultipartFile file, BindingResult result, Authentication auth) {
		ModelAndView mv = new ModelAndView(VW_ADD_ENTITY_FORM);
		if (result.hasErrors()) {
			mv.addObject(Const.MSG_ERROR, result);
			return mv;
		}
		try {
			/*
			Org org = orgService.findById(entity.getOrgId());
			entity.setOrg(org);
			branchService.save(entity);
			
			// save branch user with org and branch
			User branchUser = UserUtil.prepareDummyUser(Arrays.asList(Const.ROLE_BRANCH_USER_ID));
			branchUser.setBranch(entity);
			branchUser.setOrg(org);
			branchUser.setUserName("BR" + entity.getBranchId());
			branchUser = userService.saveUserWithRoles(branchUser, branchUser.getRoleIds());
*/
			Long branchId = 1238L;
			Long orgId = 111L;
			String branchPath = UPLOADED_FOLDER+"orgs/OR"+orgId+"/BR"+branchId;
			FileUtility.uploadFile(file, branchPath, "logo.jpg");

			mv = new ModelAndView(VW_VIEW_ENTITY);
			/*
			mv.addObject(Const.MSG_SUCCESS, C_ENTITY + " successfully Registered. Note Username: "+branchUser.getUserName());
			mv.addObject(S_ENTITY, entity);
			*/
		} /*catch (ServiceException e) {
		mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}*/ catch (IOException e) {
			mv.addObject(Const.MSG_ERROR, "IOException occured while uploading file.");
			e.printStackTrace();
		}
		return mv;

	}

	@RequestMapping(value = { EDIT_ENTITY }, method = RequestMethod.GET)
	public ModelAndView editEntityForm(@PathVariable(ENTITY_ID) Long id) {
		ModelAndView mv = new ModelAndView(VW_EDIT_ENTITY_FORM);
		try {
			Branch entity = branchService.findById(id);
			mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}
		return mv;
	}

	@RequestMapping(value = { UPDATE_ENTITY }, method = RequestMethod.POST)
	public ModelAndView updateEntity(@Valid @ModelAttribute Branch entity, BindingResult result) {
		ModelAndView mv = new ModelAndView(VW_EDIT_ENTITY_FORM);
		if (result.hasErrors()) {
			mv.addObject(Const.MSG_ERROR, result);
			return mv;
		}
		try {

			entity = branchService.update(entity);
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
			Branch entity = branchService.findById(id);
			mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}
		return mv;
	}

	@RequestMapping(value = { VIEW_ENTITIES }, method = RequestMethod.GET)
	public ModelAndView viewEntities() {
		ModelAndView mv = new ModelAndView(VW_VIEW_ENTITIES);
		try {
			List<Branch> entities = branchService.findAll();
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
			branchService.deleteById(id);
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

}
