/**
 * 
 */
package com.aoeng.dp.cat1.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Jun 20, 2014 11:43:13 AM
 * 
 */
public class Main {

	@Test
	public void testSerSingleton() throws Exception {
		SerSingleton se = null;
		SerSingleton s = SerSingleton.getInstance();
		System.out.println(s);
		FileOutputStream fos = new FileOutputStream("ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.flush();
		oos.close();
		FileInputStream fis = new FileInputStream("ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		se = (SerSingleton) ois.readObject();
		System.out.println(se);

	}

	@Test
	public void testStaticSingleton() {

		StaticSingelton.getInstance();
	}

	@Test
	public void testLazySingleton() {
		for (int i = 0; i < 100; i++) {
			System.out.println("1---"+LazySingleton.getInstance());;
			System.out.println("2---"+LazySingleton.getInstance2());;
		}
	
	}

	@Test
	public void testSingelton() {
		Singleton.getInstance();
	}

}
