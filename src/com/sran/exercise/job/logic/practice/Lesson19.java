package com.sran.exercise.job.logic.practice;

import java.util.Set;
import java.util.TreeSet;

public class Lesson19 {
	
	public static void main (String args[]) {
		
		String str1 = args[0];
		String str2 = args[1];
		
		Set<Character> set1 = new TreeSet<Character>();
		Set<Character> set2 = new TreeSet<Character>();
		for(int i=0; i<str1.length(); i++) {
			
			set1.add(str1.charAt(i));
		}
		
		for(int i=0; i<str2.length(); i++) {
			
			set2.add(str2.charAt(i));
		}
		
		set1.retainAll(set2);
		System.out.println(set1.size());
	}

}
