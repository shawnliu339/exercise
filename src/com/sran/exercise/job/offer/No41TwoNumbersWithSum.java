package com.sran.exercise.job.offer;

import java.util.ArrayList;

public class No41TwoNumbersWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<Integer> FindNumberWithSum(int [] array, int sum) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		if (array==null || array.length<=0) {
			return results;
		}
		
		int ahead = 0;
		int behind = array.length - 1;
		
		
		while (ahead<behind) {
			int currentSum = array[ahead] + array[behind];
			if (currentSum == sum) {
				results.add(array[ahead]);
				results.add(array[behind]);
				return results;
			}
			
			if (currentSum < sum ) {
				ahead++;
			} else {
				behind--;
			}
		}
		
		return results;
	}

}
