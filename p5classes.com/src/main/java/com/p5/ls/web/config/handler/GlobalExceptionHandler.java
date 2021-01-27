package com.p5.ls.web.config.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception e) {
		ModelAndView mv = new ModelAndView("exception");
		mv.addObject("exceptionMsg", "NullPointer Exception Occured");
		mv.addObject("stackTrace", "Details: "+e);
		return mv;
	}

	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mv = new ModelAndView("exception");
		mv.addObject("exceptionMsg", "Some Exception Occured");
		mv.addObject("stackTrace", "Details: "+e);
		return mv;
	}
}
