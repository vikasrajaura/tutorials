package org.vik.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="WIFE")
public class Wife {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WIFE_ID")
	public int wifeId;

	@Column(name = "NAME")
	private String name;

	@OneToOne(mappedBy="wife")
	private StudentDetails student;
	
	
	public int getWifeId() {
		return wifeId;
	}

	public void setWifeId(int wifeId) {
		this.wifeId = wifeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentDetails getStudent() {
		return student;
	}

	public void setStudent(StudentDetails student) {
		this.student = student;
	}

}
