package com.sran.exercise.job.logic.practice;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Lesson20 {

	public static void main(String args[]) {
		
		String str = args[0];
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		for (int i=0; i<str.length(); i++) {
			
			Character c = str.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				
				int freq = map.get(c);
				map.put(c, freq+1);
			}
		}

		int max = Collections.max(map.values());
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() == max)
				System.out.print(entry.getKey().toString());
		}
		
	}
}
