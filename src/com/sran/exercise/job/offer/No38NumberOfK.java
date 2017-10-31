package com.sran.exercise.job.offer;

public class No38NumberOfK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		System.out.println(getNumberOfK(nums, 1));
	}
	
	public static int getNumberOfK(int[] nums, int query) {
		if (nums == null || nums.length <= 0) {
			return -1;
		}
		
		int start = getFirstK(nums, 0, nums.length-1, query);
		int end = getLastK(nums, 0, nums.length-1, query);
		int number = -1;
		if (start!=-1 && end!=-1) {
			number = end-start+1;
		}
		return number;
	}

	public static int getFirstK(int[] nums, int start, int end, int query) {

		if (nums == null || nums.length <= 0 || start > end) {
			return -1;
		}

		int midIndex = (start+end) >>> 1;
		int midValue = nums[midIndex];

		if (midValue == query) {
			if (midIndex > 0 && nums[midIndex - 1] != query || midIndex == 0) {
				return midIndex;
			} else {
				end = midIndex - 1;
			}
		} else if (midValue > query) {
			end = midIndex - 1;
		} else {
			start = midIndex + 1;
		}
		return getFirstK(nums, start, end, query);
	}

	public static int getLastK(int[] nums, int start, int end, int query) {
		if (nums == null || nums.length <= 0 || start > end) {
			return -1;
		}

		int midIndex = (start+end) >>> 1;
		int midValue = nums[midIndex];

		if (midValue == query) {
			if (midIndex < nums.length-1 && nums[midIndex + 1] != query || midIndex == nums.length-1) {
				return midIndex;
			} else {
				start = midIndex + 1;
			}
		} else if (midValue > query) {
			end = midIndex - 1;
		} else {
			start = midIndex + 1;
		}
		return getLastK(nums, start, end, query);
	}

}
