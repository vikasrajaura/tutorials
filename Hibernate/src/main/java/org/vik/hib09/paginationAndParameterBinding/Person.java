package org.vik.hib09.paginationAndParameterBinding;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON09")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSON_ID")
	private int personId;

	@Column(name = "FIRST_NAME")
	private String firstName;
	

	public Person() {
		super();
	}

	public Person(String firstName) {
		super();
		this.firstName = firstName;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + "]";
	}

	public static Person getPerson() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new Person("firstName");
	}

}
