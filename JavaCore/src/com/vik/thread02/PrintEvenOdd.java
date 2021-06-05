package com.vik.thread02;

public class PrintEvenOdd {

	int start = 1;
	int end = 50;

	public void printEven() {
		while (start < end) {
			synchronized (this) {
				if (start % 2 == 0) {
					System.out.println(Thread.currentThread().getName()+": "+start);
					start++;
					this.notifyAll();
				} else {
					try {
						this.wait(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}
	}

	public void printOdd() {
		while (start < end) {
			synchronized (this) {
				if (start % 2 == 1) {
					System.out.println(Thread.currentThread().getName()+": "+start);
					start++;
					this.notifyAll();
				} else {
					try {
						this.wait(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		PrintEvenOdd res = new PrintEvenOdd();
		Thread even = new Thread(()->{res.printEven();},"Even");
		Thread odd = new Thread(()->{res.printOdd();},"Odd");
		even.start();
		odd.start();
	}
}
