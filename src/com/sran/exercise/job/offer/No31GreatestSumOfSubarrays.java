package com.sran.exercise.job.offer;

public class No31GreatestSumOfSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,-3, 3, 4, 5, -3};
		System.out.println(findGreateSum(nums));

	}
	
	public static int findGreateSum(int[] nums) {
		
		if (nums==null || nums.length<=0) {
			//错误处理
			return 0;
		}
		
		int currentSum = 0;
		int maxSum = 0;
		
		for (int i=0; i<nums.length; i++) {
			if(currentSum <= 0) {
				currentSum = nums[i];
			} else {
				currentSum += nums[i];
			}
			
			if (maxSum<currentSum) {
				maxSum = currentSum;
			}
		}
		
		
		return maxSum;
	}

}
