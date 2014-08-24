package com.aoeng.base.interview.heima;

/*
 兔子问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
 问第二十个月的时候兔子对数为多少？ 
 可以用递归，也可以用其他方法，但要说明你选择的理由。
 
 思路：这道题目首先你得分析出兔子问题的规律。
 分析：
 		月数		兔子对数
		第一月：		1
		第二月：		1
		第三月：		2
		第四月：		3
		第五月：		5
		第六月：		8
		...
		我们看到数据的变化：
		1,1,2,3,5,8...
		
有三种方式实现这道题目：
A:数组
B:变量的变化
C:递归

最终选择：
使用递归，理由是递归编程简单,代码容易理解,但缺点是效率不高,而且有深度限制,如果深度太深,则堆栈会溢出。
 */

public class Test4 {
	public static void main(String[] args) {
		// 第20个月的时候，兔子的对数
		int result = fib(20);
		System.out.println("result:"+result);
		
		//其他做法
		//定义一个数组
		int[] arr = new int[20];
		arr[0] = 1;
		arr[1] = 1;
		for(int x=2; x<arr.length; x++){
			arr[x] = arr[x-1]+arr[x-2];
		}
		System.out.println("arr[19]:"+arr[19]);
		
		//再来一个
		/*
		 * 假设相邻的两个数据分别是a,b
		 * 前两个数据：	
		 * 		a=1,b=1
		 * 接下来的两个数据：
		 * 		a=1,b=2
		 * 		现在的a是以前的b,现在的b是以前的a+b
		 * 
		 * 接着看：2,3
		 */
		int a = 1;
		int b = 1;
		for(int x=0;x<18; x++){
			//定义临时变量记录以前的a
			int temp = a;
			//把以前的b赋值给现在的a
			a = b;
			//把以前的a+b赋值给现在的b
			b = temp+b;
		}
		System.out.println("b:"+b);
		
	}

	// 假设fib(n)表示第n个月的数据
	// 请问：第n-1个月的数据怎么表示？fib(n-1)
	// 同理：第n-2个月的数据怎么表示？fib(n-2)
	public static int fib(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fib(n-1)+fib(n-2);
		}
	}
}
