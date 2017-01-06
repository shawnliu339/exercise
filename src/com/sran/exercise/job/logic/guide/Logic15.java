package com.sran.exercise.job.logic.guide;

public class Logic15 {
	
	public static void main (String args[]) {
		
		String str = args[0];
		String str1 = str.substring(0, 3);
		String str2 = str.substring(3);
		str2 += str1;
		System.out.println(str2);
		
		while (str.equals(str2) != true) {
			
			str1 = str2.substring(0, 3);
			str2 = str2.substring(3);
			str2 += str1;
			System.out.println(str2);
		}
		
		
	}

}
