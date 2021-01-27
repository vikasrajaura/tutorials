package org.vik.hib08.inheritance.joined;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "VEHICLE08")
@Table(name = "VEHICLE08")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

	@Id	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VEHICLE_ID")
	private int vehicleId;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinTable(name = "PERSON_VEHICLE", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
	private Person vehicleOwner;

	public Vehicle() {
		super();
	}

	public Vehicle(String name) {
		super();
		this.name = name;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public String getName() {
		return name;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getVehicleOwner() {
		return vehicleOwner;
	}

	public void setVehicleOwner(Person vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}

	public static Vehicle getVehicle() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new Vehicle("vehicle name.." + randomNum);
	}

}
