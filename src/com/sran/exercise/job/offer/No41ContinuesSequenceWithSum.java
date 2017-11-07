package com.sran.exercise.job.offer;

import java.util.ArrayList;

public class No41ContinuesSequenceWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

		if (sum < 2) {
			return results;
		}

		int small = 1;
		int big = 2;
		int middle = 1 + sum >>> 1;
		int currentSum = small + big;

		while (small < middle) {
			if (currentSum == sum) {
				results.add(createResult(small, big));
			}

			while (currentSum < sum) {
				big++;
				currentSum += big;
				
				if (currentSum == sum) {
					results.add(createResult(small, big));
				}
			}
			
			currentSum -= small;
			small++;
		}
		return results;
	}

	public ArrayList<Integer> createResult(int small, int big) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = small; i <= big; i++) {
			result.add(i);
		}

		return result;
	}
}
