package org.vik.probs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
Given two arrays: arr1[0..m-1] and arr2[0..n-1].
Find whether arr2[] is a subset of arr1[] or not.
*/
public class Prob02 {

    public static void main(String[] args) {
        Integer[] arr1 = {1,2,4,8,5,7,10,36,21};
        Integer[] arr2 = {5,1,21};

        System.out.println(isSubset1(arr1, arr2));
    }

    public static boolean isSubset1(Integer[] arr1, Integer[] arr2) {
        boolean isSubset=false;
        for(int i: arr2) {
            isSubset=false;
            for(int j: arr1){
                if(i==j) {isSubset = true; break; }
            }
            if(isSubset==false) return false;
        }
        return isSubset;
    }

    /*
        Solution Using HashSet
        time complexity O(n), HashMap time complexity O(1)
     */
    public static boolean isSubset2(Integer[] arr1, Integer[] arr2) {
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(arr1));
        for(int i: arr2) {
            if(!hs.contains(i))
                return false;
        }
        return true;
    }


}
