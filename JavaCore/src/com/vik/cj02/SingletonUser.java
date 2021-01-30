package com.vik.cj02;

public class SingletonUser {

	private static volatile SingletonUser instance = null;
	private final String name;
	private final String email;
	private final String country;

	public static SingletonUser getSingletonInstance(String name, String email, String country) {
		if (instance == null) {
			synchronized (SingletonUser.class) {
				if (instance == null) {
					instance = new SingletonUser(name, email, country);
				}
			}
		}
		return instance;

	}
	public  Object clone() throws CloneNotSupportedException {
		throw  new CloneNotSupportedException();
	}
	
	private SingletonUser(String name, String email, String country) {
		this.name = name;
		this.email = email;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCountry() {
		return country;
	}
}