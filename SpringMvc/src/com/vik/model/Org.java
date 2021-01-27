package com.vik.model;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vik.embeddable.Contact;

public class Org {
	
	@NotNull
	@Digits(integer=10, fraction=0, message="Maximum {2} digits allowed")
	private Long orgId;
	
	@Size(min=1, max=200)
	private String orgName;
	
	@Size(min=1, max=1000, message="{0} must have length {2} to {1}")
	private String desc;
	
	@Valid
	private Contact contact;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
