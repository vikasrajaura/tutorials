package com.vik.cj01;

import java.util.HashSet;
import java.util.Set;

public class IntProg03_PrintPowerSet {

	public static void main(String[] args) {
		String[] arr = new String[] { "ab", "m", "k" };
		Set<Set<String>> resultSet = printSubsets(arr);
		System.out.println(resultSet);
	}

	/**
	 * Print all subsets of given set[]
	 * 
	 * @param set
	 */
	public static Set<Set<String>> printSubsets(String set[]) {
		int n = set.length;
		Set<Set<String>> resultSet = new HashSet<>();
		// Run a loop for printing all 2^n
		// subsets one by one use Math.pow(2, n) or (1<<n)
		for (int i = 0; i < Math.pow(2, n); i++) {
			Set<String> innerSet = new HashSet<>();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					innerSet.add(set[j]);
				}
			}
			resultSet.add(innerSet);
		}
		return resultSet;
	}

	/**
	 * Print all subsets of given set[]
	 * 
	 * @param set
	 */
	public static Set<Set<String>> printSubsets2(String set[]) {
		int n = set.length;
		Set<Set<String>> resultSet = new HashSet<>();
		// Run a loop for printing all 2^n
		// subsets one by one use Math.pow(2, n) or (1<<n)
		for (int i = 0; i < Math.pow(2, n); i++) {
			Set<String> innerSet = new HashSet<>();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					innerSet.add(set[j]);
				}
			}
			resultSet.add(innerSet);
		}
		return resultSet;
	}
}
