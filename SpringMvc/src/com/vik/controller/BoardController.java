package com.vik.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vik.model.Board;

@Controller
@RequestMapping("/board")
public class BoardController {


	@ModelAttribute
	public void addingObjects(Model model1) {
		model1.addAttribute("headerMessage", "Learnig Management!");
	}

	@RequestMapping(value = "/BoardForm", method = RequestMethod.GET)
	public ModelAndView viewBoardForm(@ModelAttribute Board board) {
		ModelAndView model = new ModelAndView("/board/BoardForm");
		return model;
	}

	@RequestMapping(value = "/BoardFormSubmit", method = RequestMethod.POST)
	public ModelAndView boardFormAction(@Valid @ModelAttribute("board") Board board, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("/board/BoardForm");
			return model;
		}
		ModelAndView model = new ModelAndView("/board/BoardSuccess");
		return model;
	}

}
