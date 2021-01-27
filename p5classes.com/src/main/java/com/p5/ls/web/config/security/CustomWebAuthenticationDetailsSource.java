package com.p5.ls.web.config.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomWebAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails>{

	@Override
	public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
		// TODO Auto-generated method stub
		return new CustomWebAuthenticationDetails(context);
	}

}
