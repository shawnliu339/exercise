package com.sran.exercise.job.offer;

public class No09Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(loop(100));
	}

	public static long recursive(long n) {
		long result = 0;

		if (n == 1)
			result = 1;

		if (n > 1)
			result = recursive(n - 1) + recursive(n - 2);

		return result;
	}

	// 从下往上计算，即从第一个开始计算
	public static long loop(long n) {
		long f1 = 0;
		long f2 = 1;
		long fn = 0;

		if (n == 0)
			return f1;
		if (n == 1)
			return f2;

		for (int i = 2; i <= n; i++) {
			fn = f1 + f2;
			f1 = f2;
			f2 = fn;
		}

		return fn;
	}
}
