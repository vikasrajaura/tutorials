package com.vik.cj02;
import java.util.concurrent.atomic.AtomicInteger;

class VolatileThread extends Thread {
	private static volatile int n;
	public VolatileThread(String s) {
		super(s);
	}
	public void run() {
		for(int i = 0; i<20; i++) {
			try {
				
				if("Thread1".equals(getName())) { 
					n++;
					System.out.println(getName()+" - has updated n : "+n);
				}
				if("Thread2".equals(getName())) {
					System.out.println(getName()+ " - is reading n : "+n);
				}
				Thread.sleep(500);
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}

class VolatileExample {
	public static void main(String... args) {
		new VolatileThread("Thread1").start();
		new VolatileThread("Thread2").start();
	}
}