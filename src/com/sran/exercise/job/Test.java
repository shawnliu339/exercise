package com.sran.exercise.job;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2, 3};
		permutation(nums,0);
	}
	
	public static void permutation(int[] nums, int start) {
		if (nums.length<=0 || nums==null) {
			return;
		}
		
		if (start == nums.length) {
			System.out.println(Arrays.toString(nums));
		}
		
		for (int i=start; i<nums.length; i++) {
			
			if (doesSwap(nums,start, i)) {
				swap(nums, start, i);
				permutation(nums, start+1);
				swap(nums, start, i);
			}
		}
	}
	
	private static boolean doesSwap(int[] nums, int start, int end) {
		
		for (int i=start; i<end; i++) {
			if (nums[end] == nums[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	private static void swap(int[] nums, int from, int to) {
		int tmp = nums[from];
		nums[from] = nums[to];
		nums[to] = tmp;
	}

}
