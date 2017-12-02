package com.sran.exercise.job.offer;

import java.util.Arrays;

public class No00MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
		//nums1 = new int[] {};
		// nums1 = new int[]{2,0,0,0,0,2};
		// nums1 = new int[]{2,1};
		mergeSort(nums1);
		System.out.println(Arrays.toString(nums1));

	}

	public static void mergeSort(int[] nums) {
		int[] src = nums;
		int[] dest = nums.clone();
		mergeSortCore(src, dest, 0, dest.length - 1);
	}

	public static void sort(int[] src, int[] dest, int low, int high) {
		if (src.length <= 0 || src == null || low < 0 || high >= src.length || low >= high)
			return;

		int mid = (low + high) >>> 1;
		sort(src, dest, low, mid);
		sort(src, dest, mid + 1, high);
		merge(src, dest, low, high);

	}

	public static void merge(int[] src, int[] dest, int low, int high) {

		int mid = (low + high) >>> 1;
		for (int i = low, p = low, q = mid + 1; i <= high; i++) {
			// 该处的计算条件非常容易出错
			// 右指针超过界限，则将左子列全部复制到dest中
			if (q > high || p <= mid && src[p] <= src[q]) {
				dest[i] = src[p++];
			} else {
				dest[i] = src[q++];
			}
		}

		for (int i = low; i <= high; i++) {
			src[i] = dest[i];
		}

	}

	public static void mergeSortCore(int[] src, int[] dest, int low, int high) {
		if (low >= high) {
			return;
		}

		int mid = (low + high) >>> 1;
		mergeSortCore(src, dest, low, mid);
		mergeSortCore(src, dest, mid + 1, high);

		int i = low;
		int j = mid + 1;
		int destIndex = low;
		while (i <= mid && j <= high) {
			if (src[i] <= src[j]) {
				dest[destIndex++] = src[i++];
			} else {
				dest[destIndex++] = src[j++];
			}
		}

		while (i <= mid) {
			dest[destIndex++] = src[i++];
		}

		while (j <= high) {
			dest[destIndex++] = src[j++];
		}

		for (destIndex = low; destIndex <= high; destIndex++) {
			src[destIndex] = dest[destIndex];
		}
	}

}
