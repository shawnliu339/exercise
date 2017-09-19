package com.sran.exercise.job.offer;

public class No11Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(-2,-3));;

	}
	
	static boolean invalidInput = false;
	
	public static double power(double base, int exponent) {
		
		if (Double.compare(base, 0.0) == 0) {
			invalidInput = true;
			return 0.0;
		}
		
		int absExponent = abs(exponent);
		
		invalidInput = false;
		if (exponent == 0) {
			return 1.0;
		}
		
		double result = unsignedPow(base, absExponent);
		if (exponent <0) {
			result = 1.0 / unsignedPow(base, absExponent);
		}
		
		return result;
	}
	
	private static int abs(int num) {
		if (num < 0) {
			return -num;
		}
		
		return num;
	}
	private static double unsignedPow(double base, int exponent) {
		double result = 1;
		for(int i=0; i<exponent; i++) {
			result *= base;
		}
		return result;
	}

}
