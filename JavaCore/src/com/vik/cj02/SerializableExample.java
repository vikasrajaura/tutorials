package com.vik.cj02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableExample {
	public static void main(String args[]) throws Exception {
		Person p1 = new Person("Vikas", "Rajaura", new Address(15, "Bulandshahr"));
		
		// writing to object
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.txt"));
		oos.writeObject(p1);
		oos.flush();
		oos.close();

		// reading from object
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.txt"));
		Person p2 = (Person) ois.readObject();
		ois.close();

		System.out.println(p1);
		System.out.println(p2);
	}
}

class Person implements Serializable {
	private String firstName;
	private transient String lastName;
	private Address address;

	public Person(String firstName, String lastName, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}

}

class Address implements Serializable {
	private int houseNumber;
	private String city;
	// setters and getters

	public Address(int houseNumber, String city) {
		super();
		this.houseNumber = houseNumber;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", city=" + city + "]";
	}

}