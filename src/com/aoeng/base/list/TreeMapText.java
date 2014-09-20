package com.aoeng.base.list;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

public class TreeMapText {

	public static void main(String[] args) {

		TreeMap<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(1, "1");

		treeMap.put(3, "3");
		treeMap.put(2, "2");
		treeMap.put(4, "4");

		for (Entry<Integer, String> ent : treeMap.entrySet()) {
			System.out.println(ent.getKey() + "" + ent.getValue());
		}

	}

	@Test
	public void test() {
		// TODO Auto-generated method stub
		Hashtable<Integer, String> treeMap = new Hashtable<>();
		treeMap.put(1, "1");

		treeMap.put(3, "3");
		treeMap.put(2, "2");
		treeMap.put(2, "2");
		treeMap.put(24, "2");
		treeMap.put(2, "2");
		treeMap.put(62, "2");
		treeMap.put(2, "2");
		treeMap.put(82, "2");
		treeMap.put(25, "2");
		treeMap.put(22, "2");
		treeMap.put(20, "2");
		treeMap.put(21, "2");
		treeMap.put(4, "4");

		for (Entry<Integer, String> ent : treeMap.entrySet()) {
			System.out.println(ent.getKey());
		}
	}

	@Test
	public void test2() {
		LinkedHashMap<Integer, String> treeMap = new LinkedHashMap<>();
		treeMap.put(3, "3");
		treeMap.put(2, "2");
		treeMap.put(2, "2");
		treeMap.put(24, "2");
		treeMap.put(2, "2");
		treeMap.put(62, "2");
		treeMap.put(2, "2");
		treeMap.put(82, "2");
		treeMap.put(25, "2");
		treeMap.put(22, "2");
		treeMap.put(20, "2");
		treeMap.put(21, "2");
		treeMap.put(4, "4");

		for (Entry<Integer, String> ent : treeMap.entrySet()) {
			System.out.println(ent.getKey());
		}
	}

	@Test
	public void test3() {
		Map<Integer, String> treeMap = new TreeMap<Integer, String>(new Comparator<Integer>() {
			public int compare(Integer obj1, Integer obj2) {
				// 降序排序
				return obj2 - obj1;
			}
		});
		treeMap.put(3, "3");
		treeMap.put(2, "2");
		treeMap.put(2, "2");
		treeMap.put(24, "2");
		treeMap.put(2, "2");
		treeMap.put(62, "2");
		treeMap.put(2, "2");
		treeMap.put(82, "2");
		treeMap.put(25, "2");
		treeMap.put(22, "2");
		treeMap.put(20, "2");
		treeMap.put(21, "2");
		treeMap.put(4, "4");

		for (Entry<Integer, String> ent : treeMap.entrySet()) {
			System.out.println(ent.getKey());
		}
	}

}
