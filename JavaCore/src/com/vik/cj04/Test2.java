package com.vik.cj04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test2 {
	public static void main(String[] args) {

		//System.out.println("Hello");
		String[] arr ={"a","b","cd"};
		Set<Set<String>> set =getPowerSet(arr); 
		System.out.println("--------===-"+set.size());
	}
	
	
	public static Set<Set<String>> getPowerSet(String[] arr) {
		Set<Set<String>> ps = new HashSet<>();
		int len = arr.length;
		for(int i=0;i<Math.pow(2, len);i++) {
			Set<String> set = new HashSet<>();
			for(int j=0;j<len; i++) {
				if((i&(1<<j))>0){
					set.add(arr[j]);
				}
			}
			ps.add(set);
		}
		return ps;
	}
}

class Resource {
	int start;
	int end;

	Resource(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public void printEven() {
		while (start < end) {
			synchronized (this) {
				if (start % 2 == 0) {
					System.out.println(start);
					start++;
					this.notifyAll();
				} else {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}

	public void printOdd() {
		while (start < end) {
			synchronized (this) {
				if (start % 2 == 1) {
					System.out.println(start);
					start++;
					this.notifyAll();
				} else {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
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

	public int getDeptId() {
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

	public static List<Employee> getEmployeeList() {
		List<Employee> empList = new ArrayList();
		empList.add(new Employee(1, null, 1));
		empList.add(new Employee(2, "Vik2", 2));
		empList.add(new Employee(3, "Vik1", 3));
		empList.add(new Employee(4, "A3", 3));
		empList.add(new Employee(5, "A2", 2));
		empList.add(new Employee(6, "A1", 1));
		return empList;
	}
}