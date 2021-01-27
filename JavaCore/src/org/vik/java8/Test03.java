package org.vik.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test03 {
	// Collection<Integer> number = IntStream.range(0, 10).boxed().collect(Collectors.toSet());	
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(3,"vikas", "rajaura"));
		list.add(new Employee(3,"vikaas", "rajaura"));
		list.add(new Employee(1,null, null));
		list.add(new Employee(3,null, null));
		list.add(new Employee(3,"vikas", "aa"));
		
		list.forEach(System.out::println);
		Comparator<Employee> comp = Comparator.comparing(Employee::getEmpId).thenComparing(Employee::getFirstName)
				.thenComparing(Employee::getLastName);
		list.sort(comp);

		System.out.println();
		list.forEach(System.out::println);
	}
	
	
}

class Employee {

	private int empId;
	private String firstName;
	private String lastName;

	public Employee(int empId, String firstName, String lastName) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
