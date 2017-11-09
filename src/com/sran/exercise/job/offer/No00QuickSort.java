package com.sran.exercise.job.offer;

import java.util.Arrays;

public class No00QuickSort {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] nums = null;
		quickSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void quickSort(int[] nums) throws Exception {
		if (nums==null || nums.length==0) {
			return;
		}
		
		sort(nums, 0, nums.length-1);
	}
	
	public static void sort(int[] nums, int start, int end) throws Exception {
		if (start >= end) {
			return;
		}
		
		int index = partition(nums, start, end);
		if (index>start) {
			sort(nums, start, index-1);
		}
		if (index<end) {
			sort(nums, index+1, end);
		}
	}

	public static int partition(int[] nums, int start, int end) throws Exception {
		
		if (nums==null || nums.length<=0 || start<0 || end>=nums.length) {
			throw new Exception("无效输入！！");
		}
		
		int pivotValue = nums[start];
		int pivotKey = start;
		
		while(start < end) {
			while (start<end && nums[end]>=pivotValue) {
				end--;
			}
			
			while (start<end && nums[start]<=pivotValue) {
				start++;
			}
			
			swap(nums, start, end);
		}
		
		swap(nums, pivotKey, start);
		
		return start;
	}
	
	public static void swap(int[] nums, int from, int to) {
		int tmp = nums[from];
		nums[from] = nums[to];
		nums[to] = tmp;
	}
}
