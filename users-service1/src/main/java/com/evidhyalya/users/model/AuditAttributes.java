package com.evidhyalya.users.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Embeddable
public class AuditAttributes {

	@Column(name = "CREATED_BY", nullable = false, updatable = false)
	@CreatedBy
	private Long createdBy;

	@Column(name = "CREATED_TIME", nullable = false, updatable = false)
	@CreatedDate
	private Date createdTime;

	@Column(name = "UPDATED_BY", nullable = true, updatable = true)
	@LastModifiedBy
	private Long updatedBy;

	@LastModifiedDate
	@Column(name = "UPDATED_TIME", nullable = true, updatable = true)
	private Date updatedTime;

	public AuditAttributes() {
		super();
	}

	public AuditAttributes(Long createdBy, Date createdTime, Long updatedBy, Date updatedTime) {
		super();
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.updatedBy = updatedBy;
		this.updatedTime = updatedTime;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedDate() {
		return createdTime;
	}

	public Long getModifiedBy() {
		return updatedBy;
	}

	public Date getModifiedDate() {
		return updatedTime;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(Date createdTime) {
		this.createdTime = createdTime;
	}

	public void setModifiedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setModifiedDate(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedTime == null) ? 0 : updatedTime.hashCode());
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
		AuditAttributes other = (AuditAttributes) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdTime == null) {
			if (other.createdTime != null)
				return false;
		} else if (!createdTime.equals(other.createdTime))
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		if (updatedTime == null) {
			if (other.updatedTime != null)
				return false;
		} else if (!updatedTime.equals(other.updatedTime))
			return false;
		return true;
	}

}
