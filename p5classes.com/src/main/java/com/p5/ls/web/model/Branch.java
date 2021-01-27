package com.p5.ls.web.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "BRANCH")
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BRANCH_ID")
	private Long branchId;
	
	@Size(min=2, max=100, message="{0} must have length {2} to {1}")
	@Column(name = "BRANCH_NAME")
	private String branchName;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "DETAILS")
	private String details;

	@Column(name = "ADDRESS")
	private String address;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ORG_ID", nullable=false, updatable = false)
	private Org org;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "branch")
	private Set<User> users = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "branch")
	private Set<Area> areas = new HashSet<>();

	@Transient
	MultipartFile file;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	
	@Transient
	private Long orgId;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result + ((org == null) ? 0 : org.hashCode());
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
		Branch other = (Branch) obj;
		if (branchId == null) {
			if (other.branchId != null)
				return false;
		} else if (!branchId.equals(other.branchId))
			return false;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (org == null) {
			if (other.org != null)
				return false;
		} else if (!org.equals(other.org))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", type=" + type + ", details=" + details
				+ ", address=" + address + ", org=" + org + "]";
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
