package com.vik.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vik.model.Customer;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView viewLoginPage(@ModelAttribute Customer customer) {
		ModelAndView model = new ModelAndView("/login/Login");
		return model;
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(@Valid @ModelAttribute Customer customer, BindingResult result) {
		ModelAndView model;
		if (result.hasErrors()) {
			model = new ModelAndView("/login/Login");
			return model;
		}
		model = new ModelAndView("/login/LoginHome");
		return model;
	}

}