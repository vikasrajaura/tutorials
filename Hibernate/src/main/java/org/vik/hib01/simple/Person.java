package org.vik.hib01.simple;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.vik.vo.Address;

@Entity(name="PERSON01")
@Table(name = "PERSON01")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSON_ID")
	private int personId;

	@Column(name = "DOB")
	private LocalDate dob;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Transient
	private int age;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET")),
			@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE")),
			@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY")),
			@AttributeOverride(name = "pincode", column = @Column(name = "OFFICE_PINCODE")) })
	private Address officeAddress;

	@Embedded
	private Address address;

	public Person() {
		super();
	}

	public Person(int personId, LocalDate dob, String firstName, String middleName, String lastName, int age,
			Address officeAddress, Address address) {
		super();
		this.personId = personId;
		this.dob = dob;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.officeAddress = officeAddress;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", dob=" + dob + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", age=" + age + ", officeAddress=" + officeAddress
				+ ", address=" + address + "]";
	}

	public static Person getPerson() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);

		return new Person(randomNum, LocalDate.of(1989, 2, 17), "firstName" + randomNum, "middleName", "lastName",
				randomNum, null, null);

	}

	public int getPersonId() {
		return personId;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public Address getAddress() {
		return address;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
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

	public void setAge(int age) {
		this.age = age;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
