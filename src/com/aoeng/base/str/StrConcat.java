package com.aoeng.base.str;

public class StrConcat {
	public static void main(String[] args) {
		String str = "ssssss";
		str.concat("543556");
		System.out.println(str);

		System.out.println(String.format("hello%ssafsdfsdg%d", "zhang", 45));

		String ssString = "张三ss";
		System.out.println(getCharacterNum(ssString));
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

			return (content.length() + getChineseNum(content));

		}

	}

	/**
	 * 
	 * @description 返回字符串里中文字或者全角字符的个数
	 * 
	 * @param s
	 * 
	 * @return
	 */

	public static int getChineseNum(String s) {

		int num = 0;

		char[] myChar = s.toCharArray();

		for (int i = 0; i < myChar.length; i++) {

			if ((char) (byte) myChar[i] != myChar[i]) {

				num++;

			}

		}

		return num;

	}
}
