package com.vik.cj02;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author vikas.rajaura
 * 
 * ****Regex tutorial sites****
 * https://www.javatpoint.com/java-regex
 * https://howtodoinjava.com/java-regular-expression-tutorials/
 * https://www.geeksforgeeks.org/write-regular-expressions/
 * https://www.geeksforgeeks.org/tag/java-regular-expression/
 */
public class RegexExample {
	public static void main(String[] args) {

		// simple regex
		simpleRegex();

		// Regex to remove Vowels from string:");
		// test_removeVowelsFromString();

		// Regex to remove Consonants from string:");
		 test_removeConsonantsFromString();

	}

	public static void simpleRegex() {
		Pattern pattern = Pattern.compile("Alex|Brian");
		Matcher matcher = pattern.matcher("Generally, Alex and Brian share a great bonding.");
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(" - " + matcher.group());
		}
	}

	public static void test_removeVowelsFromString() {
		System.out.println("***** Test Regex: Remove vowels from string*****");
		List<String> inputList = new ArrayList();
		inputList.add("Hello my name Is VIKAS");
		inputList.add("What are you dooing");
		inputList.add("Abc On the  tree");
		inputList.forEach(i -> {
			System.out.println("Orig: " + i);
			System.out.println("      " + removeVowelsFromString(i));
		});
	}

	public static String removeVowelsFromString(String s) {
		// Regex to remove Vowels from string
		String regex = "[aeiou[AEIOU]]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.replaceAll("");
	}

	public static void test_removeConsonantsFromString() {
		System.out.println("***** Test Regex: Remove Consonants from string*****");
		List<String> inputList = new ArrayList();
		inputList.add("Hello my name Is VIKAS");
		inputList.add("What are you dooing");
		inputList.add("Abc On the  tree");
		inputList.forEach(i -> {
			System.out.println("Orig: " + i);
			System.out.println("      " + removeConsonantsFromString(i));
		});
	}

	public static String removeConsonantsFromString(String s) {
		// Regex to remove Consonants from string
		String regex = "[a-zA-Z&&[^aeiouAEIOU]]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.replaceAll("");
	}

}
