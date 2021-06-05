package com.evidhyalya.users.model;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

//@Entity(name="User")
//@Table(name = "USERS")
//@EntityListeners(AuditingEntityListener.class)
public class CustomUser1 {//extends org.springframework.security.core.userdetails.User {
/*	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long userId;

	@NotBlank
	@Size(min = 3, max = 20, message = "{0} must be between {2} and {1} characters")
	@Column(name = "USERNAME", unique = true, nullable = false, length = 20)
	private String userName;

	@NotBlank
	@Column(name = "PASSWORD", nullable = false, length = 100)
	private String password;

	@NotBlank
	@Email
	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Size(max = 20, message = "{0} can't exceed {1} characters")
	@Column(name = "LAST_NAME", nullable = true)
	private String lastName;


	@Column(name = "GENDER")
	private String gender;

	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DOB")
	private Date dob;

	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name = "users_roles_map", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@Column(name = "LAST_LOGIN", nullable = true)
	private Timestamp lastLogin;

	@Column(name = "IS_ACT_EXPIRED")
	private boolean isAccountExpired;

	@Column(name = "IS_ACT_LOCKED")
	private boolean isAccountLocked;

	@Column(name = "IS_CRED_EXPIRED")
	private boolean isCredentialsExpired;

	@Column(name = "IS_ENABLED")
	private boolean isEnabled = true;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRANCH_ID", updatable = false)
	private Branch branch;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ORG_ID", updatable = false)
	private Org org;

	@Transient
	private List<Long> roleIds;

	@Column(name = "secret")
	private String secret;

	@Transient
	private Set<Long> grantedRoleIds;
	
	@Transient
	private Set<String> grantedRoleNames;
	
	@Transient
	private Set<String> grantedAuthorities;
	
	@Transient
	private Set<GrantedAuthority> allRolesAndAuthorities;

	public CustomUser1(String userName, String password, Map<Long, String> grantedRoleMap, Set<String> grantedAuthorities, Set<GrantedAuthority> allRolesAndAuthorities) {
		super(userName, password, allRolesAndAuthorities);
		this.grantedRoleIds=grantedRoleMap.keySet();
		this.grantedRoleNames=grantedRoleMap.values().stream().collect(Collectors.toSet()); 
		this.grantedAuthorities=grantedAuthorities;
		this.allRolesAndAuthorities=allRolesAndAuthorities;
		System.out.println("grantedRoleIds:"+grantedRoleIds);
		System.out.println("grantedRoleNames:"+grantedRoleNames);
		System.out.println("grantedAuthorities:"+grantedAuthorities);
	}

	public CustomUser1() {
		super("vikas", "vikas", arg2)
	}
	
	private final static Set<GrantedAuthority> getGrantedAuthorities(List<String> rolesAndAuthorities) {
		return rolesAndAuthorities.stream().map(p -> new SimpleGrantedAuthority(p)).collect(Collectors.toSet());
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((org == null) ? 0 : org.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomUser other = (CustomUser) obj;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (org == null) {
			if (other.org != null)
				return false;
		} else if (!org.equals(other.org))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public Timestamp getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}


	public boolean isAccountExpired() {
		return isAccountExpired;
	}


	public void setAccountExpired(boolean isAccountExpired) {
		this.isAccountExpired = isAccountExpired;
	}


	public boolean isAccountLocked() {
		return isAccountLocked;
	}


	public void setAccountLocked(boolean isAccountLocked) {
		this.isAccountLocked = isAccountLocked;
	}


	public boolean isCredentialsExpired() {
		return isCredentialsExpired;
	}


	public void setCredentialsExpired(boolean isCredentialsExpired) {
		this.isCredentialsExpired = isCredentialsExpired;
	}


	public boolean isEnabled() {
		return isEnabled;
	}


	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}


	public Branch getBranch() {
		return branch;
	}


	public void setBranch(Branch branch) {
		this.branch = branch;
	}


	public Org getOrg() {
		return org;
	}


	public void setOrg(Org org) {
		this.org = org;
	}


	public List<Long> getRoleIds() {
		return roleIds;
	}


	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}


	public String getSecret() {
		return secret;
	}


	public void setSecret(String secret) {
		this.secret = secret;
	}


	public Set<Long> getGrantedRoleIds() {
		return grantedRoleIds;
	}


	public void setGrantedRoleIds(Set<Long> grantedRoleIds) {
		this.grantedRoleIds = grantedRoleIds;
	}


	public Set<String> getGrantedRoleNames() {
		return grantedRoleNames;
	}


	public void setGrantedRoleNames(Set<String> grantedRoleNames) {
		this.grantedRoleNames = grantedRoleNames;
	}


	public Set<String> getGrantedAuthorities() {
		return grantedAuthorities;
	}


	public void setGrantedAuthorities(Set<String> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}


	public Set<GrantedAuthority> getAllRolesAndAuthorities() {
		return allRolesAndAuthorities;
	}


	public void setAllRolesAndAuthorities(Set<GrantedAuthority> allRolesAndAuthorities) {
		this.allRolesAndAuthorities = allRolesAndAuthorities;
	}


	public String getFullName() {
		if (StringUtils.isEmpty(middleName))
			return firstName + " " + lastName;
		else
			return firstName + " " + middleName + " " + lastName;
	}



*/
}
