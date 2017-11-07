package com.sran.exercise.job.offer;

import java.util.Arrays;

public class No40NumbersAppearOnce {

	public static void main(String[] args) {
		int[] nums = {1,1,2,2,3,3,4,4};
		System.out.println(Arrays.toString(findNumberAppearingOnce(nums)));
	}
	
	public static int findFirstBitIs1(int num) {
		int index = 0;
		while ((num&1)==0 &&
				index<Integer.SIZE) {
			num = num >> 1;
			index++;
		}
		
		return index;
	}
	
	public static boolean isBit1 (int num, int indexBit) {
		num = num >> indexBit;
		return (num&1)==1?true:false;
	}
	
	public static int[] findNumberAppearingOnce(int[] array) {
		if (array==null || array.length<2) {
			return null;
		}
		
		int[] numsApperingOnce = new int[2];
		int exclusiveOr = 0;
		for (int num : array) {
			exclusiveOr ^= num;
		}
		if (exclusiveOr==0) {
			return null;
		}
		
		int indexBit = findFirstBitIs1(exclusiveOr);
		for (int num : array) {
			if (isBit1(num, indexBit)) {
				numsApperingOnce[0] ^= num;
			} else {
				numsApperingOnce[1] ^= num;
			}
		}
		
		return numsApperingOnce;
	}

}
