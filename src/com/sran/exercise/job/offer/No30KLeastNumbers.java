package com.sran.exercise.job.offer;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class No30KLeastNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,1,7,8,5,3,9,5,2,44,3,2};
		Integer[] mins = findLeastNumberByContainer(nums, 4);
		System.out.println(Arrays.toString(mins));
		
	}
	
	public static Integer[] findLeastNumberByContainer(int[] nums, int k) {
		if (nums==null || nums.length==0) {
			return null;
		}
		
		TreeSet<Integer> leastNums = new TreeSet<Integer>();
		for(int i=0; i<nums.length; i++) {
			if (leastNums.size()<k) {
				leastNums.add(nums[i]);
			} else {
				
				int maxNum = leastNums.last();
				if (maxNum > nums[i]) {
					leastNums.pollLast();
					leastNums.add(nums[i]);
				}
				
			}
		}
		/*
		int[] result = new int[k];
		for (int i=0; i<result.length; i++) {
			result[i] = leastNums.
		}*/
		
		return leastNums.toArray(new Integer[4]);
	}
	
	public static int[] findLeastNumbers(int[] nums, int k) {
		if (nums == null || nums.length==0) {
			return null;
		}
		
		int start = 0;
		int end = nums.length-1;
		int index = partition(nums, start, end);
		while (index != k-1) {
			
			if (index<k-1) {
				index = partition(nums, index+1, end);
			}
			
			if (index>k-1) {
				index = partition(nums, start, index-1);
			}
		}
		
		return Arrays.copyOf(nums, k);
	}
	
	public static int partition (int[] nums, int start, int end) {
		
		if (nums == null || nums.length==0) {
			return 0;
		}
		
		int pivotKey = start;
		int pivotValue = nums[start];
		
		while (start<end) {
			while(start<end && nums[end]>=pivotValue) {
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
	
	private static void swap(int[] nums, int from, int to) {
		int tmp = nums[from];
		nums[from] = nums[to];
		nums[to] = tmp;
	}
	

}
