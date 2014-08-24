package com.aoeng.base.interview;

public class CommonDivisor {

	public static void main(String[] args) {
		int n1 = 30;
		int n2 = 40;
		int n3 = commonDivisior(n1, n2);
		System.out.println(n3);

		int n4 = gcd(n1, n2);
		System.out.println(n4);

		System.out.println("The min Gong Bei Shu is " + (n1 * n2) / n4);
	}

	private static int gcd(int n, int m) {
		// TODO Auto-generated method stub
		while (true) {
			if ((m = m % n) == 0) {
				return n;
			}
			if ((n = n % m) == 0) {
				return m;
			}
		}
	}

	private static int commonDivisior(int n, int m) {
		// TODO Auto-generated method stub
		if (n < 0 || m < 0) {
			System.out.println(" the error !");
			return -1;
		}
		if (m == 0) {

			return n;
		}
		return commonDivisior(m, n % m);
	}

}
