package com.sran.exercise.job.offer;

public class NNo32NumberOf1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
	
	public static int numberBetween1ToN(int n) {
		int number=0;
		for (int i=1; i<=n; i++) {
			number += numberOf1(i);
		}
		return number;
	}
	
	public static int numberOf1 (int n) {
		int number = 0;
		while (n != 0) {
			if (n % 10 == 1) {
				number++;
			}

			n = n / 10;
		}
		
		return number;
	}

}
