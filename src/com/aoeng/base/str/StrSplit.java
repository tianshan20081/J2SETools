package com.aoeng.base.str;

public class StrSplit {

	public static void main(String[] args) {
		String string = "zhang三";
		String[] strs = string.split("\n");
		for (String string2 : strs) {
			System.out.println(string2);
		}
	}

}
