package com.sran.exercise.job.method.practice;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Lesson11 {
	public static void main(String[] args) {
		// 整数の受け取り
		int num = countString(args[0].split(","), args[1].split(","), args[2].split(","));
		// 整数を表示
		System.out.println("" + num);
	}

	private static int countString(String[] strs1, String[] strs2, String[] strs3) {
		
		strs1 = createStringArray(strs1);
		strs2 = createStringArray(strs2);
		strs3 = createStringArray(strs3);
		Arrays.sort(strs1);
		Arrays.sort(strs2);
		Arrays.sort(strs3);
		
		int count = 0;
		for (int i=0; i<strs1.length; i++) {
			if (Arrays.binarySearch(strs2, strs1[i]) >= 0
					&& Arrays.binarySearch(strs3, strs1[i]) >= 0) {
				count++;
			}
			
		}
			
		return count;
	}
	
	private static String[] createStringArray(String[] strs) {
		
		Set<String> strSet = new LinkedHashSet<String>();
		for (int i=0; i<strs.length; i++) {
			strSet.add(strs[i]);
		}
		
		return  strSet.toArray(new String[strSet.size()]);
	}

	// ここにメソッドを記述してください
}
