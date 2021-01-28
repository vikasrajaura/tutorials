package com.vik.cj02;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ImmutableTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap();
		map.put("1", "One");
		map.put("2", "Two");
		map.put("3", "Three");

		Immutable imm = new Immutable(34, "Vikas", new Date(), map);

		imm.getmap().put("4", "Four");

		imm.getmap().keySet().forEach(System.out::println);
	}
}