package org.vik.java8.basic1;

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

class DiamondProblem implements Left, Right {
	public void m1() {}
	public static void main(String[] args) {
		Left ob = new DiamondProblem();
		ob.m1();
	}
}
