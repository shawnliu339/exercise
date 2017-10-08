package com.sran.exercise.dynamic_programming;

import java.util.Arrays;

public class Backpack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weightList = {2,2,6,5,4};
		int[] valueList = {6,3,5,4,6};
		int volume = 30;
		
		System.out.println(getMaxValue(volume, weightList, valueList));
	}
	
	public static int getMaxValue(int volume, int[] weightList, int[] valueList) {
		
		if (volume<=0 || weightList==null || valueList==null || 
				weightList.length != valueList.length || weightList.length==0) {
			return 0;
		}
		
		int[] solutions = new int[volume+1];
		int[] preSolutions = new int[volume+1];
		int itemNums = weightList.length;
		
		for (int itemNum=itemNums-1; itemNum>=0; itemNum--) {
			for (int currentVolume=1; currentVolume<=volume; currentVolume++) {
				int itemWeight = weightList[itemNum];
				if(currentVolume<itemWeight) {
					continue;
				}
				
				int currentValue = valueList[itemNum] + preSolutions[currentVolume-itemWeight];
				if (currentValue>preSolutions[currentVolume]) {
					solutions[currentVolume] = currentValue;
				}
			}
			
			preSolutions = solutions;
			solutions = Arrays.copyOf(solutions, solutions.length);
		}
		
		return solutions[volume];
	}

}
