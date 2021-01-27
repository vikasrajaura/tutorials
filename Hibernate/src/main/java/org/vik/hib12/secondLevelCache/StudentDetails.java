package org.vik.hib12.secondLevelCache;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.vik.vo.Address;

@Entity
@Table(name = "STUDENT_DETAILS")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class StudentDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private int studentId;

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

	
	@Override
	public String toString() {
		return "StudentDetails [studentId=" + studentId + ", dob=" + dob + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", age=" + age + ", officeAddress=" + officeAddress+"]";
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {

		this.studentId = studentId;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return Period.between(this.getDob(),LocalDate.now()).getYears();
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

}
