package org.vik.java8.basic2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CrossOfTwoArray {
	public static void main(String[] args) {
		CrossOfTwoArray ob = new CrossOfTwoArray();
		
		System.out.println("Testing ===========> print cross of two array");
		ob.print_two_array_cross(new Integer[]{1,2,3}, new Integer[]{4,5});
	}
	private void print_two_array_cross(Integer[] ar1, Integer[] ar2) {
		List<Integer> l1 = Arrays.asList(ar1);
		List<Integer> l2 = Arrays.asList(ar2);
		
		List<int[]> pairs = l1.stream()
					.flatMap(i->l2.stream().filter(j-> (i+j)%3==0)
							.map(j-> new int[] {i,j})				
				).collect(Collectors.toList());
		
		pairs.forEach(i-> System.out.println("("+i[0]+", "+i[1]+")"));
	}
	


	private List<int[]> printPairsDivisibleBy6(Integer[] a, Integer[] b) {
		List<Integer> l1 = Arrays.asList(a);
		List<Integer> l2 = Arrays.asList(b);

		List<int[]> pairs = Arrays.stream(a)
				.flatMap(i -> Arrays.stream(a).filter(j -> (i + j) % 6 == 0).map(j -> new int[] { i, j }))
				.collect(Collectors.toList());
		return pairs;	
		
	}
	
	
	
	private List<int[]> pairs(Integer[] a, Integer[] b) {
		List<Integer> l1 = Arrays.asList(a);
		List<Integer> l2 = Arrays.asList(b);
		return l1.stream().flatMap(i -> l2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[] { i, j }))
				.collect(Collectors.toList());

	}
}
