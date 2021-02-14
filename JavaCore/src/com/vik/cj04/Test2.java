package com.vik.cj04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test2 {
	public static void main(String[] args) {
		
	
		
		List<Employee> emp_list = new ArrayList<Employee>();
		
		List<Employee> emp_list2 = emp_list.stream().filter(e-> e.getName().startsWith("A")).collect(Collectors.toList());
		
		Map<Integer,List<Employee>> map  = Employee.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getDeptId));
		
		System.out.println(map);
				

				
	}
}

class Employee {
	int id;
	String name;
	int deptId; // HR, Dev, IT
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deptId=" + deptId + "]";
	}
	public Employee(int id, String name, int deptId) {
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
	}
	public int getDeptId(){
		return this.deptId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static List<Employee>  getEmployeeList(){
		List<Employee> empList = new ArrayList();
		empList.add(new Employee(1, "Vik1", 1));
		empList.add(new Employee(2, "Vik2", 2));
		empList.add(new Employee(3, "Vik1", 3));
		empList.add(new Employee(4, "A3", 3));
		empList.add(new Employee(5, "A2", 2));
		empList.add(new Employee(6, "A1", 1));
		return empList;
	}
}