package com.aoeng.base.type;

public class BaseType {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(System.currentTimeMillis());
		String str = System.currentTimeMillis() + "";
		long ll = Long.parseLong(str);
		System.out.println(ll);
	}

}
