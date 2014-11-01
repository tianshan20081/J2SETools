package com.aoeng.tools.utils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.util.TextUtils;

public class StringUtils {
	/**
	 * 判断字符串是否为空 为空的 标准 null ，“” ，“ ”，“null”，“NULL”
	 * 
	 * @param path
	 * @return
	 */
	public static boolean isEmpty(String path) {
		// TODO Auto-generated method stub
		if (null == path || "".equalsIgnoreCase(path.trim()) || "null".equalsIgnoreCase(path.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 判斷字符串是否相等，其中有一個空字符串 或者 null 則返回 false
	 * 
	 * @param args
	 * @return
	 */
	public static boolean isEquals(String... args) {
		String last = null;
		for (int i = 0; i < args.length; i++) {
			String str = args[i];
			if (isEmpty(str)) {
				return false;
			}
			if (last != null && !str.equalsIgnoreCase(last)) {
				return false;
			}
			last = str;
		}
		return true;
	}

	/**
	 * 格式化文件大小，不保留末尾的 0
	 * 
	 * @param len
	 * @return
	 */
	public static String formatFileSize(long len) {
		return formatFileSize(len, false);
	}

	/**
	 * 格式化文件大小，不保留末尾的 0 ，达到长度一致
	 * 
	 * @param len
	 * @param b
	 * @return
	 */
	private static String formatFileSize(long len, boolean keepZero) {
		// TODO Auto-generated method stub
		String size;
		DecimalFormat formatKeepTwoZero = new DecimalFormat("#.00");
		DecimalFormat formatKeepOneZero = new DecimalFormat("#.0");
		if (len < 1024) {
			size = String.valueOf(len + "B");
		} else if (len < 10 * 1024) {
			size = String.valueOf(len * 100 / 1024 / (float) 100) + "KB";
		} else if (len < 100 * 1024) {
			size = String.valueOf(len * 100 / 1024 / (float) 10) + "KB";
		} else if (len < 1024 * 1024) {
			size = String.valueOf(len / 1024) + "KB";
		} else if (len < 10 * 1024 * 1024) {
			// [10MB, 100MB)，保留一位小数
			if (keepZero) {
				size = String.valueOf(formatKeepOneZero.format(len * 10 / 1024 / 1024 / (float) 10)) + "MB";
			} else {
				size = String.valueOf(len * 10 / 1024 / 1024 / (float) 10) + "MB";
			}
		} else if (len < 1024 * 1024 * 1024) {
			// [100MB, 1GB)，个位四舍五入
			size = String.valueOf(len / 1024 / 1024) + "MB";
		} else {
			// [1GB, ...)，保留两位小数
			size = String.valueOf(len * 100 / 1024 / 1024 / 1024 / (float) 100) + "GB";
		}
		return size;
	}

	public static boolean isMobile(String mobile) {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(mobile)) {
			return false;
		}

		String mobileTrim = mobile.trim();
		Pattern patternMobile = Pattern.compile("^1[3|4|5|8][0-9]{9}$");
		Matcher matcherMobile = patternMobile.matcher(mobileTrim);
		if (!matcherMobile.matches()) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean isSmsCode(String smsCode) {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(smsCode)) {
			return false;
		}
		String str = smsCode.trim();
		Pattern compile = Pattern.compile("\\d{6}");
		Matcher matcher = compile.matcher(str);
		return matcher.matches();
	}

	public static boolean isPassword(String pwd) {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(pwd)) {

			return false;
		}
		String passwordTrim = pwd.trim();
		Pattern patternAccount = Pattern.compile("^([a-zA-Z0-9_-`~!@#$%^&*()+\\|\\\\=,./?><\\{\\}\\[\\]]{6,11})+$");
		Matcher matcherAccount = patternAccount.matcher(passwordTrim);
		return matcherAccount.matches();
	}

	/**
	 * 获取字符串的长度
	 * 
	 * @param string
	 * @return
	 */
	public static int getChineseNum(String str) {
		// TODO Auto-generated method stub
		int num = 0;

		char[] myChar = str.toCharArray();

		for (int i = 0; i < myChar.length; i++) {

			if ((char) (byte) myChar[i] != myChar[i]) {
				num++;
			}
		}
		return num;
	}

	/**
	 * 
	 * @description 获取一段字符串的字符个数（包含中英文，一个中文算2个字符）
	 * 
	 * @param content
	 * 
	 * @return
	 */

	public static int getCharacterNum(final String content) {

		if (null == content || "".equals(content)) {
			return 0;

		} else {
			return (content.length() + getChineseNum(content)) / 2;
		}

	}
}
