package com.aoeng.base.interview.heima;

import java.util.Scanner;

/*
 某个公司采用公用电话传递数据信息，数据是小于8位的整数，为了确保安全，在传递过程中需要加密，加密规则如下：
 首先将数据倒序，然后将每位数字都加上5，再用和除以10的余数代替该数字，最后将第一位和最后一位数字交换。 
 请任意给定一个小于8位的整数，然后，把加密后的结果在控制台打印出来。
 
 思路：
 1：数据是小于8位的整数 通过分析我们发现用int类型表示。而且这个是不确定的，定义变量。
 int number = ?;
 2：数据倒序	
 这个时候发现，数据要倒序，就是可能每个位上的数据都要变化。那么就是说有多个数据要变化。
 一个数据用变量，多个数据用容器。目前我们只有数组容器。是不是用数组啊。
 数组的元素类型，数组的长度
 //小于8为的整数。
 int[] arr = new int[8];
 3：然后将每位数字都加上5，再用和除以10的余数代替该数字
 这个时候，我们需要遍历数组，取得每一个元素进行操作。
 (arr[x]+5)%10;

 arr[x]+=5;
 arr[x]%=10;
 4：将第一位和最后一位数字交换
 int temp = arr[0];
 arr[0] = arr[实际长度-1];
 arr[实际长度-1] = temp;

 5：遍历一次。
 */

public class Test1 {
	public static void main(String[] args) {
		// 封装键盘录入数据
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个小于8位的整数：");
		int number = sc.nextInt();
		// 这里数据的校验我省略了
		printNumber(number);
	}

	// 遍历数组
	public static void printArray(int[] arr, int n) {
		System.out.print("[");
		for (int x = 0; x < n; x++) {
			if (x != n - 1) {
				System.out.print(arr[x] + ",");
			} else {
				System.out.print(arr[x]);
			}
		}
		System.out.println("]");
	}

	/*
	 * 需求：加密 明确： 返回类型 输出 void 未知内容 数据是未知的
	 */
	public static void printNumber(int number) {
		int[] arr = new int[8];
		int index = 0;

		while (number > 0) {
			arr[index] = number % 10;
			number = number / 10;
			index++;
		}

		// System.out.println("数据倒序存到数组后输出数组：");
		// printArray(arr, index);

		for (int x = 0; x < index; x++) {
			arr[x] += 5;
			arr[x] %= 10;
		}

		// System.out.println("数组操作后输出数组：");
		// printArray(arr, index);

		// 交换数据
		int temp = arr[0];
		arr[0] = arr[index - 1];
		arr[index - 1] = temp;

		// System.out.println("数组首尾交换后输出数组：");
		System.out.println("加密后的结果是：");
		printArray(arr, index);
	}
}
