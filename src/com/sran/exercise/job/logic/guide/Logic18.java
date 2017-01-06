package com.sran.exercise.job.logic.guide;

import java.util.LinkedHashSet;
import java.util.Set;

public class Logic18 {
	
	public static void main (String args[]) {
		
		String str = args[0];
		Set<Character> set = new LinkedHashSet<Character>();
		for(int i=0; i<str.length(); i++) {
			
			set.add((char)str.charAt(i));
		}
		
		for(Character c : set) {
			System.out.print(c.toString());
		}
	}

}
