package com.p5.ls.web.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.ui.context.ThemeSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.p5.ls.web.config.db.HibernateConfig;
import com.p5.ls.web.config.security.SecurityConfig;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.p5.ls.web.config")
@Import({ SecurityConfig.class, HibernateConfig.class, MailConfig.class })
public class WebConfig implements WebMvcConfigurer {

	/**
	 * Configure ViewResolvers to deliver preferred views.
	 */
	public void configureViewResolvers(ViewResolverRegistry registry) {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}

	/**
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript
	 * etc...
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	/**
	 * Configure MessageSource to lookup any validation/error message in
	 * internationalized property files
	 */

	/**
	 * Optional. It's only required when handling '.' in @PathVariables which
	 * otherwise ignore everything after last '.' in @PathVaidables argument. It's a
	 * known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present
	 * in Spring 4.1.7. This is a workaround for this issue.
	 */
	public void configurePathMatch(PathMatchConfigurer matcher) {
		matcher.setUseRegisteredSuffixPatternMatch(true);
	}

	/* Theme specific start */
	@Bean
	public ThemeSource themeSource() {
		ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource();
		themeSource.setBasenamePrefix("theme-");
		return themeSource;
	}

	@Bean
	public CookieThemeResolver themeResolver() {
		CookieThemeResolver themeResolver = new CookieThemeResolver();
		themeResolver.setDefaultThemeName("green");
		themeResolver.setCookieName("mythemecookie");
		return themeResolver;
	}
	/* End */

	/* Internationalization and Localization specific: start */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("/resources/properties/labels/Label", "/resources/properties/error/ErrorMessages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieName("language");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}
	/* End */

	// Register interceptors
	public void addInterceptors(InterceptorRegistry registry) {
		// Internationalization and Localization specific
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("siteLanguage");
		registry.addInterceptor(interceptor);
		// Theme specific
		ThemeChangeInterceptor themeInterceptor = new ThemeChangeInterceptor();
		themeInterceptor.setParamName("siteTheme");
		registry.addInterceptor(themeInterceptor);
	}

	///////////////////////
	@Bean
	public View jsonTemplate() {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true);
		return view;
	}

	@Bean
	public ViewResolver viewResolver() {
		return new BeanNameViewResolver();
	}

	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	
}
