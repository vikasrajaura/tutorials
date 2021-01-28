package com.vik.cj02;

import java.io.*;

class NameStore implements Serializable {
	private String s1;
	private transient String s2;
	private String s3;

	public NameStore(String fName, String mName, String lName) {
		this.s1 = fName;
		this.s2 = mName;
		this.s3 = lName;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(40);
		sb.append("First Name : " + this.s1);
		sb.append("Middle Name : " + this.s2);
		sb.append("Last Name : " + this.s3);
		return sb.toString();
	}
}

public class Transient {
	public static void main(String args[]) throws Exception {
		NameStore nameStore = new NameStore("Steve", "Middle", "Jobs");
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("file.txt"));
		// writing to object
		o.writeObject(nameStore);
		o.close();

		// reading from object
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
		NameStore nameStore1 = (NameStore) in.readObject();
		System.out.println(nameStore);
		System.out.println(nameStore1);

	}
}
