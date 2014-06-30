/**
 * 
 */
package com.aoeng.dp.cat1.singleton;

import java.io.Serializable;

/**
 * Jun 20, 2014 11:52:41 AM
 * 
 */
public class SerSingleton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7488906563657539536L;

	private SerSingleton() {
		System.out.println("SerSingleton is create ");
	}

	private static SerSingleton instance = new SerSingleton();

	public static SerSingleton getInstance() {

		return instance;
	}

	/**
	 * 
	 */
	private Object readResolve() {
		// TODO Auto-generated method stub

		return instance;
	}

}
