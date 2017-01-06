package com.sran.exercise.job.logic.guide;

import java.util.Arrays;

public class Logic12 {

	static public void main(String args[]) {
		int[] num = new int[3];
		int[] abs = new int[3];
		for (int i=0; i<args.length; i++) {
			num[i] = Integer.parseInt(args[i]);
			abs[i] = Math.abs(10 - num[i]);
		}
		
		int min = abs[0];
		for (int i=0; i<abs.length; i++) {
			if (min > abs[i]) {
				min = abs[i];
			}
		}
		
		for (int i=0; i<abs.length; i++) {
			if(min == abs[i]) {
				System.out.println(num[i]);
			}
		}
		
		
	}
}
