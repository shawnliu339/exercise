package com.sran.exercise.job.others;

public class CountPrimeNumber1 {
	public static void main(String[] args) {
		
		// 1 to 100000 in step of 10000
		for (int limit = 10000; limit <= 100000; limit += 10000) {
			
			System.out.println(limit);
			Double startTime = (double) System.currentTimeMillis();
			System.out.println(countPrime(limit));
			Double endTime = (double) System.currentTimeMillis();
			Double duration = endTime - startTime;
			System.out.println(duration.toString() + "ms");
		}
	}

	public static int countPrime(int end) {
		// why input int limit above instead of int i?
		int number = 0;
		for (int i = 2; i <= end; i++) {
			if (isPrime(i)) {
				number++;
			}
		}
		return number;
	}

	public static boolean isPrime(int num) {
		for (int divisor = 2; divisor < num; divisor++) {
			if (num % divisor == 0) {
				return false;
			}
		}
		return true;
	}

}
