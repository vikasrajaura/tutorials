package com.p5.ls.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CLAS")
public class Clas implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLAS_ID")
	private Long clasId;
	
	@Size(min=2, max=50, message="{0} must have length {2} to {1}")
	@Column(name = "CLAS_NAME", length = 100, unique =true, nullable = false )
	private String clasName;

	@Column(name = "STAGE", length = 100)
	private String stage;

	@Column(name = "DETAILS", length = 500)
	private String details;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clasId == null) ? 0 : clasId.hashCode());
		result = prime * result + ((clasName == null) ? 0 : clasName.hashCode());
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
		Clas other = (Clas) obj;
		if (clasId == null) {
			if (other.clasId != null)
				return false;
		} else if (!clasId.equals(other.clasId))
			return false;
		if (clasName == null) {
			if (other.clasName != null)
				return false;
		} else if (!clasName.equals(other.clasName))
			return false;
		return true;
	}

	public Long getClasId() {
		return clasId;
	}

	public void setClasId(Long clasId) {
		this.clasId = clasId;
	}

	public String getClasName() {
		return clasName;
	}

	public void setClasName(String clasName) {
		this.clasName = clasName;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	
}
