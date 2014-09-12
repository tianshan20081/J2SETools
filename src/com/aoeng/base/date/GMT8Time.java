package com.aoeng.base.date;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class GMT8Time {
	public static void main(String[] args) {
		System.out.println(getGMT8Time());
	}

	/**
	 * Description: 获取 GMT8 时间
	 * 
	 * @return 将当前时间转换为 GMT8 时区后的 Date
	 */
	public static Date getGMT8Time() {
		Date gmt8 = null;
		try {
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.CHINESE);
			Calendar day = Calendar.getInstance();
			day.set(Calendar.YEAR, cal.get(Calendar.YEAR));
			day.set(Calendar.MONTH, cal.get(Calendar.MONTH));
			day.set(Calendar.DATE, cal.get(Calendar.DATE));
			day.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
			day.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
			day.set(Calendar.SECOND, cal.get(Calendar.SECOND));
			gmt8 = day.getTime();
		} catch (Exception e) {
			System.out.println("获取 GMT8 时间 getGMT8Time() error !");
			e.printStackTrace();
			gmt8 = null;
		}
		return gmt8;
	}

}
