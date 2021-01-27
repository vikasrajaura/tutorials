package org.vik.dto;

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

	@Embedded
	private Address address;

	@ElementCollection(fetch = FetchType.LAZY)
	 //@JoinColumn(name = "STUDENT_ID")
	// @JoinTable(name = "STUDENT_BOOK", joinColumns = @JoinColumn(name ="STUDENT_ID"), inverseJoinColumns=@JoinColumn(name="BOOK_ID"))
	@CollectionTable(name = "STUDENT_BOOK", joinColumns = @JoinColumn(name = "STUDENT_ID"))
	//@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	//@CollectionId(columns = { @Column(name = "BOOK_IDA") }, generator = "sequence-gen", type = @Type(type = "int"))
	Collection<Book> bookList = new ArrayList<Book>();

	@ElementCollection
	@CollectionTable(name = "STUDENT_PEN", joinColumns = @JoinColumn(name = "STUDENT_ID"))
	private Collection<String> pens = new ArrayList<String>();

	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER/*,optional=true,targetEntity,mappedBy,*/)
	@JoinColumn(name = "WIFE_ID")
	private Wife wife;

	@OneToMany(/*mappedBy = "owner", */cascade=CascadeType.PERSIST)
	@JoinTable(name="STUDENT_PLOT", joinColumns=@JoinColumn(name="PLOT_ID"), inverseJoinColumns=@JoinColumn(name="STUDENT_ID"))
	private Collection<Plot> plots = new HashSet<Plot>();

	@ManyToMany(mappedBy="students")
	//@JoinTable(name = "TEACHER_STUDENT", joinColumns = @JoinColumn(name = "TEACHER_ID"), inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
	Collection<Teacher> teachers = new HashSet<Teacher>();

	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="STUDENT_VEHICLE", joinColumns=@JoinColumn(name="VEHICLE_ID"), inverseJoinColumns=@JoinColumn(name="STUDENT_ID"))
	private Collection<Vehicle> vehicleList = new ArrayList<>();
	
	@Override
	public String toString() {
		return "StudentDetails [studentId=" + studentId + ", dob=" + dob + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", age=" + age + ", officeAddress=" + officeAddress
				+ ", address=" + address + ", bookList=" + bookList + ", pens=" + pens + ", wife=" + wife + ", plots="
				+ plots + ", teachers=" + teachers + ", vehicleList=" + vehicleList + "]";
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Collection<Book> getBookList() {
		return bookList;
	}

	public void setBookList(Collection<Book> bookList) {
		this.bookList = bookList;
	}

	public Collection<String> getPens() {
		return pens;
	}

	public void setPens(Collection<String> pens) {
		this.pens = pens;
	}

	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

	public Collection<Plot> getPlots() {
		return plots;
	}

	public void setPlots(Collection<Plot> plots) {
		this.plots = plots;
	}

	public Collection<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Collection<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Collection<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(Collection<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

}
