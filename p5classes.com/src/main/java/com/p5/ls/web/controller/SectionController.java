package com.p5.ls.web.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Branch;
import com.p5.ls.web.model.Clas;
import com.p5.ls.web.model.Section;
import com.p5.ls.web.service.IAreaService;
import com.p5.ls.web.service.IClasService;
import com.p5.ls.web.service.ISectionService;
import com.p5.ls.web.util.Const;
import com.p5.ls.web.util.UserUtil;

@Controller
@RequestMapping("/section")
public class SectionController implements IGenericController<Long, Section> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SectionController.class);

	private static final String C_ENTITY = "Section";
	private static final String C_ENTITIES = "Sections";
	private static final String S_ENTITY = "section";
	private static final String S_ENTITIES = "sections";
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
	ISectionService sectionService;

	@Autowired
	IClasService clasService;

	@Autowired
	IAreaService areaService;

	@RequestMapping(value = { ADD_ENTITY }, method = RequestMethod.GET)
	public ModelAndView newEntityForm(@ModelAttribute Section entity) {
		ModelAndView mv = new ModelAndView(VW_ADD_ENTITY_FORM);
		try {
			List<Clas> clasList = clasService.findAll();
			Map<Long, String> clasMap = clasList.stream().collect(Collectors.toMap(Clas::getClasId, Clas::getClasName, (a, b) -> a, TreeMap::new));
			mv.addObject("clasMap", clasMap);
			mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = { SAVE_ENTITY }, method = RequestMethod.POST)
	public ModelAndView saveEntity(@Valid @ModelAttribute Section entity, BindingResult result, Authentication auth) {
		ModelAndView mv = new ModelAndView(VW_ADD_ENTITY_FORM);
		if (result.hasErrors()) {
			mv.addObject(Const.MSG_ERROR, result);
			return mv;
		}
		try {
			entity.setBranch(UserUtil.getUserBranch(auth));
			sectionService.save(entity);
			mv = new ModelAndView(VW_VIEW_ENTITY);
			mv.addObject(Const.MSG_SUCCESS, C_ENTITY + " successfully Added");
			mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}
		return mv;
	}

	@RequestMapping(value = { EDIT_ENTITY }, method = RequestMethod.GET)
	public ModelAndView editEntityForm(@PathVariable(ENTITY_ID) Long id) {
		ModelAndView mv = new ModelAndView(VW_EDIT_ENTITY_FORM);
		try {
			List<Clas> clasList = clasService.findAll();
			Map<Long, String> clasMap = clasList.stream().collect(Collectors.toMap(Clas::getClasId, Clas::getClasName, (a, b) -> a, TreeMap::new));
			mv.addObject("clasMap", clasMap);

			Section entity = sectionService.findById(id);
			mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}
		return mv;
	}

	@RequestMapping(value = { UPDATE_ENTITY }, method = RequestMethod.POST)
	public ModelAndView updateEntity(@Valid @ModelAttribute Section entity, BindingResult result) {
		ModelAndView mv = new ModelAndView(VW_EDIT_ENTITY_FORM);
		if (result.hasErrors()) {
			mv.addObject(Const.MSG_ERROR, result);
			return mv;
		}
		try {
			entity = sectionService.update(entity);
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
			Section entity = sectionService.findById(id);
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
			List<Section> entities = sectionService.findAll();
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
			sectionService.deleteById(id);
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
