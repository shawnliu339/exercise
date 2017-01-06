package com.sran.exercise.leetcode.array.easy;

import java.util.Arrays;

public class MergeSortedArray88 {
	
	static public void main(String[] args) {
		
		int[] nums1 = new int[2];
		int[] nums2 = {1};
		
		nums1[0] = 2;
		merge(nums1,1,nums2,1);
		System.out.println(nums1[0] + " " + nums1[1]);
	}
	
	static public void merge(int[] nums1, int m, int[] nums2, int n) {

		

		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
		
        /*for (int i=nums1.length; i>0; i--) {
            for (int j=0; j<i-1; j++) {
                if (nums1[j] > nums1[j+1]) {
                    int temp = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1] = temp;
                }
            }
        }*/
	}
}
