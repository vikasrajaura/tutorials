package org.vik.hib02.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "PERSON02")
@Table(name = "PERSON02")
public class Person {

	public Person() {
		super();
	}

	public Person(int personId, Date dob, String firstName) {
		super();
		this.personId = personId;
		this.dob = dob;
		this.firstName = firstName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSON_ID")
	private int personId;

	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	private Date dob;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "PERSON_CHAIR", joinColumns = @JoinColumn(name = "PERSON_ID"))
	Collection<Chair> personChairList = new ArrayList<Chair>();

	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "PERSON_BOOK", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	Collection<Book> personBookList = new ArrayList<Book>();

	@ElementCollection
	@CollectionTable(name = "PERSON_PEN", joinColumns = @JoinColumn(name = "PERSON_ID"))
	@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name = "PEN_IDA") }, generator =	 "sequence-gen", type = @Type(type = "int"))
	private Collection<String> pens = new ArrayList<String>();

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Collection<Chair> getPersonChairList() {
		return personChairList;
	}

	public void setPersonChairList(Collection<Chair> personChairList) {
		this.personChairList = personChairList;
	}

	public Collection<Book> getPersonBookList() {
		return personBookList;
	}

	public void setPersonBookList(Collection<Book> personBookList) {
		this.personBookList = personBookList;
	}

	public Collection<String> getPens() {
		return pens;
	}

	public void setPens(Collection<String> pens) {
		this.pens = pens;
	}

	public static Person getPerson() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new Person(randomNum, new Date(), "firstName" + randomNum);
	}

}
