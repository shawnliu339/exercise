package com.sran.exercise.job.logic.practice;

public class Lesson13 {
	
	public static void main (String args[]) {
		
		String str = args[0];
		StringBuffer strb = new StringBuffer("[");
		
		for (int i=0; i<str.length();i++) {
			
			char c = str.charAt(i);
			if (c != ',') {
				
				strb.append(c);
			} else {
				
				strb.append("][");
			}
			
		}
		
		strb.append(']');
		System.out.println(strb.toString());
		
	}

}
