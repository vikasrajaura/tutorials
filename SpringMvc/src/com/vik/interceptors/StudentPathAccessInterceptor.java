package com.vik.interceptors;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class StudentPathAccessInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		
		LocalDateTime dateTime = LocalDateTime.now();
		if(dateTime.getDayOfWeek().equals(DayOfWeek.THURSDAY)){
			res.getWriter().write("All Student Resources is blocked on "+DayOfWeek.THURSDAY);
			return false;	
		}
		else return true;
	}
}
