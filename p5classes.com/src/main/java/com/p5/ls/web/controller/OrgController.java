package com.p5.ls.web.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Org;
import com.p5.ls.web.model.User;
import com.p5.ls.web.service.IGenericService;
import com.p5.ls.web.service.IOrgService;
import com.p5.ls.web.service.IUserService;
import com.p5.ls.web.util.Const;
import com.p5.ls.web.util.UserUtil;

@Controller
@RequestMapping("/org")
public class OrgController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrgController.class);
	private static final String UPLOADED_FOLDER = "C:/fileserver/";

	private static final String C_ENTITY = "Org";
	private static final String C_ENTITIES = "Orgs";
	private static final String S_ENTITY = "org";
	private static final String S_ENTITIES = "orgs";
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
	IOrgService orgService;
	
	@Autowired
	IUserService userService;


	@RequestMapping(value = { ADD_ENTITY }, method = RequestMethod.GET)
	public ModelAndView newEntityForm(@ModelAttribute Org entity) {
		ModelAndView mv = new ModelAndView(VW_ADD_ENTITY_FORM);
		// clasService.findAll();
		mv.addObject(S_ENTITY, entity);
		return mv;
	}

	@RequestMapping(value = { SAVE_ENTITY }, method = RequestMethod.POST)
	public ModelAndView saveEntity(@Valid @ModelAttribute Org entity, @RequestParam("file") MultipartFile file, BindingResult result, Authentication auth) {
		ModelAndView mv = new ModelAndView(VW_ADD_ENTITY_FORM);
		
        if (entity.getFile()==null || entity.getFile().isEmpty()) {
        	mv.addObject(Const.MSG_ERROR, "Please select a file to upload");
            return mv;
        }
		if (result.hasErrors()) {
			mv.addObject(Const.MSG_ERROR, result);
			return mv;
		}
		try {
			entity.setLogoImage(file.getBytes());
			orgService.save(entity);
			
			/*
			// save branch user with org
			User orgUser = UserUtil.prepareDummyUser(Arrays.asList(Const.ROLE_ORG_USER_ID));
			orgUser.setOrg(entity);
			orgUser.setUserName("OR" + entity.getOrgId());
			orgUser = userService.saveUserWithRoles(orgUser, orgUser.getRoleIds());
			
			*/
			
			
			
			
			Long orgId = 1234L;
			String orgPath = UPLOADED_FOLDER+"orgs/OR"+orgId+"/";
			FileUtility.uploadFile(file, orgPath, "logo.jpg");
			mv = new ModelAndView(VW_VIEW_ENTITY);			
			/*
			mv.addObject(Const.MSG_SUCCESS, C_ENTITY + " successfully Registered. Note Username: "+orgUser.getUserName());
			*/
			mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		} catch (IOException e) {
			mv.addObject(Const.MSG_ERROR, "IOException occured while uploading file.");
            e.printStackTrace();
        }
		return mv;
	}

	@RequestMapping(value = { EDIT_ENTITY }, method = RequestMethod.GET)
	public ModelAndView editEntityForm(@PathVariable(ENTITY_ID) Long id) {
		ModelAndView mv = new ModelAndView(VW_EDIT_ENTITY_FORM);
		try {
			Org entity = orgService.findById(id);
			mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}
		return mv;
	}


	@RequestMapping(value = { UPDATE_ENTITY }, method = RequestMethod.POST)
	public ModelAndView updateEntity(@Valid @ModelAttribute Org entity, @RequestParam("file") MultipartFile file, BindingResult result) {
		ModelAndView mv = new ModelAndView(VW_EDIT_ENTITY_FORM);
		if (result.hasErrors()) {
			mv.addObject(Const.MSG_ERROR, result);
			return mv;
		}
		try {
			entity.setLogoImage(file.getBytes());
			orgService.update(entity);
			//entity = orgService.findById(entity.getOrgId());
			mv = new ModelAndView(VW_VIEW_ENTITY);
			mv.addObject(Const.MSG_SUCCESS, C_ENTITY + " successfully updated");
			mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		} catch (IOException e) {
			mv.addObject(Const.MSG_ERROR, "IOException occured while uploading file.");
            e.printStackTrace();
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
			Org entity = orgService.findById(id);
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
			List<Org> entities = orgService.findAll();
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
			orgService.deleteById(id);
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
