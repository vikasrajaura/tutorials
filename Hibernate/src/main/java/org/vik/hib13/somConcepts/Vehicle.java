package org.vik.hib13.somConcepts;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="VEHICLE13")
@Table(name="VEHICLE13")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VEHICLE_ID")
	private int vehicleId;

	@Column(name = "VEHICLE_NAME")
	private String vehicleName;

	@ManyToOne
	@JoinTable(name="PERSON13_VEHICLE13", joinColumns=@JoinColumn(name="PERSON_ID"), inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Person person;

	public Vehicle() {
		super();
	}

	public Vehicle(String vehicleName) {
		super();
		this.vehicleName = vehicleName;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public static Vehicle getVehicle() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new Vehicle("vehicleName" + randomNum);
	}
}
