package com.aoeng.base.str;

public class StrSplit {

	public static void main(String[] args) {
		String string = "zhang三";
		String[] strs = string.split("\n");
		for (String string2 : strs) {
			System.out.println(string2);
		}
		
		String path = "sacvasvav/savasvasd/safa.sf/s.png";
		String type = path.substring(path.lastIndexOf("."), path.length());
		System.out.println(type);
		
		
		
		System.out.println(String.valueOf(-2));
		
		float sx = 152.5f;
		int sy = (int) sx ;
		System.out.println(sy);
	}

}
