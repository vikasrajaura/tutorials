package com.vik.thread01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadInSequence {
	public static void main(String[] args) {
		ThreadInSequence t = new ThreadInSequence();
		t.startJobs();
	}

	public void startJobs() {
		ExecutorService es = Executors.newFixedThreadPool(3);
		SharedResource sr = new SharedResource();
		PrinterJob[] jobs = { new PrinterJob(sr, 'A'), new PrinterJob(sr, 'B'), new PrinterJob(sr, 'C') };
		
		// submit all runnable jobs
		for (PrinterJob job : jobs)
			es.submit(job);
		es.shutdown();
	}
}

class SharedResource {
	char ch = 'A';
}

class PrinterJob extends Thread {
	SharedResource sr;
	char ch;

	public PrinterJob(SharedResource sr, char ch) {
		this.sr = sr;
		this.ch = ch;
	}

	public void run() {
		synchronized (sr) {
			for (int i = 0; i < 5; i++) {
				while (ch != sr.ch) {
					try {
						Thread.sleep(200);
						sr.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(ch);
				// if A change to B, if B change to C else to A
				sr.ch = sr.ch == 'A' ? 'B' : sr.ch == 'B' ? 'C' : 'A';
				sr.notifyAll();
			}
		}
	}
}
