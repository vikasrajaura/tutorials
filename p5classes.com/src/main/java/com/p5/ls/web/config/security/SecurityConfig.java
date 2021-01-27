package com.p5.ls.web.config.security;

import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.p5.ls.web.model.CustomUser;
import com.p5.ls.web.model.User;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.p5.ls.web"})
@ImportResource({ "classpath:appconfig-security.xml" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	@Autowired
	private CustomWebAuthenticationDetailsSource authenticationDetailsSource; 
*/
	public SecurityConfig() {
		super();
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
	
	@Qualifier("customUserDetailsService")
	@Autowired
	UserDetailsService customUserDetailsService;

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(customUserDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
		PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
				"remember-me", customUserDetailsService, persistentTokenRepository());
		return tokenBasedservice;
	}

	@Autowired
	DataSource dataSource;

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}

	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}

	@Bean
	public AuditorAware<User> auditorProvider() {
		return new AuditorAwareImpl();
	}

	class AuditorAwareImpl implements AuditorAware<User> {

		@Override
		public Optional<User> getCurrentAuditor() {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			CustomUser customUser = null;
			if (principal instanceof CustomUser) {
				customUser = (CustomUser) principal;
			}
			User user = customUser.getUser();
			return Optional.of(user);
		}

	}
	
}
