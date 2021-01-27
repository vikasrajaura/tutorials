package org.vik.vo;

import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "HOME_STREET")
	private String street;

	@Column(name = "HOME_CITY")
	private String city;

	@Column(name = "HOME_STATE")
	private String state;

	@Column(name = "HOME_PINCODE")
	private String pincode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Address() {
		super();
	}

	public Address(String street, String city, String state, String pincode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}

	public static Address getAddress() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new Address("street" + randomNum, "city", "state", "pincode");
	}

}
