package com.sran.exercise.job.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NNo33SortArrayForMinNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		String p = findSmallestByPermutation(nums);
		System.out.println(p);
	}
	
	public static String findSmallestByPermutation(int[] nums) {
		List<String> list = new ArrayList<String>();
		permutation(nums, 0, list);
		String[] results = list.toArray(new String[list.size()]);
		Arrays.sort(results);
		//System.out.println(Arrays.toString(results));
		return results[0];
	}
	
	public static void permutation(int[] nums, int start, List<String> results) {
		if (nums.length<=0 || nums==null || start<0) {
			return;
		}
		
		if (start==nums.length) {
			String result = intArrayToString(nums);
			results.add(result);
		}
		
		for (int i=start; i<nums.length; i++) {
			if (isSwap(nums, start, i)) {
				swap(nums, start, i);
				
				permutation(nums, start+1, results);
				
				swap(nums, start, i);
			}
		}
	}
	
	public static boolean isSwap(int[] nums, int start, int end) {
		for(int i=start; i<end; i++) {
			if (nums[end]==nums[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void swap(int[] nums, int from, int to) {
		int tmp = nums[from];
		nums[from] = nums[to];
		nums[to] = tmp;
	}
	
	public static String intArrayToString(int[] nums) {
		StringBuffer strBuf = new StringBuffer();
		for (int i=0; i<nums.length; i++) {
			strBuf.append(nums[i]);
		}
		return strBuf.toString();
	}

}
