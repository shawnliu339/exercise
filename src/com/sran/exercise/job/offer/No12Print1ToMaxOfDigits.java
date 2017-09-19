package com.sran.exercise.job.offer;

public class No12Print1ToMaxOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print1ToMax(2);

	}
	
	static public void print1ToMax (int n) {
		if (n<=0) {
			return;
		}
		
		for(int i=0; i<10; i++) {
			StringBuffer num = new StringBuffer();
			num.append(i);
			print1ToMaxRecursively(num, n, 0);
		}
	}
	
	
	static private void print1ToMaxRecursively (StringBuffer num, int length, int index) {
		if (index == length-1) {
			printNumber(num);
			return;
		}
		
		for (int i=0; i<10; i++) {
			num.replace(index+1, index+2, String.valueOf(i));
			print1ToMaxRecursively(num, length, index+1);
		}
	}
	
	static private void printNumber(StringBuffer num) {
		boolean isFirstZero = true;
		for (int i=0; i<num.length(); i++) {
			if (isFirstZero && num.charAt(i)!='0') {
				isFirstZero = false;
			}
			
			if (!isFirstZero) {
				System.out.print(num.charAt(i));
			}
		}
		
		System.out.println();
	}

}
