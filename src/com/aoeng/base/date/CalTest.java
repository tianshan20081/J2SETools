package com.aoeng.base.date;

import java.util.Calendar;

public class CalTest {

	public static void main(String[] args) {
		Calendar cl = Calendar.getInstance();
		System.out.println(cl.getTime().toGMTString());
		cl.add(Calendar.MINUTE,  6);

		System.out.println(cl.getTime().toGMTString());
	}
}
