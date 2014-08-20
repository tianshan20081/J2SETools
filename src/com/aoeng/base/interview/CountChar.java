package com.aoeng.base.interview;

public class CountChar {

	public static void main(String[] args) {
		String str = "afgklbsddfghesaf";
		for (int i = 0; i < str.length(); i++) {
			char c1 = str.charAt(i);
			boolean flag = false;
			for (int j = i + 1; j < str.length(); j++) {
				char c2 = str.charAt(j);
				if (c1 == c2) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println(c1 + "");
				break;
			}
		}
	}

}
