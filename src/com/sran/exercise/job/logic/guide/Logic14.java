package com.sran.exercise.job.logic.guide;

public class Logic14 {

	public static void main(String args[]) {
		
		String str = args[0];
		int num = Integer.parseInt(args[1]);
		
		for (int i=0; i<num; i++) {
			
			str += str;
		}
		
		System.out.println(str.substring(0, num));
	}
}
