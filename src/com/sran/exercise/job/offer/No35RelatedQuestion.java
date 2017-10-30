package com.sran.exercise.job.offer;

import java.util.HashMap;
import java.util.HashSet;

public class No35RelatedQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(deleteDuplicateCharByHashMap("google"));
	}
	
public static String deleteDuplicateCharByHashMap(String str) {
		
		if (str==null || str.length()<=0) {
			return null;
		}
		
		StringBuffer buffer = new StringBuffer(str);
		HashSet<Character> hashSet = new HashSet<Character>();
		for (int i=0; i<buffer.length(); i++) {
			
			if (hashSet.contains(buffer.charAt(i))) {
				buffer.deleteCharAt(i);
				i--;
			} else {
				hashSet.add(buffer.charAt(i));
			}
			
		}
		
		return buffer.toString();
	}
	
	public static String deleteDuplicateChar(String str) {
		
		if (str==null || str.length()<=0) {
			return null;
		}
		
		StringBuffer buffer = new StringBuffer(str);
		boolean[] countOfChar = new boolean[256];
		for (int i=0; i<buffer.length(); i++) {
			
			int index = (int) buffer.charAt(i);
			if (countOfChar[index] == false) {
				countOfChar[index]=true;
			} else {
				buffer.deleteCharAt(i);
				i--;
			}
			
		}
		
		return buffer.toString();
	}

}
