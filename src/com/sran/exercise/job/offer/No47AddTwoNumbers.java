package com.sran.exercise.job.offer;

public class No47AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addTwoNumbers(14, 7));
	}

	public static int addTwoNumbers(int num1, int num2) {
		int sum = num1;
		int carry = 0;
		while (num2 != 0) {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		}

		return sum;
	}

}
