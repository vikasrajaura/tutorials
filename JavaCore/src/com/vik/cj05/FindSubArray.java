package com.vik.cj05;

/**
 * 
 * @author vikas
 * 
 * Company: Moglix Interview Ques
 *  
 * Given an array of 0 and 1s find sequenced subarray with below conditions
 *  - A sub array with max length having count of 0s equals to count of 1s
 *      
 * InputArry: {0,1,1,1,1,0,0,1,0,1,0,0,1,1,0,1,0,1,1,0,0,1,0} 
 * Output SubArray:  3, 22
 * 
 */
public class FindSubArray {

	public static void main(String[] args) {
		int[] arr = {0,1,1,1,1,0,0,1,0,1,0,0,1,1,0,1,0,1,1,0,0,1,0};
		int[] subArr = getMaxStartEndPos(arr);
		System.out.println(subArr[0]+", "+subArr[1]);
	}
	public static int[] getMaxStartEndPos(int[] arr) {
		int retArr[] = new int[2];
		int maxCount=0;

		for(int i=0;i<arr.length; i++){
			int count0=0;
			int count1=0;
			int subArrayLength = 0;
			
			for(int j=i;j<arr.length;j++){
			
				subArrayLength++;
				if(arr[j]==1) count1++;
				else count0++;
				
				if(subArrayLength%2==0 && count0==count1 && maxCount<count0) { // only proceed for even subarray						
						maxCount = count0;
						retArr[0] = i;
						retArr[1] = j;
				}
			}
		}
		return retArr;
	}
}
