package com.vik.cj01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author vikas.rajaura
 *
 *	1. Join String Array – Java 8 String.join(): String.join() method has two overloaded forms.
 *		a) Join multiple string arguments - String join(CharSequence delimiter, CharSequence... elements)
 *		b) Join array or list of strings - String join(CharSequence delimiter, Iterable<? extends CharSequence> elements)
 */
public class StringJoinSplit {

	public static void main(String[] args) {
		/***********String Join examples**************/
		//String Join Example
		String joinStr = String.join(", ", "How", "To", "Do", "In", "Java");
		System.out.println(joinStr);
		
		//Java program to join list of strings
		List<String> strList = Arrays.asList("How", "To", "Do", "In", "Java");
		String joinedStr = String.join(", ", strList);
		System.out.println(joinedStr);
		
		//Java program to join array of strings
		String[] strArray = { "How", "To", "Do", "In", "Java" };
		String joinedString = String.join(", ", strArray);
		System.out.println(joinedString);
		
		//String list of string with Collectors.joining()
		List<String> numbers = Arrays.asList("How", "To", "Do", "In", "Java");
		String joinString =   numbers
		                        .stream()
		                        .collect(Collectors.joining(", ", "[" ,"]"));
		System.out.println(joinString);
		
		
		/***********String Split examples**************/
		String s1 = "java string  split method by javatpoint";
		String[] words = s1.split("[\\s]+"); // splits the string based on whitespaces
		for (String w : words) {
			System.out.println(w);
		}
		
	}
}
