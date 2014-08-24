package com.aoeng.base.interview.heima;

/*
 查找两个字符串的最大相同子串。
 比如："sadabcdfghjkl"和"werabcdtyu"的最大相同字串是：abcd
 */
public class Test3 {
	public static void main(String[] args) {
		// 任意定义两个字符串,也可以键盘录入
		String s1 = "sadabcdfghjkl";
		String s2 = "werabcdtyu";
		System.out.println(getMaxSubString(s1, s2));
	}

	/*
	 * 查找两个字符串的最大相同子串 明确: 返回结果 String 未知内容 两个字符串
	 */
	public static String getMaxSubString(String s1, String s2) {
		// 定义两个变量,用于分别保存长串,和短串.
		String max, min;

		max = s1.length() > s2.length() ? s1 : s2;
		min = s1.length() <= s2.length() ? s1 : s2;

		for (int x = 0; x < min.length(); x++) {
			// 我们用y表示min串的头角标,z表示min串的尾角标.
			for (int y = 0, z = min.length() - x; z <= min.length(); y++, z++) {
				String temp = min.substring(y, z);
				if (max.contains(temp)) {
					return temp;
				}
			}
		}
		// 如果没有相同字符
		return null;
	}
}
