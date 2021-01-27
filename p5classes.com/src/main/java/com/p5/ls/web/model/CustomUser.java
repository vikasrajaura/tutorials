package com.p5.ls.web.model;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;

public final class CustomUser extends org.springframework.security.core.userdetails.User {

	private com.p5.ls.web.model.User user;
	private Set<Long> grantedRoleIds;
	private Set<String> grantedRoleNames;
	private Set<String> grantedAuthorities;
	Set<GrantedAuthority> allRolesAndAuthorities;
	
	public CustomUser(com.p5.ls.web.model.User user, Map<Long, String> grantedRoleMap, Set<String> grantedAuthorities, Set<GrantedAuthority> allRolesAndAuthorities) {
		super(user.getUserName(), user.getPassword() , allRolesAndAuthorities);
		this.user=user;
		this.grantedRoleIds=grantedRoleMap.keySet();
		this.grantedRoleNames=grantedRoleMap.values().stream().collect(Collectors.toSet()); 
		this.grantedAuthorities=grantedAuthorities;
		this.allRolesAndAuthorities=allRolesAndAuthorities;
		System.out.println("grantedRoleIds:"+grantedRoleIds);
		System.out.println("grantedRoleNames:"+grantedRoleNames);
		System.out.println("grantedAuthorities:"+grantedAuthorities);
	}

	public boolean hasRoleId(final Long roleId) {
		return this.grantedRoleIds.contains(roleId);
	}
	
	public boolean hasRole(final String role) {
		return this.grantedRoleNames.contains(role);
	}
	
	public boolean hasAuthority(final String authority) {
		return this.grantedAuthorities.contains(authority);
	}
	
	public com.p5.ls.web.model.User getUser() {
		return user;
	}

	public Set<Long> getGrantedRoleIds() {
		return grantedRoleIds;
	}

	public Set<String> getGrantedRoleNames() {
		return grantedRoleNames;
	}

	public Set<String> getGrantedAuthorities() {
		return grantedAuthorities;
	}
	
	public Set<GrantedAuthority> getAllRolesAndAuthorities() {
		return allRolesAndAuthorities;
	}
	
	public Long getOrgId() {
		return user.getOrgId();
	}

	public Long getBranchId() {
		if(user.getBranch()!=null)
		return user.getBranch().getBranchId();
		else return null;
	}

}