package com.vik.model;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.vik.embeddable.Contact;

public class Student {
	
	@Size(min=1, max=10)
	private String firstName;
	
	@Size(min=1, max=10, message="{0} must1 have length {2} to {1}")
	private String middleName;
	
	@NotBlank(message="{0} can not be blank")
	private String lastName;
	
	@NotEmpty(message="{0} should not be empty")
	private String gender;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
    @NotNull @Past
	private Date dob;
	
	@NotNull(message="{0} can't be null")
	@Max(value=70)
	@Min(value=10)
	private Integer age;
	
	@NotEmpty(message="{0} should not be empty")
	private String hobby;
	
	@NotEmpty(message="Select Skills")
	private ArrayList<String> skills;

	@Valid
	private Contact contact;

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public Date getDob() {
		return dob;
	}

	public String getHobby() {
		return hobby;
	}

	public ArrayList<String> getSkills() {
		return skills;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
