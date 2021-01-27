package org.vik.hib13.somConcepts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity(name = "PERSON13")
@Table(name = "PERSON13")
public class Person {

	@Id
	@Column(name = "PERSON_ID")
	private int personId;

	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@OneToMany(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER )
	@JoinTable(name = "PERSON13_VEHICLE13", joinColumns = @JoinColumn(name = "VEHICLE_ID"), inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

	@OneToMany(/*mappedBy = "owner",*/ cascade = CascadeType.PERSIST)
	@JoinTable(name = "PERSON13_PLOT13", joinColumns = @JoinColumn(name = "PLOT_ID"), inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
	private Collection<Plot> plots = new HashSet<Plot>();

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

	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Collection<Plot> getPlots() {
		return plots;
	}

	public void setPlots(Collection<Plot> plots) {
		this.plots = plots;
	}

	public static Person getPerson() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new Person("firstName" + randomNum);
	}

}
