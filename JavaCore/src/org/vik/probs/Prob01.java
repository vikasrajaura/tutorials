package org.vik.probs;

import java.util.*;

/*
int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9}, sum = 13
count number of pairs having sum 13
4+9 = 13, 5+8=13, 6+7=13, output is 3
*/

public class Prob01 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 13;
        System.out.println(getCount2(arr,sum));
    }

    public static int getCount1(int[] arr, int sum) {
        int count=0, n=arr.length;
        for(int i =0;i<n-1;i++) {
                for(int j=i+i;j<n;j++) {
                    if(arr[i]+arr[j]==sum) sum++;
                }
        }
        return count;
    }


    // Solution Using HashSet
    // time complexity O(n), HashMap time complexity O(1)
    public static int getCount2(int[] arr, int sum) {
        int count=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr) {
            set.add(i);
            if(set.contains(sum-i)) count++;
        }
        return count;
    }

}


