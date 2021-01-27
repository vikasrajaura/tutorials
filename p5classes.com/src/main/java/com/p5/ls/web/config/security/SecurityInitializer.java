package com.p5.ls.web.config.security;

import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.support.MultipartFilter;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		insertFilters(servletContext, new MultipartFilter());
	}

}
