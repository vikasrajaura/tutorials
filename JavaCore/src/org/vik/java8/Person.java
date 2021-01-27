package org.vik.java8;

public class Person {

	private int personId;

	private String firstName;

	private String lastName;

	private int age;

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

	public Person(int personId, String firstName, String lastName, int age, int salary) {
		super();
		this.personId = personId;
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
