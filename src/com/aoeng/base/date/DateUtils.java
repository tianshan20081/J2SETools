/**
 * 
 */
package com.aoeng.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * @author sczhang 2015年1月14日 下午5:25:57
 */
public class DateUtils {

	@Test
	public void roun() {
		int n = 1;
		int i = (int) (Math.random() * n + 0.5 * n);
		System.out.println(i);
	}

	@Test
	public void testBetMonth() throws Exception {
		String dd = "2014-10-01";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(dd);
		int months = getBetweenMonth(date);
		System.out.println(months);
	}

	/**
	 * @param maxDate
	 * @return
	 */
	public static int getBetweenMonth(Date fromDate) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(fromDate.getTime());
		GregorianCalendar pFormer = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY),
				calendar.get(Calendar.MINUTE));
		GregorianCalendar pLatter = new GregorianCalendar();
		return monthsBetween(pFormer, pLatter);
	}

	public static int monthsBetween(GregorianCalendar pFormer, GregorianCalendar pLatter) {
		GregorianCalendar vFormer = pFormer, vLatter = pLatter;
		boolean vPositive = true;
		if (pFormer.before(pLatter)) {
			vFormer = pFormer;
			vLatter = pLatter;
		} else {
			vFormer = pLatter;
			vLatter = pFormer;
			vPositive = false;
		}

		int vCounter = 0;
		while (vFormer.get(vFormer.YEAR) != vLatter.get(vLatter.YEAR) || vFormer.get(vFormer.MONTH) != vLatter.get(vLatter.MONTH)) {
			vFormer.add(Calendar.MONTH, 1);
			vCounter++;
		}
		if (vPositive)
			return vCounter;
		else
			return -vCounter;
	}
}
