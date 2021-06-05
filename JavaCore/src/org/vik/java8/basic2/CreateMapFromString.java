package org.vik.java8.basic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CreateMapFromString {

	public static void main(String[] args) {
		createMapFromString();
		
		List<Integer> l1 = Arrays.asList(1,2,4,5,6);
		List<Integer> l2 = Arrays.asList(3,7,9,2);
		List<int[]> pairs = getPairsWhoseSumDivisbleBy6(l1,l2);
		pairs.forEach(i-> {System.out.println(i[0]+" " +i[1]);});
		
	}
	
	
	
	private static void createMapFromString() {
		String s = "1024=vikas:1023=rajaura:1025=pushpendra";
		List<String> list = Arrays.asList(s.split(":"));
		Map<String, String> map1 = list.stream().map(str -> str.split("="))
				.collect(Collectors.toMap(x -> x[0], x -> x[1]));
		
		Map<String, String> map = list.stream().map(str -> str.split("="))
				.collect(Collectors.toMap(x -> x[0], x -> x[1], (a, b) -> b, TreeMap::new));
		
		System.out.println(map1);
		System.out.println(map);
	}

	/**
	 * Create a map from a list of person or students
	 */
	public static void createMapFromList() {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(20L, "aaaaabc"));
		studentList.add(new Student(1L, "vikas"));
		studentList.add(new Student(2L, "abc"));
		//
		Map<Long, String> map = studentList.stream()
				.collect(Collectors.toMap(Student::getStudentId, Student::getName, (a, b) -> b, TreeMap::new));
		System.out.println(map);
	}
	
	/**
	 * Create a list from another list
	 */
	public void createListFromAnotherList() {
		List<String> list = Arrays.asList("a","b","c");
		List<Student> studentList = list.stream().map(k-> new Student(Long.valueOf(list.indexOf(k)), k)).collect(Collectors.toList());
		studentList.forEach(System.out::println);
	}


	public static List<int[]> getPairsWhoseSumDivisbleBy6(List<Integer> l1, List<Integer> l2) {
		List<int[]> pairs = l1.stream()
				.flatMap(i -> l2.stream().filter(j -> (i + j) % 6 == 0).map(j -> new int[]{ i, j })).collect(Collectors.toList());
		return pairs;
	}
	

	
}
