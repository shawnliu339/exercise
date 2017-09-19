package com.sran.exercise.job.offer;

import java.util.Arrays;

public class No12FullPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,2,3};
		permutate(nums);
	}
	
	public static void permutate(int[] nums) {
		
		if (nums.length <= 0) {
			return;
		}
		for (Integer num : nums) {
			int[] result = new int[3];
			result[0] = num;
			permutateByRecursion(nums, result, 0);
		}
	}
	
	public static void permutateByRecursion(int[] nums, int[] result, int index) {
		if (nums.length-1 == index) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (Integer num : nums ) {
			result[index + 1] = num;
			permutateByRecursion(nums, result, index+1);
		}
	}

}
