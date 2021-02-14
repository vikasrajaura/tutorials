package com.vik.thread02;

public class EvenOddPrinterByTwoThreads {

	int start = 1;
	int end = 20;

	public void printEven() {
		while(start<end) {
			synchronized (this) {
				if (start % 2 == 0) {
					System.out.println(Thread.currentThread().getName()+": "+start);
					start++;
					this.notify();
				} else {
					try {
						this.wait(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void printOdd() {
		while(start<end) {
			synchronized (this) {
				if (start % 2 == 1) {
					System.out.println(Thread.currentThread().getName()+": "+start);
					start++;
					this.notify();
				} else {
					try {
						this.wait(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		EvenOddPrinterByTwoThreads eop = new EvenOddPrinterByTwoThreads();
		Thread t1= new Thread(()->{eop.printEven();},"Even");
		Thread t2= new Thread(()->{eop.printOdd();},"Odd");
		t1.start();
		t2.start();
		
	}
}
