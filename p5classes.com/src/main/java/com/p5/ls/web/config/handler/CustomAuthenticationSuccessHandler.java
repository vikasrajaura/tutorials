package com.p5.ls.web.config.handler;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.p5.ls.web.model.CustomUser;
import com.p5.ls.web.service.IUserService;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	protected Log logger = LogFactory.getLog(this.getClass());

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	IUserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		handle(request, response, authentication);
		//clearAuthenticationAttributes(request);
		saveLoggedinTime();
	}

	private void saveLoggedinTime()throws IOException {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUser customUser =null;
		if (principal instanceof CustomUser) {
			customUser = (CustomUser) principal;
		}
		userService.updateLastLogin(Timestamp.from(Instant.now()), customUser.getUser().getUserId());
	}
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {

		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication) {
		boolean isSuperUser = false;
		boolean isDbaUser = false;
		boolean isOtherUser = false;
		boolean isStudentUser = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_SUPER_USER")) {
				isSuperUser = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_DBA_USER")) {
				isDbaUser = true;
				break;
			} else if(grantedAuthority.getAuthority().equals("ROLE_STUDENT_USER")) {
				isStudentUser = true;
				break;
			} 
		}
		return "/welcome";
		/*
		if (isDbaUser) {
			return "/welcome";
		} else if (isSuperUser) {
			return "/admin";
		} else {
			throw new IllegalStateException();
		}
		*/
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
}