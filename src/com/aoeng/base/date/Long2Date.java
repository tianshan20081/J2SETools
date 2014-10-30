package com.aoeng.base.date;

import java.util.Date;

public class Long2Date {

	public static void main(String[] args) {
		String str = "1414492920000";
		long l = Long.parseLong(str);
		// 1411107119000;
		// 1411119673425
		// long l = System.currentTimeMillis();
		System.out.println(l);
		Date d = new Date(l);
		System.out.println(d.toLocaleString());
		
		String ll = System.currentTimeMillis()/1000+"";
		Date d2 = new Date(1411819620*1000L);
		
		
		System.out.println(d2.toLocaleString());
	}
}
