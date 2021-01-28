package com.vik.cj02;

class Singleton {

	// Step 1: private static variable of INSTANCE variable
	private static volatile Singleton INSTANCE;

	// Step 2: private constructor
	private Singleton() {
	}

	// Step 3: Provide public static getInstance() method returning INSTANCE
	// after checking
	public static Singleton getInstance() {

		// double-checking lock
		if (null == INSTANCE) {

			// synchronized block
			synchronized(Singleton.class) {
				if (null == INSTANCE) {
					INSTANCE = new Singleton();
				}
			}
		}
		return INSTANCE;
	}
}