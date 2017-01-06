package com.sran.exercise.leetcode.array.easy;

import java.util.Arrays;

public class TwoSum1 {

	public static void main(String[] args) {
		int [] nums = {2, 7, 11, 15};
		int [] result = twoSum1(nums, 9);
		System.out.print(result[0] + " " + result[1]);

	}

	public static int[] twoSum(int[] nums, int target) {

		int[] indices = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {

			for (int j = i + 1; j < nums.length; j++) {

				int sum = nums[i] + nums[j];
				if (sum == target) {
					indices[0] = i;
					indices[1] = j;
					return indices;
				}
			}
		}
		return indices;
	}
	
	public static int [] twoSum1 (int[] nums, int target) {
		
		int[] indices = new int[2];
		int left = 0;
		int right = nums.length - 1;
		Arrays.sort(nums);
		
		while (right > left) {
			
			if (nums[left] + nums[right] < target) {
				left++;
			} else if (nums[left] + nums[right] > target) {
				right--;
			} else {
				indices[0] = left;
				indices[1] = right;
				return indices;
			}
			
		}
		return indices;
		
		
	}

}
