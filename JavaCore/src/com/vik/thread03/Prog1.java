package com.vik.thread03;

public class Prog1 {
	public static void main(String[] args) {
		Resource res = new Resource();
		Thread t1 = new Thread(() -> {
			res.job();
		}, "A");
		Thread t2 = new Thread(() -> {
			res.job();
		}, "B");

		t1.start();
		t2.start();

	}

}

class Resource {
	boolean value = true;
	int start = 1, times = 100;
	
	


}