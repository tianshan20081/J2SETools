package com.aoeng.base.search;

import org.junit.BeforeClass;
import org.junit.Test;

public class Binary {
	private static int[] attr;

	@BeforeClass
	public static void init() {
		attr = new int[] { 1, 5, 8, 9, 12, 15, 25, 67, 78 };
	}

	@Test
	public void binary() {
		int des = 67;
		int position = binarySearch(attr, des);
		System.out.println(position);
		int low = 0;
		int high = attr.length - 1;
		position = binarySearch(attr, low, high, des);
		System.out.println(position);
	}

	private int binarySearch(int[] att, int low, int high, int des) {
		// TODO Auto-generated method stub
		if (low <= high) {
			int middle = (low + high) / 2;
			if (des == att[middle]) {
				return middle;
			} else if (des < attr[middle]) {
				return binarySearch(att, low, middle - 1, des);
			} else {
				return binarySearch(att, middle + 1, high, des);
			}
		}

		return -1;
	}

	private int binarySearch(int[] att, int des) {

		int low = 0;
		int high = att.length - 1;
		int position = -1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (des == att[middle]) {
				position = middle;
				break;
			} else if (des < att[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return position;
	}

}
