package com.sran.exercise.job.logic.guide;

public class Logic13 {
	
	public static void main (String args[]) {
		
		int flag = 0;
		if(args[0].charAt(args[0].length()-1) == ',') {
			flag = 1;
		}
		String results[] = args[0].split(",");
		
		for(int i=0; i<results.length; i++) {
			
			System.out.print("[" + results[i] + "]");
			
		}
		
		if (flag == 1) {
			System.out.println("[]");
		}
		
	}

}
