package com.vik.cj06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		
		
		List<String> l = new ArrayList<>();
		l.add("hi");
		l.add("hi");
		l.add("how");
		l.add("are");
		l.add("you");
		System.out.println(l);
		Collections.fill(l, "hi");
		l.add("dear");
		System.out.println(l);
		System.out.println(Collections.frequency(l, "hi"));
	}
	
	}

