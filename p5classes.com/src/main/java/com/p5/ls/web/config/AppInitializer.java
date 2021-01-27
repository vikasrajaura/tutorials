package com.p5.ls.web.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.p5.ls.web.config.security.SecurityConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Provide configuration classes for Root App Context
		return new Class[] { WebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Provide configuration classes for Web App Context
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// Provide URLs to which Dispatcher Servlet Should be mapped to
		return new String[] { "/" };
	}

	
    private static final String LOCATION = "C:/fileserver/"; // Temporary location where files will be stored
    private static final long MAX_FILE_SIZE = 5242880; // 5MB : Max file size.
    private static final long MAX_REQUEST_SIZE = 20971520; // 20MB : Total request size containing Multi part.
    private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk

	@Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement( LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
        registration.setMultipartConfig(multipartConfigElement);
    }
 
}
