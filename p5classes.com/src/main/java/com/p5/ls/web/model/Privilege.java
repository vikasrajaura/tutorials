package com.p5.ls.web.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRIVILEGES")
public class Privilege {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRIV_ID")
	private Long privId;

	@Column(name = "PRIV_NAME", unique = true, nullable = false, length = 200)
	private String privName;

	@Column(name = "DETAILS", length = 500)
	private String details;

	@Column(name = "MAPPED_PATH", length = 200)
	private String mappedPath;

	@Column(name = "PAGE_ID", length = 100)
	private String pageId;

	@ManyToMany(mappedBy = "privileges", fetch = FetchType.LAZY)
	private Set<Role> roles = new HashSet<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((privId == null) ? 0 : privId.hashCode());
		result = prime * result + ((privName == null) ? 0 : privName.hashCode());
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
		Privilege other = (Privilege) obj;
		if (privId == null) {
			if (other.privId != null)
				return false;
		} else if (!privId.equals(other.privId))
			return false;
		if (privName == null) {
			if (other.privName != null)
				return false;
		} else if (!privName.equals(other.privName))
			return false;
		return true;
	}

	public Long getPrivId() {
		return privId;
	}

	public void setPrivId(Long privId) {
		this.privId = privId;
	}

	public String getPrivName() {
		return privName;
	}

	public void setPrivName(String privName) {
		this.privName = privName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	public String getMappedPath() {
		return mappedPath;
	}

	public void setMappedPath(String mappedPath) {
		this.mappedPath = mappedPath;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}


}
