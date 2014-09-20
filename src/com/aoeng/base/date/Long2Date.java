package com.aoeng.base.date;

import java.util.Date;

public class Long2Date {

	public static void main(String[] args) {
		String str = "1411107119000";
		long l = Long.parseLong(str);
		// 1411107119000;
		// 1411119673425
		// long l = System.currentTimeMillis();
		System.out.println(l);
		Date d = new Date(l);
		System.out.println(d.toLocaleString());
	}
}
