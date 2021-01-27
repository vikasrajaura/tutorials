package com.vik.embeddable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Contact {
	private int id;
	
	@NotBlank(message="{0} can not be blank.")
	@Size(min=10,max=10,message="Mobile Number must have {1} digits")
	@Pattern(regexp="[0-9]+", message="Please Enter numeric value.")
	private String mobileNumber;
	
	@NotBlank(message="{0} can not be blank.")
	@Pattern(regexp=".+@.+\\.[a-z]+", message="Please Enter valid mail.")
	private String email;

	public int getId() {
		return id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getEmail() {
		System.out.println("Hello1---");
		return email;
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
