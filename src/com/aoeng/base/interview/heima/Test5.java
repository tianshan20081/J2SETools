package com.aoeng.base.interview.heima;

import java.util.Set;
import java.util.TreeMap;

/*
 "cbxzbvavdvgd"获取字符串中，每一个字母出现次数：a(1)b(2)c(1)d(2)g(1)v(3)x(1)z(1)

分析：
 看到后面的地方最好能想要集合对象中的Map。键值对形式。这是一个很大的特点。
 */
public class Test5 {
	public static void main(String[] args) {
		// 定义一个字符串
		String str = "cbxzbvavdvgd";

		// 把字符串的数据存储到TreeMap中。
		TreeMap<Character, Integer> tm = stringToTreeMap(str);

		// Set<Character> set = tm.keySet();
		// for (Character key : set) {
		// Integer value = tm.get(key);
		// System.out.println(key + "***" + value);
		// }

		// 写一个功能，把TreeMap变成一个字符串返回。要求，Map的值用()括起来。
		String s = treeMapToString(tm);
		System.out.println("s:" + s);
	}

	/*
	 * 功能：把字符串中的数据存储到TreeMap中。 明确： 返回值类型：TreeMap<Character,Integer> 参数列表：String
	 * str
	 */
	public static TreeMap<Character, Integer> stringToTreeMap(String str) {
		// 创建一个TreeMap<Character,Integer>
		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();

		// 把字符串变成字符数组
		char[] chs = str.toCharArray();
		// 遍历字符数组，获取每一个字符
		for (char ch : chs) {
			// ch是不是就是每一个字符
			Integer i = tm.get(ch);
			if (i == null) {
				// 说明集合中没有这个元素
				tm.put(ch, 1);
			} else {
				// 有值,就加1，然后重新存
				i++;
				tm.put(ch, i);
			}
		}

		return tm;
	}

	/*
	 * 把TreeMap变成一个字符串。 明确： 返回值类型：String 参数列表：TreeMap tm
	 */
	public static String treeMapToString(TreeMap<Character, Integer> tm) {
		StringBuilder sb = new StringBuilder();

		// 遍历TreeMap,获取键值,并拼接
		Set<Character> set = tm.keySet();
		for (Character key : set) {
			Integer value = tm.get(key);
			sb.append(key).append("(").append(value).append(")");
		}

		return sb.toString();
	}
}
