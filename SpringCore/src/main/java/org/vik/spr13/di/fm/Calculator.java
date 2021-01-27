package org.vik.spr13.di.fm;

public class Calculator {

	private static final Calculator obj = new Calculator();

	private Calculator() {
		System.out.println("class: org.vik.spr13.di.fm.Calculator private constructor");
	}

	public static Calculator getCalculator() {
		System.out.println("class: org.vik.spr13.di.fm.Calculator factory method ");
		return obj;
	}

	public void msg() {
		System.out.println("Hello user! This is calculator msg() method.");
	}

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

}