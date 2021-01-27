package org.vik.hib03.oneToOne;

import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "PERSON03")
@Table(name = "PERSON03")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSON_ID")
	private int personId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER/*,optional=true,targetEntity,mappedBy,*/)
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;

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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public static Person getPerson() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new Person("firstName" + randomNum);
	}

}
