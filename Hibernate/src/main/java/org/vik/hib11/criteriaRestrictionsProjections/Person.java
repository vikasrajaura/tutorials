package org.vik.hib11.criteriaRestrictionsProjections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON11")
@NamedQueries({ @NamedQuery(name = "person.byId", query = "from Person where personId= ?"),
		@NamedQuery(name = "person.ageGreaterThan", query = "from Person where age > ?"),
		@NamedQuery(name = "person.byLastName", query = "from Person where lastname= ?") })
@NamedNativeQueries({
		@NamedNativeQuery(name = "person.ByFirstName", query = "select * from person10 where first_name= ? ", resultClass = Person.class),
		@NamedNativeQuery(name = "person.ByLastName", query = "select * from person10 where first_name= ? ", resultClass = Person.class),
		@NamedNativeQuery(name = "person.ByAgeName", query = "select * from person10 where first_name= ? ", resultClass = Person.class) })
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSON_ID")
	private int personId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "AGE")
	private int age;

	@Column(name = "SALARY")
	private int salary;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Person() {
		super();
	}

	public Person(String firstName, String lastName, int age, int salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
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
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", salary=" + salary + "]";
	}

}
