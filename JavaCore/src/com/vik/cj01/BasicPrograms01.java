package com.vik.cj01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicPrograms01 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Factorial of 5: "+factorial(5));
		
		System.out.println("Reverse of String:Rahul:"+reverse("Rahul"));
		
		System.out.println("Sortig an array");
		Arrays.stream(sort(new int[]{ 2, 11, 5, 1, 7, 4, 9 })).forEach(i -> {
			System.out.print(i + " ");
		});
		System.out.println();
		
		System.out.println("Finding missing numbers between a and b which not exists in array ");
		getMissingNumbers(1, 10, new int[] { 3, 7, 5, 9 }).forEach(i -> {
			System.out.print(i + " ");
		});
		System.out.println();
		
		String s1 = "Hello my name is Hello";
		System.out.println("Count Words in String:"+countWordsInString(s1));
		
		System.out.println("Print powerset");
		System.out.println(powerset(new String[] { "a", "b", "c" }));
	
	}

	/**
	 * To calculate Factorial of an integer
	 * 
	 * @param n
	 * @return factorial of n
	 */
	public static int factorial(int n) {
		if (n == 0)
			return 1;
		else
			return (n * factorial(n - 1));
	}

	/**
	 * To find the reverse of the source String
	 * 
	 * @param source
	 * @return reverse of source stringfactorial of n
	 */
	public static String reverse(String source) {
		if (source == null || source.isEmpty()) {
			return source;
		}
		String reverse = "";
		for (int i = source.length() - 1; i >= 0; i--) {
			reverse = reverse + source.charAt(i);
		}
		return reverse;
	}

	/**
	 * Selection Sorting of an int array
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] sort(int[] arr) {
		int n = arr.length, index, temp = 0;
		for (int i = 0; i < n - 1; i++) {
			index = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[index])
					index = j;

			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;

		}
		return arr;
	}

	/**
	 * Find the list of missing numbers between min and max, which not exists in arr
	 * 
	 * @param min
	 * @param max
	 * @param arr
	 * @return
	 */
	public static List<Integer> getMissingNumbers(int min, int max, int[] arr) {
		Arrays.sort(arr);
		List<Integer> list = new ArrayList();
		for (int i = min; i <= max; i++) {
			int index = Arrays.binarySearch(arr, i);
			if (index < 0) list.add(i);
		}
		return list;
	}


	/**
	 * Count the words occurrence in string.
	 * 
	 * @param s
	 * @return a Map<String, Integer>
	 */
	private static Map<String, Integer> countWordsInString(String s) {

		Map<String, Integer> map = new HashMap<>();
		String[] tokens = s.split(" ");

		for (String word : tokens) {
			if (map.containsKey(word))
				map.put(word, map.get(word) + 1);
			else
				map.put(word, 1);
		}
		return map;
	}


	/**
	 * Returns the power set from the given set by using a binary counter Example: S
	 * = {a,b,c} P(S) = {[], [c], [b], [b, c], [a], [a, c], [a, b], [a, b, c]}
	 * 
	 * @param set String[]
	 * @return LinkedHashSet
	 */
	private static LinkedHashSet powerset(String[] set) {
		// create the empty power set
		LinkedHashSet power = new LinkedHashSet();
		// get the number of elements in the set
		int elements = set.length;
		// the number of members of a power set is 2^n
		int powerElements = (int) Math.pow(2, elements);
		// run a binary counter for the number of power elements
		for (int i = 0; i < powerElements; i++) {
			// convert the binary number to a string containing n digits
			String binary = intToBinary(i, elements);
			// create a new set
			LinkedHashSet innerSet = new LinkedHashSet();
			// convert each digit in the current binary number to the
			// corresponding element in the given set
			for (int j = 0; j < binary.length(); j++) {
				if (binary.charAt(j) == '1')
					innerSet.add(set[j]);
			}
			power.add(innerSet);
		}
		return power;
	}

	/**
	 * Converts the given integer to a String representing a binary number with the
	 * specified number of digits For example when using 4 digits the binary 1 is
	 * 0001
	 * 
	 * @param binary int
	 * @param digits int
	 * @return String
	 */
	private static String intToBinary(int binary, int digits) {
		String temp = Integer.toBinaryString(binary);
		int foundDigits = temp.length();
		String returner = temp;
		for (int i = foundDigits; i < digits; i++) {
			returner = "0" + returner;
		}
		return returner;
	}

}
