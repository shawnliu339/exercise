package com.sran.exercise.job.offer2;

public class NO15NumberOf1InBinary {
	
	public static void main (String[] args) {
		NO15NumberOf1InBinary o = new NO15NumberOf1InBinary();
		System.out.println(o.NumberOf1(-1));
	}

	public int NumberOf1(int n) {
		if (n<0) {
			n *= -1;
		}

	    int count = 0;
	    while (n != 0) {

	        if ((n & 1) == 1) {
	            count++;
	        }
	        n = n>>>1;
	    }

	    return count;
	}

}
