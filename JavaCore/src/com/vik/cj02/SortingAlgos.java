package com.vik.cj02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortingAlgos {

	public static void main(String[] args) {

		int[] a = { 20, 8, 3, 45, 17, 100, 15, 1 };
		IntStream.of(selectionSort(a)).forEach(i -> System.out.print(" " + i));
		System.out.println();
		Arrays.stream(selectionSort(a)).forEach(e -> System.out.print(e + " "));

	}

	/**
	 * Selection sorting
	 * @param arr
	 * @return
	 */
	public static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minPos = minPos(arr, i);
			swap(arr, minPos, i);
		}
		return arr;
	}
	/**
	 * swap arr[i] with arr[j]
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] =temp;
	}

	/**
	 * Find minPos in int[] arr after the given index 'from' 
	 * @param arr
	 * @param from
	 * @return
	 */
	private static int minPos(int[] arr, int from) {
		int minPos = from;
		for(int i= from+1; i< arr.length; i++) {
			if(arr[i]< arr[minPos]) minPos = i;
		}
		return minPos;
	}

}
