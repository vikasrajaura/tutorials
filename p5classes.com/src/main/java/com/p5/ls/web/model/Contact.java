package com.p5.ls.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "CONTACT")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTACT_ID")
	private Long contactId;
	
	@NotBlank(message = "{0} can not be blank.")
	@Size(min = 10, max = 10, message = "Mobile Number must have {1} digits")
	@Pattern(regexp = "[0-9]+", message = "Please Enter numeric value.")
	@Column(name = "PRIMARY_NUM", nullable = false)
	private String primaryNum;

	@NotBlank(message = "{0} can not be blank.")
	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "Please Enter valid mail.")
	@Column(name = "PRIMARY_EMAIL", nullable = false)
	private String primaryEmail;
	
	@Size(min = 10, max = 10, message = "Mobile Number must have {1} digits")
	@Pattern(regexp = "[0-9]+", message = "Please Enter numeric value.")
	@Column(name = "OTHER_NUM")
	private String otherNum;

	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "Please Enter valid email.")
	@Column(name = "OTHER_EMAIL")
	private String otherEmail;

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getPrimaryNum() {
		return primaryNum;
	}

	public void setPrimaryNum(String primaryNum) {
		this.primaryNum = primaryNum;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getOtherNum() {
		return otherNum;
	}

	public void setOtherNum(String otherNum) {
		this.otherNum = otherNum;
	}

	public String getOtherEmail() {
		return otherEmail;
	}

	public void setOtherEmail(String otherEmail) {
		this.otherEmail = otherEmail;
	}
	
}
