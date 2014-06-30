/**
 * 
 */
package com.aoeng.dp.cat1.singleton;

/**
 * Jun 20, 2014 11:41:50 AM
 * 
 */
public class Singleton {
	private Singleton() {

		System.out.println("Singelton is create ");
	}

	private static Singleton instance = new Singleton();

	public static Singleton getInstance() {

		return instance;
	}

}
