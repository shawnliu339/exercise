package com.sran.exercise.dynamic_programming;

public class Fibonacci {
	
	static boolean invalidInput = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(dp(40));
		System.out.println(fnumber(30));
	}
	
	public static int fnumber(int n) {
		if (n<0) {
			invalidInput = true;
			return 0;
		}
		
		if(n==0) {
			return 0;
		}
		
		if(n==1) {
			return 1;
		}
		
		int n1 = fnumber(n-1);
		int n2 = fnumber(n-2);
		
		return n1+n2;
	}
	
	public static int dp(int n) {
		if (n<0) {
			invalidInput = true;
			return 0;
		}
		
		invalidInput = false;
		
		if(n==0) {
			return 0;
		}
		
		if(n==1) {
			return 1;
		}
		
		int n1 = 1;
		int n2 = 0;
		for (int i=2; i<=n; i++) {
			
			int tmp = n1;
			n1 = n1 + n2;
			n2 = tmp;
		}
		
		return n1;
	}

}
