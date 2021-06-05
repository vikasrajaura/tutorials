package org.vik.java8.basic2;

/**
 * 
 * @author vikas
 * 
 *         Given an int array which can -ve or +ve. Return the max sum possible
 *         in subarray. Arr: 2 3 -4 7 -8 3 4 Output: 8
 *
 */
public class MaximumSumInArray {

	public static void main(String[] args) {
		int[] arr1 = { 2, 3, -4, 7, -8, 3, 4 };
		int[] arr2 = { -2, -3, -1 };
		System.out.println(getMaxSumInArray(arr2));
	}

	public static int getMaxSumInArray(int[] arr) {

		int maxVal = Integer.MIN_VALUE;
		int currVal = 0;
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = i; j < arr.length; j++) {
				currVal = arr[j];
				temp = temp + currVal;
				if (maxVal < temp)
					maxVal = temp;
			}
			temp = 0;
		}

		return maxVal;
	}

}
