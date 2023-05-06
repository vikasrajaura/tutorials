package com.vik.cj06;

public class _C {
	private static int $;

	public static void main(String[] main) {

		String s= "abc";
		String s1 = new String("abc");
		System.out.println(s==s1); //output ?
		s1.intern(); System.out.println(s==s1); // output ?
		s1= s1.intern() ; System.out.println(s==s1);  //output ?
		String s2= s1.intern(); System.out.println(s==s2); //output ?
		
		Test5 ob = new Test5();
		//ob.m1(null);
	}
}

class Test5 {



	void m1(String i) {
		System.out.println("String: "+i);
	}

	void m1(StringBuffer i) {
		System.out.println("String: "+i);
	}
	
	void m1(Integer i) {
		System.out.println("Integer: "+i);
	}
	
	void m1(Object s) {
		System.out.println("Object: "+s);
	}
	
}
