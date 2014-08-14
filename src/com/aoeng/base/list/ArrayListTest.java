package com.aoeng.base.list;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayListTest {
	static ArrayList<Integer> arr = new ArrayList<>();

	@BeforeClass
	public static void init() {
		for (int i = 0; i < 10; i++) {
			arr.add(i);
		}
		System.out.println("初始化 集合 " + arr.toString());
	}

	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			if (i / 2 == 0)
				arr.remove(i);
		}
		System.out.println(arr.toString());
	}

	@Test
	public void test1() {
		for (int i = 0; i < arr.size(); i++) {
			if (i / 2 == 0)
				arr.remove(i);
		}
		System.out.println(arr.toString());
	}

	@Test
	public void test2() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				arr.remove(i);
		}
		System.out.println(arr.toString());
	}

	@Test
	public void test3() {
		for (int i = 0; i < arr.size(); i++) {
			if (i % 2 == 0)
				arr.remove(i);
		}
		System.out.println(arr.toString());
	}

	@Test
	public void test4() {
		for (int i = 9; i >= 0; i--) {
			if (arr.get(i) % 2 == 0)
				arr.remove(i);
		}
		System.out.println(arr.toString());
	}

	@Test
	public void test5() {
		for (int i = arr.size(); i >= 0; i--) {
			if (arr.get(i) % 2 == 0)
				arr.remove(i);
		}
		System.out.println(arr.toString());
	}

}
