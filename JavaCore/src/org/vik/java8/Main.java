package org.vik.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	List<Person> pl = new ArrayList<>();
	// Collection<Integer> number = IntStream.range(0, 10).boxed().collect(Collectors.toSet());
	public static void main(String... args) {
		Main ob = new Main();
		
		//ob.startTesting();
		
		Stream<Integer> st = IntStream.range(0, 10).boxed();//
		
	}

	public void test(Stream<Integer> st){
		st.collect(Collectors.toSet()).stream().forEach(System.out::println);
	}

	private void startTesting() {
		addUsersInList();

		printAllUsers();
		
		//removeIf_Method_Test();
		
		//modifing_objectes_Test();
		
		increment_salary_whose_firstName_startswith_V_Test();
		
		Integer[] ar1 = {1,2,3};
		Integer[] ar2 = {4,5};
		print_two_array_cross(ar1, ar2);
	}

	// Removing Conditionally
	public void removeIf_Method_Test() {
		System.out.println("Testing ===========> removeIf_Method_Test()");
		clearAndAddUsersInList();
		pl.removeIf(p -> p.getFirstName().startsWith("D"));
		printAllUsers();
	}
	
	public void modifing_objectes_Test() {
		System.out.println("Testing ===========> modifing_objectes_Test()");
		clearAndAddUsersInList();
		
		//Modifying Objects within stream in Java8 while iterating
		pl.forEach(p -> p.setFirstName(p.getFirstName()+"Hello"));
		
		//This time, we’ve used a Consumer
		pl.forEach(System.out::println);

	}
	
	public void increment_salary_whose_firstName_startswith_V_Test() {
		System.out.println("Testing ===========> increment_salary_whose_firstName_startswith_V_Test()");
		clearAndAddUsersInList();
		
		//Modifying Objects within stream in Java8 while iterating
		// update salary whose firstName starts with V or whose age is greater than 26
		pl.stream().filter(p -> p.getFirstName().startsWith("V")|| p.getAge()>=26).forEach(p -> p.setSalary(99999));
		
		//This time, we’ve used a Consumer
		pl.forEach(System.out::println);
		
		//pl.stream().filter(p -> pl2.keyset.contains(p.getId));
	} 
	
	private void print_two_array_cross(Integer[] ar1, Integer[] ar2) {
		List<Integer> l1 = Arrays.asList(ar1);
		List<Integer> l2 = Arrays.asList(ar2);
		
		List<int[]> pairs = l1.stream()
					.flatMap(i->l2.stream().filter(j-> (i+j)%3==0)
							.map(j-> new int[] {i,j})				
				).collect(Collectors.toList());
		
		pairs.forEach(i-> System.out.println("("+i[0]+", "+i[1]+")"));
		
	}
	
	private void addUsersInList() {
		for (int i = 0; i < 4; i++) {
			pl.add(new Person(i, "First" + i, "Last" + i, i * 2 + 1, i * 10000));
		}
		pl.add(new Person(11, "Vikas", "Rajaura", 28, 30000));
		pl.add(new Person(12, "Rahul", "Singh", 26, 32000));
		pl.add(new Person(13, "Suresh", "Pal", 24, 33000));
		pl.add(new Person(14, "Dinesh", "Rajaura", 30, 38000));
		pl.add(new Person(15, "Tinku", "Payal", 40, 39000));
		pl.add(new Person(16, "Deepa", "Chaudhary", 20, 46000));
		pl.add(new Person(17, "Teena", "Kumari", 18, 22000));
		pl.add(new Person(18, "Nitu", "Kumari", 25, 28000));
		pl.add(new Person(19, "Kamal", "Singh", 22, 26000));
	}

	private void clearAndAddUsersInList() {
		pl.clear();
		addUsersInList();
	}
	public void printAllUsers() {
		pl.forEach(p -> System.out.println(p));
		System.out.println("Size is " + pl.size());
		System.out.println("=================================================================");		
	}
	
	
	public List<int[]> printPairsDivisibleBy6(Integer[] a, Integer[] b){
		List<Integer> l1 = Arrays.asList(a);
		List<Integer> l2 = Arrays.asList(b);

		List<int[]> pairs = Arrays.stream(a)
				.flatMap(i -> Arrays.stream(a).filter(j -> (i + j) % 6 == 0).map(j -> new int[] { i, j }))
				.collect(Collectors.toList());
		return pairs;	
		
	}
	
	
	
	public List<int[]> pairs(Integer[] a, Integer[] b) {
		List<Integer> l1 = Arrays.asList(a);
		List<Integer> l2 = Arrays.asList(b);
		return l1.stream().flatMap(i -> l2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[] { i, j }))
				.collect(Collectors.toList());

	}
}
