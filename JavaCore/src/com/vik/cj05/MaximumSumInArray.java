package com.vik.cj05;

/**
 * 
 * @author vikas
 * 
 * Company: Moglix Interview Ques
 * 
 * Given an int array which can -ve or +ve. Return the max sum possible in sequenced subarray
 * 
 * InputArry: {2 3 -4 7 -8 3 4} 
 * Output: 8
 */
public class MaximumSumInArray {

	public static void main(String[] args) {
		int[] arr1 = { 2, 3, -4, 7, -8, 3, 4 };
		int[] arr2 = { -2, -3, -1 };
		System.out.println(getMaxSumInArray(arr1));
	}

	public static int getMaxSumInArray(int[] arr) {

		int maxVal = Integer.MIN_VALUE;
		int currVal = 0;
		int tempSum = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = i; j < arr.length; j++) {
				currVal = arr[j];
				tempSum = tempSum + currVal;
				if (maxVal < tempSum)
					maxVal = tempSum;
			}
			tempSum = 0;
		}

		return maxVal;
	}

}
