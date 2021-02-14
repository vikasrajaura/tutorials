package org.vik.java8.basic2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsingGrouping {
	public static void main(String[] args) {
		List<Person> pl = Person.getPersonList();

		// group persons by deptId whose first name has more than 4 characters
		List<Person> persons = pl.stream().filter(e -> e.getFirstName().length() > 4).collect(Collectors.toList());
		Map<Integer, List<Person>> map = Person.getPersonList().stream()
				.collect(Collectors.groupingBy(Person::getDeptId));
		System.out.println(map);
	}
}
