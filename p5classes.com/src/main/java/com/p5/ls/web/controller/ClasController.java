package com.p5.ls.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Clas;
import com.p5.ls.web.service.IClasService;
import com.p5.ls.web.util.Const;

@Controller
@RequestMapping("/clas")
public class ClasController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClasController.class);

	private static final String C_ENTITY = "Clas";
	private static final String C_ENTITIES = "Clases";
	private static final String S_ENTITY = "clas";
	private static final String S_ENTITIES = "clases";
	private static final String _S_ENTITY = Const.UNDERSCORE+S_ENTITY;
	private static final String _S_ENTITIES = Const.UNDERSCORE+S_ENTITIES;
	private static final String ENTITY_SLASH = S_ENTITY+Const.SLASH;
	private static final String ENTITY_ID = S_ENTITY+"Id";
	private static final String URI_ID = "/{"+ENTITY_ID+"}";
	
	
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
	IClasService clasService;
	
	@RequestMapping(value = { ADD_ENTITY }, method = RequestMethod.GET)
	public ModelAndView newEntityForm(@ModelAttribute Clas entity) {
		ModelAndView mv = new ModelAndView(VW_ADD_ENTITY_FORM);
		mv.addObject(S_ENTITY, entity);
		return mv;
	}

	@RequestMapping(value = { SAVE_ENTITY }, method = RequestMethod.POST)
	public ModelAndView saveEntity(@Valid @ModelAttribute Clas entity, BindingResult result) {
		ModelAndView mv = new ModelAndView(VW_ADD_ENTITY_FORM);
		if (result.hasErrors()) {
			mv.addObject(Const.MSG_ERROR, result);
			return mv;
		}
		try {
			clasService.save(entity);
			mv = new ModelAndView(VW_VIEW_ENTITY);
			mv.addObject(Const.MSG_SUCCESS, C_ENTITY + " successfully added");
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
		Clas entity = clasService.findById(id);
		mv.addObject(S_ENTITY, entity);
		} catch (ServiceException e) {
			mv.addObject(Const.MSG_ERROR, e.getErMsg());
		}
		return mv;
	}

	@RequestMapping(value = { UPDATE_ENTITY }, method = RequestMethod.POST)
	public ModelAndView updateEntity(@Valid @ModelAttribute Clas entity, BindingResult result) {
		ModelAndView mv = new ModelAndView(VW_EDIT_ENTITY_FORM);
		if (result.hasErrors()) {
			mv.addObject(Const.MSG_ERROR, result);
			return mv;
		}
		try {
			clasService.update(entity);
			entity = clasService.findById(entity.getClasId());
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
		Clas entity = clasService.findById(id);
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
			List<Clas> entities = clasService.findAll();
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
		clasService.deleteById(id);
		mv.addObject(Const.MSG_SUCCESS, C_ENTITY +" successfully deleted");
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
