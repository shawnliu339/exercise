package com.sran.exercise.job.logic.practice;

public class Lesson10 {

	public static void main(String[] args) {

		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		
		for (int i=1; i<=m; i++) {
			if (m%i == n%i) {
				System.out.println(i);
			}
		}
		
	}

}
