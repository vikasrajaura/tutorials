package org.vik.java8.basic1;

interface A {

	public default void m1() {
		System.out.println("A m1()");
	}

	public default void m2() {
		System.out.println("A m2()");
	}

	default int add(int a, int b) {
		return a + b;
	}
	
	/*
	default int hashCode(){
		return 20;
	}
	*/
}

class DefaultMethods implements A {
	
	public void m2() {
		System.out.println("Test_DefaultMethods m2()");
	}

	public static void main(String[] args) {
		DefaultMethods ob = new DefaultMethods();
		ob.m1();
		ob.m2();
		
		A ob2 = new DefaultMethods();
		ob2.m1();
		ob2.m2();
		
	}
}
