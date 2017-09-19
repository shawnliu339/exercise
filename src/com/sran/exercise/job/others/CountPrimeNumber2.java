package com.sran.exercise.job.others;

public class CountPrimeNumber2 {
	public static void main(String[] args) {
		
		int number = 0;
		
		// 1 to 100000 in step of 10000
		for (int limit = 10000; limit <= 100000; limit += 10000) {
			
			//print step
			System.out.println(limit);
			Double startTime = (double) System.currentTimeMillis();
			//count number of prime and print the number
			number += countPrime(limit-9999, limit);
			System.out.println(number);
			Double endTime = (double) System.currentTimeMillis();
			Double duration = endTime - startTime;
			//print computing time
			System.out.println(duration.toString() + "ms");
		}
	}

	public static int countPrime(int start, int end) {
		// why input int limit above instead of int i?
		int number = 0;
		for (int i = start; i <= end; i++) {
			if(i==0 || i==1) {
				continue;
			}
			
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
