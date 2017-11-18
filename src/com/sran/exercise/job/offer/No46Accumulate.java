package com.sran.exercise.job.offer;

public class No46Accumulate {

	public static int getSum(int n) {
		int sum = 0;
		boolean flag = n>0 && (sum=n + getSum(n-1))>0;
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSum(100));
	}
	
	
}