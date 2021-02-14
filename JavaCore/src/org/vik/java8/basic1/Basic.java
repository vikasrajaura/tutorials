package org.vik.java8.basic1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basic {

	
	public static void main(String... args) {
		
		Basic ob = new Basic();
		ob.basics();
		
		System.out.println("\nTesting ===========> increment_salary_whose_firstName_startswith_V_Test()");
		ob.increment_salary_whose_firstName_startswith_V_Test();
		
		System.out.println("\nTesting ===========> sort persons");
		ob.sortEmployees();
	}

	public void basics(){
		Collection<Integer> numbers = IntStream.range(0, 10).boxed().collect(Collectors.toSet());
		System.out.println(numbers.stream().map(n->String.valueOf(n)).collect(Collectors.joining(",","[","]")));
		
		// print list of employees
		System.out.println("\nTesting ===========> printing all persons)");
		List<Person> pl = Person.getPersonList();
		pl.stream().forEach(System.out::println);
		
		// Removing Conditionally
		System.out.println("\nTesting ===========> removeIf");
		pl.removeIf(p -> p.getFirstName().startsWith("D"));
		pl.forEach(System.out::println);
		
		System.out.println("\nTesting ===========> modifying objects in list");
		List<Person> pl2 = Person.getPersonList();
		//Modifying Objects within stream in Java8 while iterating
		pl.forEach(p -> p.setFirstName(p.getFirstName()+"Hello"));
		//This time, we’ve used a Consumer
		pl.forEach(System.out::println);
	}

	private void sortEmployees() {
		List<Person> pl = Person.getPersonList();
		pl.forEach(System.out::println);
		Comparator<Person> comp = Comparator.comparing(Person::getPersonId).thenComparing(Person::getFirstName)
				.thenComparing(Person::getLastName);
		pl.sort(comp);

		System.out.println();
		pl.forEach(System.out::println);
	}
	
	public void increment_salary_whose_firstName_startswith_V_Test() {
		List<Person> pl = Person.getPersonList();
		
		//Modifying Objects within stream in Java8 while iterating
		// update salary whose firstName starts with V or whose age is greater than 26
		pl.stream().filter(p -> p.getFirstName().startsWith("V")|| p.getAge()>=26).forEach(p -> p.setSalary(99999));
		
		//This time, we’ve used a Consumer
		pl.forEach(System.out::println);
		
		//pl.stream().filter(p -> pl2.keyset.contains(p.getId));
	} 
	

}
