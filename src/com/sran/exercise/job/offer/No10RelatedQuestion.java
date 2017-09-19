package com.sran.exercise.job.offer;

public class No10RelatedQuestion {

	public static void main(String[] args) {
		System.out.println(question1(5));
		System.out.println(question2(1,2));
	}

	public static boolean question1(int num) {

		if ((num & (num - 1)) == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static int question2(int num1, int num2) {
		int diff = num1 ^ num2;
		int count = 0;
		while (diff != 0) {
			count++;
			diff = diff & (diff - 1);
		}
		return count;
	}

}
