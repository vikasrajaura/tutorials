package com.p5.ls.web.config.security;

import org.jboss.aerogear.security.otp.Totp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.p5.ls.web.model.CustomUser;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired(required = true)
	UserDetailsService customUserDetailsService;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		// User user = UserUtil.getUser(auth);
		String username = String.valueOf(auth.getPrincipal());
		String password = String.valueOf(auth.getCredentials());
		String verificationCode = ((CustomWebAuthenticationDetails) auth.getDetails()).getVerificationCode();

		CustomUser customUserFromDb = (CustomUser) customUserDetailsService.loadUserByUsername(username);

		if (customUserFromDb == null || !passwordEncoder.matches(password, customUserFromDb.getPassword())) {
			throw new BadCredentialsException("Invalid username or password");
		}

		// apply authenticator concept only when secret is code exists in db for that user
		if (!StringUtils.isEmpty(customUserFromDb.getUser().getSecret())) {

			// to verify verification code
			Totp totp = new Totp(customUserFromDb.getUser().getSecret());
			try {
				if (!totp.verify(verificationCode)) {
					throw new BadCredentialsException("Invalid verification code");
				}
			} catch (Exception e) {
				throw new BadCredentialsException("Invalid verification code");
			}

		}

		return new UsernamePasswordAuthenticationToken(customUserFromDb, password,
				customUserFromDb.getAllRolesAndAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
