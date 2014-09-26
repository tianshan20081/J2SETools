package com.aoeng.base.date;

import java.util.Calendar;
import java.util.Date;

public class DayInWeek {

	public static void main(String[] args) {
		String[] weeks = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Date dt = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 2);
		Calendar cl = Calendar.getInstance();
		cl.setTime(dt);
		int i = cl.get(Calendar.DAY_OF_WEEK) - 1;
		if (i < 0) {
			i = 0;
		}

		System.out.println(weeks[i]);
	}

}
