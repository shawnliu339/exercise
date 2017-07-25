package com.sran.exercise.job.offer;

public class No09RelatedQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(frog(9));

	}

	//递归解法
	public static int frog(int n) {
		int f0 = 1;
		int f1 = 1;
		int fn = 0;

		if (n == 0)
			return f0;
		if (n == 1)
			return f1;
		if (n > 1) {
			for (int i = n - 1; i >= 0; i--)
				fn += frog(i);

		}
		return fn;

	}
	/*
	 * 也可以用数学归纳法求出f(n)的公式后求解。
	 * 求得公式为f(n)=2^(n-1)。
	 * 求解过程：一级台阶时青蛙有1种跳法;
	 * 	两阶台阶时，起跳时有两种情况，跳一阶或者跳两阶。
	 *   跳一阶时，剩余跳法为f(1)种,跳两阶时跳法为1种，故总跳法为f(1)+1;
	 *  三阶台阶时，第一次跳有三种情况，跳一阶，跳两阶或直接跳三阶。当跳一阶时，剩余跳法为f(2)。
	 *   两阶时，剩余跳法为f(1)。三阶时跳法为1，故总跳法为f(1)+f(2)+1。
	 *  所以可以得出n阶台阶时总跳法为 f(n)=1+f(1)+f(2)+...+f(n-1)。
	 *  f(n)=(1+f(1)+...+f(n-2))+f(n-1)
	 *  f(n)=2f(n-1)
	 *  带入具体数字
	 *  f(2)=2f(1)=2
	 *  f(3)=2f(2)=2*2=2^2
	 *  f(4)=2f(3)=2*2^2=2^3
	 *  f(n)=2f(n-1)=2^(n-1)
	 *
	 */

}
