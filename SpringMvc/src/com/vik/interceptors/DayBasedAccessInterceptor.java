package com.vik.interceptors;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayBasedAccessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

		LocalDateTime dateTime = LocalDateTime.now();
		if (dateTime.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
			res.getWriter().write("WebSite is closed on " + DayOfWeek.MONDAY);
			return false;
		} else
			return true;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView)
			throws Exception {
		// This method would be called after Spring MVC executes the request
		// handler method for the request.
	}

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex)
			throws Exception {
		// This method would be called after the response object is produced by
		// the view for the request.
	}

}
