package com.aoeng.base.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {

	public static void main(String[] args) {

		boolean isSmsCode = tIsSmsCode("123456");
		boolean isSmsCodeInt = tIsSmsCodeInt("dfghhj");
		System.out.println(isSmsCode);
		System.out.println(isSmsCodeInt);
	}

	private static boolean tIsSmsCodeInt(String str) {
		// TODO Auto-generated method stub
		Pattern compile = Pattern.compile("\\d{6}");
		Matcher matcher = compile.matcher(str);
		return matcher.matches();
	}

	private static boolean tIsSmsCode(String code) {
		// TODO Auto-generated method stub
		String str = code.trim();
		Pattern compile = Pattern.compile("[0-9]{6}");
		Matcher matcher = compile.matcher(str);
		return matcher.matches();
	}

}
