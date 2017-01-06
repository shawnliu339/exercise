package com.sran.exercise.job.logic.guide;

public class Logic17 {

	public static void main(String args[]) {
		
		String str = args[0];
		StringBuffer strb = new StringBuffer();
		
		for (int i=0; i<str.length(); i++) {
			
			Character c = str.charAt(i);
			strb.append(c);
			
		}
		
	}
}
