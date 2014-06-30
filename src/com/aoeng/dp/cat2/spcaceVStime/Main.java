/**
 * 
 */
package com.aoeng.dp.cat2.spcaceVStime;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Jun 24, 2014 11:04:19 AM
 * 
 */
public class Main {
	public static int arrayLen = 1000000;

	/**
	 * 空間換時間
	 */
	@Test
	public void spaceTime() {

		int[] a = new int[arrayLen];
		int[] old = new int[arrayLen];
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		int count = 0;
		while (count < a.length) {
			int value = (int) (Math.random() * arrayLen * 10) + 1;
			if (map.get(value) == null) {
				map.put(value, value);
				a[count] = value;
				count++;
			}
		}
		System.arraycopy(a, 0, old, 0, a.length);
		long start = System.currentTimeMillis();
		Arrays.sort(a);
		System.out.println("Array.sort spend :" + (System.currentTimeMillis() - start) + " ms");
		System.arraycopy(old, 0, a, 0, old.length);
		start = System.currentTimeMillis();
		SpaceSort sort = new SpaceSort();
		sort.spaceToTime(a);
		System.out.println("spaceToTime spend :" + (System.currentTimeMillis() - start) + " ms");

	}

	/**
	 * 时间换空间
	 */

	@Test
	public void TimeSpace() {
		UnsignedByte ins = new UnsignedByte();
		short[] shorts = new short[256];
		for (int i = 0; i < shorts.length; i++) {
			shorts[i] = (short) i;
		}
		byte[] bytes = new byte[256];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = ins.toUnsingnedByte(shorts[i]);
		}
		for (int i = 0; i < bytes.length; i++) {
			System.out.println(ins.getValue(bytes[i]) + "");
		}

	}

}
