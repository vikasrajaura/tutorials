package com.vik.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {


	@RequestMapping("/")
	protected ModelAndView defaultPage() throws Exception {
		ModelAndView modelView = new ModelAndView("/index");
		modelView.addObject("msg", " Welcome to demo page.");
		return modelView;
	}

	@RequestMapping("/Form.htm")
	protected ModelAndView a() throws Exception {
		ModelAndView modelView = new ModelAndView("/hello/Form");
		modelView.addObject("msg", " Welcome to demo page.");
		return modelView;
	}

	@RequestMapping("/PathVariable/{name}/{age}")
	protected ModelAndView b1(@PathVariable(value="name") String name, @PathVariable("age") String age) throws Exception {
		ModelAndView modelView = new ModelAndView("/hello/PathVariablePage");
		modelView.addObject("msg", "Hi PathVariable " + name + ". \n Your age is " + age);
		return modelView;
	}

	@RequestMapping("/PathVariableMap/{name}/{age}")
	protected ModelAndView b2(@PathVariable Map<String, String> pathVars) throws Exception {
		ModelAndView modelView = new ModelAndView("/hello/PathVariablePage");
		String name = pathVars.get("name");
		String age = pathVars.get("age");
		modelView.addObject("msg", "Hi PathVariableMap " + name + ". \n Your age is " + age);
		return modelView;
	}

	@RequestMapping(value="/RequestParam", method=RequestMethod.POST)
	protected ModelAndView c1(@RequestParam String name, @RequestParam String age) throws Exception {
		ModelAndView modelView = new ModelAndView("/hello/RequestParamPage");
		modelView.addObject("msg", "Hi RequestParam " + name + ". \n Your age is " + age);
		return modelView;
	}

	@RequestMapping("/RequestParamMap")
	protected ModelAndView c2(@RequestParam Map<String, String> requestVars) throws Exception {
		ModelAndView modelView = new ModelAndView("/hello/RequestParamPage");
		String name = requestVars.get("name");
		String age = requestVars.get("age");
		modelView.addObject("msg", "Hi " + name + ". \n Your age is " + age);
		return modelView;
	}

}
