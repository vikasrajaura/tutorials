package com.vik.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vik.model.Customer;
import com.vik.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] { /*"middleName"*/ });
	/*	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		binder.registerCustomEditor(Date.class, "dob",new CustomDateEditor(dateFormat, false));
	*/
		
	}

	@ModelAttribute
	public void addingObjects(Model model1) {
		model1.addAttribute("headerMessage", "Learnig Management!");
	}

	@RequestMapping("/StudentForm")
	public ModelAndView studentForm() {
		ModelAndView model = new ModelAndView("/student/StudentForm");
		return model;
	}

	
	@RequestMapping(value = "/StudentFormSubmit", method = RequestMethod.POST)
	public ModelAndView studentFormAction(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("/student/StudentForm");
			return model;
		}
		ModelAndView model = new ModelAndView("/student/StudentSuccess");
		return model;
	}

	@RequestMapping(value = "/StudentForm1", method = RequestMethod.GET)
	public ModelAndView viewLoginPage(@ModelAttribute Student student) {
		ModelAndView model = new ModelAndView("/student/StudentForm1");
		return model;
	}


	@RequestMapping(value = "/StudentFormSubmit1", method = RequestMethod.POST)
	public ModelAndView studentFormAction1(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		System.out.println(student.getMiddleName()+","+student.getGender()+","+student.getAge()+","+student.getHobby());
		ModelAndView model;
		if (result.hasErrors()) {
			model = new ModelAndView("/student/StudentForm1");
			return model;
		}
		model = new ModelAndView("/student/StudentSuccess");
		return model;
	}

	

}
