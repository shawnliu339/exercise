package com.sran.exercise.job.offer;

import java.util.HashMap;

public class No35FirstNotRepeatingChar {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abbaccddeeff";
		System.out.println(findFirstRepeatingCharByHashMap(str));
	}
	
	public static char findFirstRepeatingChar(String str) {
		
		if (str==null || str.length()<=0) {
			return '\0';
		}
		
		char[] chars = str.toCharArray();
		int[] hashTable = new int[256];
		
		for (int i=0; i<chars.length; i++) {
			int index = (int) chars[i];
			hashTable[index]++;
		}
		
		char result = 0;
		for (int i=0; i<chars.length; i++) {
			int index = (int) chars[i];
			if (hashTable[index]==1) {
				result = (char) index;
				break;
			}
		}
		
		return result;
	}
	
	public static char findFirstRepeatingCharByHashMap(String str) {
		
		if (str==null || str.length()<=0) {
			return '\0';
		}
		
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		
		for (int i=0; i<str.length(); i++) {
			char character = str.charAt(i);
			if (hashMap.containsKey(character)) {
				int count = hashMap.get(character);
				hashMap.put(character, ++count);
			} else {
				hashMap.put(character, 1);
			}
		}
		
		char result = 0;
		for (int i=0; i<str.length(); i++) {
			int count = hashMap.get(str.charAt(i));
			if (count==1) {
				result = str.charAt(i);
				break;
				
			}
		}
		
		return result;
	}

}
