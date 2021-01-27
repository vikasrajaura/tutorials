package com.vik.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vik.model.Org;

@Controller
@RequestMapping("/org")
public class OrgController {


	@ModelAttribute
	public void addingObjects(Model model1) {
		model1.addAttribute("headerMessage", "Learnig Management!");
	}

	@RequestMapping(value = "/OrgForm", method = RequestMethod.GET)
	public ModelAndView viewOrgForm(@ModelAttribute Org org) {
		ModelAndView model = new ModelAndView("/org/OrgForm");
		return model;
	}

	@RequestMapping(value = "/OrgFormSubmit", method = RequestMethod.POST)
	public ModelAndView orgFormAction(@Valid @ModelAttribute("org") Org org, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("/org/OrgForm");
			return model;
		}
		ModelAndView model = new ModelAndView("/org/OrgSuccess");
		return model;
	}

}
