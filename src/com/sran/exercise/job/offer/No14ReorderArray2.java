package com.sran.exercise.job.offer;

import java.util.Arrays;

public class No14ReorderArray2 {

	public static void main(String[] args) throws Exception {
		int[] nums = {2,4,8,10,1,3,15};
		reorder(nums, new Condition<Integer>() {
			@Override
			public boolean judge(Integer num) {
				return isEven(num);
			}
		});
		System.out.println(Arrays.toString(nums));
	}
	
	static Boolean isEven(int n) {
		return n%2 != 0;
	}

	public static void reorder(int[] nums, Condition<Integer> condition) throws Exception {

		if (nums == null || nums.length <= 1) {
			return;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			while (left < right && condition.judge(nums[left])) {
				left++;
			}

			while (left < right && !condition.judge(nums[right])) {
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

interface Condition<T> {
	public boolean judge(T num);
	
}
