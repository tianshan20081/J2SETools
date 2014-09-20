package com.aoeng.base.list;

import java.util.ArrayList;

public class Text {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("ssddd");
		list.add("svdvd");
		list.add("123");
		list.add("fff");

		for (String string : list) {
			if (string.equals("fff")) {
				list.add("hhh");
				break;
			}
		}
		for (String string : list) {
			System.out.println(string);
		}
	}
}
