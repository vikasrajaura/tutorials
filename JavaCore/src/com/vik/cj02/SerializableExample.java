package com.vik.cj02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * *************************************
 * ********** Serialization ************
 * *************************************
 * Serialization is the process of making the object's state persistent. 
 * That means the state of the object is converted into stream of bytes and stored in a file.
 * 
 * In the same way we can use the de-Serialization concept to bring back the object's state from bytes.
 * 
 * This is one of the important concept in Java programming 
 * because this Serialization is mostly used in the networking programming.
 * The object which  need to be transmitted over the network has to be converted as bytes.
 * 
 * For that purpose every class or interface must implements Serializable interface.
 * 
 * It is a marker interface without any methods.
 * Transient and static variables can't be serialized.
 * Static fields belong to a class (as opposed to an object) and hence not serialized.
 * 
 * If Parent class is Serializable then child class is by default Serializable.
 * JVM checks if the parent class implements Serializable, it considers child class also as serializable
 * 
 * If an object has a reference to another object, then these objects must also be serializable separately,
 * means it must implements Serializable interface or else a NotSerializableException will be thrown.
 * 
 * 
 * *************************************
 * ************ Transient **************
 * *************************************
 * By default all the variables in the object is converted into the persistent.
 * 
 * In some cases, you may want to avoid persisting some variables because 
 * you don't have the necessity to persist those variable. 
 * So, you can declare those variables as transient.
 * 
 * If the variable is declared as transient, then it will not be persisted. 
 * It is the main purpose of the transient keyword.
 * 
 * @author vikas
 *
 */
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