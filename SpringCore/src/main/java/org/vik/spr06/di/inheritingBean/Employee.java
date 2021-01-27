package org.vik.spr06.di.inheritingBean;

public class Employee {
private int id;
private String name;
private Address address;
public Employee() {}

public Employee(int id, String name) {
	super();
	this.id = id;
	this.name = name;
	//System.out.println("......1");
}
public Employee(int id, String name, Address address) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	//System.out.println("......1");
}

void show(){
	System.out.println(id+" "+name);
	System.out.println(address);
}

}
