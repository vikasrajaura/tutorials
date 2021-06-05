package com.vik.cj02;

/**
 * 
 * @author vikas
 * 
 *  We can create object of singleton using reflection, cloning, and deserialization and how we can control this.
 *  	- To overcome issue raised by reflection, enums are used because java ensures internally that enum value is instantiated only once.
 *  		- JVM handles the creation and invocation of enum constructors internally.
 *  	- To overcome deserialization issue, we have to implement readResolve() method.
 *  	- To overcome cloning issue, override clone() method and throw an exception from clone method that is CloneNotSupportedException
 *
 */
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
	
	// to overcome cloning issue
	public  Object clone() throws CloneNotSupportedException {
		throw  new CloneNotSupportedException();
	}
	
    // To overcome issue with deserialization implement readResolve method
    protected Object readResolve()
    {
        return INSTANCE;
    }
}