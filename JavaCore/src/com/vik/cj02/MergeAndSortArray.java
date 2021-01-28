package com.vik.cj02;

import java.util.Arrays;

public class MergeAndSortArray {

	public static void main(String[] args) {
		int[] a = { 2, 7, 8, 3, 1 };
		int[] b = { 10, 5, 6, 13, 11 };

		int[] sortedArr = mergeAndSortArr(a, b);
		
		Arrays.stream(sortedArr).forEach(i-> System.out.print(i+" "));
	}

	private static int[] mergeAndSortArr(int[] a, int[] b) {
		int[] mergedArr = mergeArr(a, b);
		return sort(mergedArr);
	}

	private static int[] mergeArr(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++)
			c[i] = a[i];
		for (int j = 0; j < b.length; j++)
			c[a.length + j] = b[j];
		return c;
	}

	private static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minPos = minPos(arr, i);
			swap(arr, i, minPos);
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int minPos(int[] arr, int from) {
		int minPos = from;
		for (int i = from + 1; i < arr.length; i++) {
			if (arr[i] < arr[minPos])
				minPos = i;
		}
		return minPos;
	}
	
}
