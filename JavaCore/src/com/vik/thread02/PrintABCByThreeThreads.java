package com.vik.thread02;

public class PrintABCByThreeThreads {

	
	int start;
	int end;
	PrintABCByThreeThreads(int start, int end) {
		this.start = start;
		this.end=end;
	}
	
	public void job1() {
		while (start <= end) {
			synchronized (this) {
				if (start % 3 == 1) {
					System.out.println(Thread.currentThread().getName() + ": " + "A");
					start++;
					this.notifyAll();
				} else {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void job2() {
		while (start <= end) {
			synchronized (this) {
				if (start % 3 == 2) {
					System.out.println(Thread.currentThread().getName() + ": " + "B");
					start++;
					this.notifyAll();
				} else {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void job3() {
		while (start <= end) {
			synchronized (this) {
				if (start % 3 == 0) {
					System.out.println(Thread.currentThread().getName() + ": " + "C");
					start++;
					this.notifyAll();
				} else {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		PrintABCByThreeThreads res = new PrintABCByThreeThreads(1, 20);
		Thread t1 = new Thread(()->{res.job1();},"Job1" );
		Thread t2 = new Thread(()->{res.job2();},"Job2" );
		Thread t3 = new Thread(()->{res.job3();},"Job3" );
		t1.start();
		t2.start();
		t3.start();
	}
	
}
