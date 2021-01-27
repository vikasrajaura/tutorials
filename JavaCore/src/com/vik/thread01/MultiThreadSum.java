package com.vik.thread01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadSum {

	public static void main(String[] args) {
		Callable[] jobs = {
				new SumJob(1,10),
				new SumJob(11,20),
				new SumJob(21,30),
				new SumJob(31,40),
				new SumJob(41,50)
		};
		
		MultiThreadSum ob = new MultiThreadSum();
		try {
			System.out.println(ob.startJobs(jobs));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int startJobs(Callable[] jobs) throws InterruptedException, ExecutionException {
		int nThreads = jobs.length / 2;
		int finalSum = 0, i = 0;
		ExecutorService service = Executors.newFixedThreadPool(nThreads);
		Future[] futures = new Future[jobs.length];
		// submit all jobs
		for (Callable job : jobs) {
			futures[i] = service.submit(job);
			System.out.println("Hello");
			i++;
		}
		// calculate sum of result returned by all jobs
		for (Future f : futures) {
			finalSum = finalSum + (Integer) f.get();
		}
		return finalSum;
	}
	
}


class SumJob implements Callable {
	private int start;
	private int end;
	public SumJob(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public Object call() throws Exception {
		int sum = 0;
		
		for (int i = start; i <= end; i++){
			sum += i;
			System.out.println("Num: " + i);
			Thread.sleep(200);	
		}
		System.out.println("-----Sum is---- :"+sum);
		return sum;
	}
}
