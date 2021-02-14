package org.vik.java8.basic2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  Ques: List of 1 to 100, 
 *	ready to print nos- 1,2,3,4 then escape  5,6,7
 *	ready to print nos  8,9,10,11 again escape 12,13,14
 *	ready to print nos  15,16,17,18 escape 19,20,21
 *	then from ready to print nos - print only even nos.
 *
 */
public class NumberProblem {

	public static void main(String[] args) {
		List<Integer> list = IntStream.rangeClosed(0, 101).boxed().collect(Collectors.toList());
		List<Integer> l1 = list.stream().filter(i-> i%7==1||i%7==2||i%7==3||i%7==4).filter(i->{System.out.print(" RTP: "+i); return i%2==0;}).collect(Collectors.toList());
		System.out.println();
		l1.forEach(i->System.out.print(i+" "));
	}
}
