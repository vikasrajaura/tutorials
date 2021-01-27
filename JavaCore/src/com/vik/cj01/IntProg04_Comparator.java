package com.vik.cj01;

import java.util.Comparator;
import java.util.TreeSet;

public class IntProg04_Comparator {

    public static void main(String[] args) {
    	TreeSet<String> ts = new TreeSet<>(comp1);
    	ts.add("vikas");
    	ts.add("aaaaaaa");
    	ts.add("ds");
    	ts.add("bb");
    	ts.add("b");
    	ts.add("a");
    	ts.add("hig");
    	ts.add("try");
    	ts.add("hello");
    	
    	ts.forEach(s->System.out.println(s));
    }
    

    /**
     * Create Comparator to sort TreeSet on the basis of string length
     * if length is equal then sort alphabetically
     */
    public static Comparator<String> MyComparator = new Comparator<String>(){
    	public int compare(String s1, String s2){
    		int retVal = s1.length()-s2.length();
    		if(retVal==0) retVal = s1.compareTo(s2);
    		return retVal;
    	}
    };
    
    public static Comparator<String> comp1 = Comparator.comparing(String::length).thenComparing(String::toString);

}
