package com.sran.exercise.job.offer;

import java.util.Arrays;

public class No14ReorderArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,4,8,10,1,3,14,15};
		reorder(nums);
		System.out.println(Arrays.toString(nums));

	}
	
	public static void reorder(int[] nums) {
		
		if (nums == null || nums.length<=1) {
			return;
		}
		
		int left = 0;
		int right = nums.length-1;
		
		while (left < right) {
			while (left < right && nums[left]%2 != 0) {
				left++;
			}
			
			while (left < right && nums[right]%2 ==0) {
				right--;
			}
			
			if (left < right) {
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
			}
			
		}
		
	}

}
