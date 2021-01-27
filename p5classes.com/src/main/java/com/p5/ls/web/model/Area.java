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
import javax.validation.constraints.Size;

@Entity
@Table(name = "AREA")
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AREA_ID")
	private Long areaId;
	
	@Size(min=2, max=100, message="{0} must have length {2} to {1}")
	@Column(name = "AREA_NAME")
	private String areaName;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "DETAILS")
	private String details;
	
	@Column(name = "NORMAL_CAP")
	private Integer normalCap;

	@Column(name = "MAX_CAP")
	private Integer maxCap;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BRANCH_ID", nullable=true, updatable = false)
	private Branch branch;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="AREA_ID")
	private Set<Section> sections = new HashSet<>();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaId == null) ? 0 : areaId.hashCode());
		result = prime * result + ((areaName == null) ? 0 : areaName.hashCode());
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
		Area other = (Area) obj;
		if (areaId == null) {
			if (other.areaId != null)
				return false;
		} else if (!areaId.equals(other.areaId))
			return false;
		if (areaName == null) {
			if (other.areaName != null)
				return false;
		} else if (!areaName.equals(other.areaName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaName=" + areaName + ", type=" + type + ", details=" + details
				+ ", normalCap=" + normalCap + ", maxCap=" + maxCap + ", branch=" + branch + "]";
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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

	public Integer getNormalCap() {
		return normalCap;
	}

	public void setNormalCap(Integer normalCap) {
		this.normalCap = normalCap;
	}

	public Integer getMaxCap() {
		return maxCap;
	}

	public void setMaxCap(Integer maxCap) {
		this.maxCap = maxCap;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

}
