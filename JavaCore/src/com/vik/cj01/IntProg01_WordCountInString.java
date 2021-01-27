package com.vik.cj01;

public class IntProg01_WordCountInString {

	public static void main(String[] args) {

		int wordCount = wordCount("malecat i have amalecat. the color of malecat is Blacmalecatk", "malecat");
		System.out.println(wordCount);
	}

	/**
	 * Count the key in the provided source string
	 * 
	 * @param src
	 * @param key
	 * @return
	 */
	public static int wordCount(String src, String key) {
		int count = 0;
		String str = src;
		while (str.contains(key)) {
			count++;
			str = str.substring(str.indexOf(key) + key.length());
		}
		return count;
	}
}
