package com.vik.cj06;

public class Test3 {

	public static void main(String[] args) {
		  B ob = new B();
		  ob.addFromSuper();
	}
}

class A {
	void add() {

	}
}

class B extends A implements C {
	 void add() {	}

	public void addFromSuper() {
		super.add();
	}
}

interface C {
	void add();
}

class D {

}