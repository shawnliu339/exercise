package com.sran.exercise.job.offer;

import java.util.Arrays;

public class No00SimpleSort {

	public static void main(String[] args) {
		// Bubble Sort
		int[] bubbleSort = {};
		bubbleSort(bubbleSort);
		bubbleSort = new int[] { 3, 5, 1, 8, 6, 2 };
		bubbleSort(bubbleSort);
		System.out.println(Arrays.toString(bubbleSort));

		// Select Sort
		int[] selectSort = {};
		selectSort(selectSort);
		selectSort = new int[] { 3, 5, 1, 8, 6, 2 };
		selectSort(selectSort);
		System.out.println(Arrays.toString(selectSort));

		// Insert Sort
		int[] insertSort = {};
		insertSort(insertSort);
		insertSort = new int[] { 3, 5, 1, 8, 6, 2 };
		insertSort(insertSort);
		System.out.println(Arrays.toString(insertSort));
	}
	
	private static void insertSort(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return;
		}

		//第一个循环用于分割理牌和抽牌，小于i的左侧为插入牌，大于i的右侧为抽牌
		for (int i = 1; i < nums.length; i++) {
			
			//抽牌
			int target = nums[i];
			int j = i;

			//理牌，后移
			while (j > 0 && target < nums[j - 1]) {
				nums[j] = nums[j - 1];
				j--;
			}

			//插牌，插入
			nums[j] = target;
		}
	}

	private static void selectSort(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return;
		}

		for (int i = 0; i < nums.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[minIndex] > nums[j]) {
					minIndex = j;
				}
			}

			if (!(minIndex == i)) {
				swap(nums, minIndex, i);
			}
		}

	}

	public static void bubbleSort(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return;
		}

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = nums.length - 1; i < j; j--) {
				if (nums[j] < nums[j - 1]) {
					swap(nums, j, j - 1);
				}
			}
		}
	}

	private static void swap(int[] nums, int from, int to) {
		int tmp = nums[from];
		nums[from] = nums[to];
		nums[to] = tmp;
	}
}
