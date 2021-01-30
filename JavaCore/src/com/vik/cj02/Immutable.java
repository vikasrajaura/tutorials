package com.vik.cj02;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * Don’t allow subclasses to override methods - make class final
 * 
 * Make all fields final and private
 * 
 * Don’t provide “setter” methods — methods that modify fields or objects referred to by fields.
 * 
 * Set the values of properties using constructor only.
 * 
 * Special attention when having mutable instance variables 
 * 	- return new objects with copied content for all mutable objects
 *  
 *  ==> A more sophisticated approach is to make the constructor private 
 *  and construct instances in factory methods.
 * 
 * 
 * The advantages are:
 * **********************
 *  
 * Immutable objects are automatically thread-safe/synchronized, 
 * the overhead caused due to use of synchronization is avoided.
 * 
 * Once created the state of the immutable object can't be changed
 * so there is no possibility of them getting into an inconsistent state.
 * 
 * The references to the immutable objects can be easily shared or cached
 * without having to copy or clone them as there state can't be 
 * changed ever after construction.
 * 
 * The best use of the immutable objects is as the keys of a map.
 */

public final class Immutable {
	final private int age;
	final private String name;
	final private Date doj;
	final Map<String, String> map;
	public Immutable(int age, String name, Date doj, Map<String, String> map) {
		this.age = age;
		this.name = name;
		this.doj = doj;
		this.map = map;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public Date getDoj() {
		// return new Date(doj.getTime());
		return (Date) doj.clone();
	}
	
	public Map<String, String> getmap() {
		return new HashMap(this.map);
	}

}