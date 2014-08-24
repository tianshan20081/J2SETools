package com.aoeng.base.interview.heima;

import java.util.Scanner;
/*
 public static String round(String str,int digit)
 参数1：数字和小数点组成的字符串。如"12.568"
 参数2：四舍五入的小数位数。如：2
 返回值：根据条件四舍五入后的字符串值。"12.57"
 注意：自行编写针对字符串操作的算法，不能使用Java现成的用于四舍五入的API方法

 思路：首先要搞明白这道题目考察的是自己编码实现的能力，不能使用API的功能。
 	     还有就是要明白四舍五入的原理。
 */
public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数字字符串:");
		String str = sc.nextLine();
		System.out.println("请输入保留几位有效数字:");
		int n = sc.nextInt();
		String s = round(str, n);
		System.out.println(s);
	}

	public static String round(String str, int digit) {
		// 把浮点数字符串转换成浮点数
		double f = Double.parseDouble(str);
		// 四舍五入的原理是:把要舍弃的位的前一位加0.5然后舍弃后面即可。
		double number = 0.5;
		// 如果digit<=0，不做任何处理
		if (digit <= 0) {
			throw new RuntimeException("四舍五入的小数位数有问题");
		}
		int x = 0;
		while (x < digit) {
			number /= 10;
			x++;
		}
		// 运算
		double d = f + number;
		// 最后截取字符串
		String s = String.valueOf(d);
		// 先找到.的位置
		int index = s.indexOf(".");
		// 截取
		String ss = s.substring(0, index + digit + 1);
		return ss;
	}
}
