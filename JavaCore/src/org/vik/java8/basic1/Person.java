package org.vik.java8.basic1;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private int personId;
	private String firstName;
	private String lastName;
	private int age;
	private int salary;
	private int deptId;
	
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

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
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
				+ ", salary=" + salary + ", deptId=" + deptId + "]";
	}

	public Person() {
		super();
	}

	public Person(int personId, String firstName, String lastName, int age, int salary, int deptId) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
		this.deptId=deptId;
	}

	private static List<Person> pl;
	
	public static  List<Person> getPersonList() {
		pl = new ArrayList<>();
		pl.add(new Person(11, "Vikas", "Rajaura", 28, 30000, 1));
		pl.add(new Person(12, "Rahul", "Singh", 26, 32000,2));
		pl.add(new Person(13, "Suresh", "Pal", 24, 33000,1));
		pl.add(new Person(14, "Dinesh", "Rajaura", 30, 38000,3));
		pl.add(new Person(15, "Tinku", "Payal", 40, 39000,4));
		pl.add(new Person(16, "Deepa", "Chaudhary", 20, 46000,2));
		pl.add(new Person(17, "Teena", "Kumari", 18, 22000,1));
		pl.add(new Person(18, "Nitu", "Kumari", 25, 28000,4));
		pl.add(new Person(19, "Kamal", "Singh", 22, 26000,2));
		return pl;
	}

}
