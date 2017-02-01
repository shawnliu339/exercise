package com.sran.exercise.job.logic.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lesson17 {

	public static void main(String args[]) {

		String str = args[0];
		StringBuffer result = new StringBuffer();
		
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		Character before = null;
		
		for (int i = 0; i < str.length(); i++) {

			Character c = str.charAt(i);
			if (!map.containsKey(c)) {
				//检查是否有前项
				if (!map.isEmpty()) {
					
					result.append(before).append(map.get(before));
					map.remove(before);
				}
				
				map.put(c, 1);
				before = c;
				
			} else {

				int freq = map.get(c);
				
				if (freq == 9) {
					result.append(c).append(map.get(c));
					map.remove(c);
					freq = 0;
				}
				map.put(c, freq + 1);
			}
			
		}
		
		Character last = str.charAt(str.length()-1);
		result.append(last).append(map.get(last));
		System.out.println(result.toString());
	}
}
