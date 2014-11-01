package com.aoeng.base.math;

import com.aoeng.tools.utils.StringUtils;

public class Main {

	public static void main(String[] args) {
		boolean[] isSel = new boolean[] { true, true, true, true, true, true, true };
		int n = 0;
		for (int i = 0; i < isSel.length; i++) {
			if (isSel[i]) {
				n += Math.scalb(1, i);
			}
		}
		// System.out.println(n);

		int repeat = 119;
		String str = getDays(repeat);
		System.out.println(str);

		System.out.println("dayindex" + getSelIndex(repeat));
	}

	private static String getDays(int repeat) {
		String[] days = { "周日", "周一", "周二", "周三", "周四", "周五", "周六", "执行一次" };
		StringBuffer sb = new StringBuffer();
		if (repeat == 0) {
			sb.append(days[days.length - 1]);
			return sb.toString();
		}
		if (repeat == 127) {
			return "每天";
		}
		String dds = Integer.toBinaryString(repeat);
		System.out.println("dds---" + dds);
		if (StringUtils.isEmpty(dds)) {
			return sb.toString();
		}
		for (int j = dds.length() - 1; j >= 0; j--) {
			char ch = dds.charAt(j);
			if (ch != '0') {
				sb.append(",").append(days[dds.length() - 1 - j]);
			}
		}
		if (sb.toString().startsWith(",")) {
			return sb.toString().substring(1, sb.toString().length());
		}
		return sb.toString();
	}

	public static String getSelIndex(int repeat) {
		// TODO Auto-generated method stub
		String str = "";
		if (repeat == 0) {
			return "0";
		}
		if (repeat == 127) {
			return "0123456";
		}
		String dds = Integer.toBinaryString(repeat);
		System.out.println("dds---" + dds);
		if (StringUtils.isEmpty(dds)) {
			return "0";
		}
		for (int j = dds.length() - 1; j >= 0; j--) {
			String ch = dds.charAt(j) + "";
			System.out.println(ch + "ch");
			if ("1".equals(ch)) {
				str += ((dds.length() - 1 - j) + "");
			}
		}
		return str;
	}
}
