/**
 * 
 */
package com.aoeng.dp.cat1.singleton;

/**
 * Jun 20, 2014 11:45:39 AM
 * 
 */
public class LazySingleton {
	private LazySingleton() {

		System.out.println("LazySingelton is create !");
	}

	private static LazySingleton instance = null;

	public static synchronized LazySingleton getInstance() {

		if (null == instance)
			instance = new LazySingleton();
		return instance;
	}
}
