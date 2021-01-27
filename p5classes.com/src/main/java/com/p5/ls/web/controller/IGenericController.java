package com.p5.ls.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface IGenericController<ID, T> {

	public ModelAndView newEntityForm(T entity);

	public ModelAndView saveEntity(T entity, BindingResult result,  Authentication auth);

	public ModelAndView editEntityForm(ID id);

	public ModelAndView updateEntity(T entity, BindingResult result);

	public ModelAndView editEntitiesForm();

	public ModelAndView updateEntities();

	public ModelAndView viewEntity(ID id);

	public ModelAndView viewEntities();

	public ModelAndView deleteEntity(ID id);

	public ModelAndView deleteEntities();

}
