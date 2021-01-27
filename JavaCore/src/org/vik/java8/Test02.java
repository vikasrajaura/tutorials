package org.vik.java8;

interface Left {
	default void m1() {
		System.out.println("Left");
	}
}

interface Right {
	default void m1() {
		System.out.println("Right");
	}
}

class Test02 implements Left, Right {

	public static void main(String[] args) {
		Left ob = new Test02();
		ob.m1();
	}
}
