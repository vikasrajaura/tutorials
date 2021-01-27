package com.vik.cj01;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicPrograms02 {

	public static void main(String args[]) {
		System.out.println(validateBracketsString("{2*3+5-(2-5)}"));
	}
	
	
	public static boolean validateBracketsString(String string) {
		Stack<String> st = new Stack<>();
		String[] str = string.split("");

		Map<String, String> hmap = new HashMap<>();
		hmap.put("{", "}");
		hmap.put("(", ")");
		hmap.put("[", "]");

		if (!hmap.containsKey(str[0]))
			return false;
		else
			st.push(str[0]);

		for (int i = 1; i < str.length; i++) {
			if (hmap.containsKey(str[i]))
				st.push(str[i]);
			else {
				if (hmap.get(st.peek()).equals(str[i]))
					st.pop();
			}
		}
		return st.empty();
	}

}
