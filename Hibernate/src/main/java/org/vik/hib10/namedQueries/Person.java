package org.vik.hib10.namedQueries;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// resultClass=Person.class should be provided in NamedNativeQuery else this will show classCastException
// during getting result
@Entity(name = "PERSON10")
@Table(name = "PERSON10")
@NamedQuery(name="personById",query="from PERSON10 where personId= ?")
@NamedNativeQuery(name="personByFirstName",query="select * from person10 where first_name= ? ",resultClass=Person.class)
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
