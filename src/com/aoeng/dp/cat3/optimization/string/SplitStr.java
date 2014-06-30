/**
 * 
 */
package com.aoeng.dp.cat3.optimization.string;

import java.util.StringTokenizer;

import org.junit.Before;
import org.junit.Test;

/**
 * Jun 24, 2014 3:17:02 PM
 * 
 */
public class SplitStr {
	String orgStr = null;
	long begin = 0;

	@Before
	public void init() {

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 100000; i++) {
			buffer.append(i).append(";");
		}
		orgStr = buffer.toString();
		begin = System.currentTimeMillis();
	}

	/**
	 * Split spend :50052
	 */
	@Test
	public void test3() {

		StringTokenizer st = new StringTokenizer(orgStr, ";");

		for (int i = 0; i < 10000; i++) {
			while (st.hasMoreElements()) {
				st.nextToken();
			}
			st = new StringTokenizer(orgStr, ";");
		}
		System.out.println("Split spend :" + (System.currentTimeMillis() - begin));

	}

	/**
	 * Split spend :35994
	 */
	@Test
	public void test2() {
		begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			orgStr.split(";");
		}
		System.out.println("Split spend :" + (System.currentTimeMillis() - begin));

	}

	@Test
	public void test1() {

		String[] strs = "a;b,c:d".split("[;|,|:]");
		for (String string : strs) {
			System.out.print(string);
			System.out.print(",");
		}
	}

}
