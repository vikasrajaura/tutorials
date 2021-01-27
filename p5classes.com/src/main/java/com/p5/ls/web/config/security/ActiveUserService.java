package com.p5.ls.web.config.security;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.p5.ls.web.service.IUserService;

@Service
public class ActiveUserService {

	@Autowired
	SessionRegistry sessionRegistry;
	
	@Autowired
	IUserService userSerivce;
	
	public List<String> getAllActiveUserNames() {
		List<Object> principles = sessionRegistry.getAllPrincipals();
		User[] users = principles.toArray(new User[principles.size()]);

		return Arrays.stream(users).filter(u -> !sessionRegistry.getAllSessions(u, false).isEmpty())
				.map(u -> u.getUsername()).collect(Collectors.toList());
	}
	
	public int getAllActiveUsers(){
		return getAllActiveUserNames().size();
	}
	
}
