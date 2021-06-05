package com.evidhyalya.users.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
import org.springframework.util.StringUtils;

@Entity(name="User")
@Table(name = "USERS")
@EntityListeners(AuditingEntityListener.class)
public class UserDetails {
	
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

	@Embedded
	private AuditAttributes auditAttributes;

	@Transient
	private List<Long> roleIds;

	@Column(name = "secret")
	private String secret;

	public UserDetails() {
		super();
	}

	public UserDetails(Long userId, String userName, String password, String firstName, String middleName, String lastName,
			String email, String gender, Date dob, Set<Role> roles, Timestamp lastLogin, boolean isAccountExpired,
			boolean isAccountLocked, boolean isCredentialsExpired, boolean isEnabled, Branch branch, Org org,
			AuditAttributes auditAttributes, List<Long> roleIds) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.roles = roles;
		this.lastLogin = lastLogin;
		this.isAccountExpired = isAccountExpired;
		this.isAccountLocked = isAccountLocked;
		this.isCredentialsExpired = isCredentialsExpired;
		this.isEnabled = isEnabled;
		this.branch = branch;
		this.org = org;
		this.auditAttributes = auditAttributes;
		this.roleIds = roleIds;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
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

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public boolean isEnabled() {
		return isEnabled;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public AuditAttributes getAuditAttributes() {
		return auditAttributes;
	}

	public void setAuditAttributes(AuditAttributes auditAttributes) {
		this.auditAttributes = auditAttributes;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
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

	public String getSecret() {
		return this.secret;
	}

	public void setSecret(final String secret) {
		this.secret = secret;
	}

	public Long getOrgId() {
		if (org != null)
			return org.getOrgId();
		else
			return null;
	}

	public String getOrgName() {
		if (org != null)
			return org.getOrgName();
		else
			return null;
	}

	public byte[] getOrgLogo() {
		if (org != null)
			return org.getLogoImage();
		else
			return null;
	}

	public String getFullName() {
		if (StringUtils.isEmpty(middleName))
			return firstName + " " + lastName;
		else
			return firstName + " " + middleName + " " + lastName;
	}


}
