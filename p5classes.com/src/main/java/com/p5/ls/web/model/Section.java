package com.p5.ls.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SECTION")
public class Section {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SECTION_ID")
	private Long sectionId;
	
	@Size(min=1, max=100, message="{0} must have length {2} to {1}")
	@Column(name = "SECTION_NAME", nullable = false, unique = true, length = 100)
	private String sectionName;

	@Size(max=100, message="Maximum {1} characters allowed")
	@Column(name = "TYPE", length = 100)
	private String type;

	@Size(max=500, message="Maximum {1} characters allowed")
	@Column(name = "DETAILS", length = 500)
	private String details;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="AREA_ID", nullable=true, updatable = true)
	private Area area;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CLASS_ID", nullable=true, updatable = true)
	private Clas clas;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BRANCH_ID", nullable=true, updatable = false)
	private Branch branch;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
		result = prime * result + ((sectionName == null) ? 0 : sectionName.hashCode());
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
		Section other = (Section) obj;
		if (sectionId == null) {
			if (other.sectionId != null)
				return false;
		} else if (!sectionId.equals(other.sectionId))
			return false;
		if (sectionName == null) {
			if (other.sectionName != null)
				return false;
		} else if (!sectionName.equals(other.sectionName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Section [sectionId=" + sectionId + ", sectionName=" + sectionName + ", type=" + type + ", details="
				+ details + ", area=" + area + "]";
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Clas getClas() {
		return clas;
	}

	public void setClas(Clas clas) {
		this.clas = clas;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
}
