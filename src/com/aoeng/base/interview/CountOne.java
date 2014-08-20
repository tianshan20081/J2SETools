package com.aoeng.base.interview;

public class CountOne {

	public static void main(String[] args) {
		int n = 100;
		int sum = f(n);
		System.out.println(Integer.toBinaryString(n));
		System.out.println(sum);
	}

	private static int f(int n) {
		// TODO Auto-generated method stub
		if (n == 1) {
			return 1;
		}
		if (n == 0) {
			return 0;
		}
		// System.out.println(n);
		return f(n / 2) + f(n % 2);
	}

}
