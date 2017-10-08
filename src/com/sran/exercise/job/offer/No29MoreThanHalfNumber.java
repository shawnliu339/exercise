package com.sran.exercise.job.offer;

public class No29MoreThanHalfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,4,4,4,2,3};
		int num = findMiddleNum(nums, 0, nums.length-1);
		
		if (inputInvalid) {
			System.out.println("无效输入！");
		} else {
			System.out.println(num);
		}
	}
	
	//解法二:数组特性解法
	public static int findMiddleNum(int[]nums) {
		if (checkInvalidArray(nums)) {
			return 0;
		}
		
		int times = 0;
		int result = 0;
		
		for (int i=0; i<nums.length; i++) {
			
			if (times == 0) {
				result = nums[i];
				times = 1;
				continue;
			}
			
			if (result == nums[i]) {
				times++;
			}
			
			if (result != nums[i]) {
				times--;
			}
		}
		
		if (!checkMoreThanHalf(nums, result)) {
			return 0;
		}
		
		return result;
	}
	
	
	//解法一：快排解法
	public static int findMiddleNum(int[] nums, int start, int end) {
		
		if (checkInvalidArray(nums)) {
			return 0;
		}
		
		int mid = nums.length/2 - 1;
		int index = partition(nums, start, end);
		while (index != mid) {
			
			if (index < mid) {
				index = partition(nums, index+1, end);
			}
			
			if (index > mid) {
				index = partition(nums, start, index-1);
			}
			
		}
		
		
		int result = nums[mid];
		if (!checkMoreThanHalf(nums, result)) {
			return 0;
		};
		
		return result;
	}
	
	public static boolean inputInvalid = false;
	
	public static int partition (int[] nums, int start, int end) {
		int pivotKey = start;
		int pivotValue = nums[start];
		
		while (start < end) {
			while (start<end && nums[end]>=pivotValue) {
				end--;
			}
			
			while (start<end && nums[start]<=pivotValue) {
				start++;
			}
			
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
		}
		
		int tmp = nums[pivotKey];
		nums[pivotKey] = nums[start];
		nums[start] = tmp;
		
		return start;
	}
	
	private static boolean checkInvalidArray (int[] nums) {
		
		inputInvalid = false;
		
		if (nums == null || nums.length <=0) {
			inputInvalid = true;
		}
		
		return inputInvalid;
		
	}
	
	private static boolean checkMoreThanHalf (int[] nums, int result) {
		int times = 0;
		for (int i=0; i<nums.length; i++) {
			if (nums[i] == result) {
				times++;
			}
		}
		
		inputInvalid = true;
		boolean moreThanHalf = false;
		if (times*2 >= nums.length) {
			inputInvalid = false;
			moreThanHalf = true;
		}
		
		return moreThanHalf;
	}

}
