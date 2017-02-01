package com.sran.exercise.job.method.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Lesson12 {
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
		
		List<String[]> strList = orderArraysByLength(strs1, strs2, strs3);
		strs1 = strList.get(0);
		strs2 = strList.get(1);
		strs3 = strList.get(2);
		
		int count = 0;
		for (int i=0; i<strs1.length; i++) {
			if ((Arrays.binarySearch(strs2, strs1[i]) >= 0 
					&& Arrays.binarySearch(strs3, strs1[i]) < 0) 
					|| (Arrays.binarySearch(strs2, strs1[i]) < 0 
							&& Arrays.binarySearch(strs3, strs1[i]) >= 0)) {
				count++;
			}
		}
		
		List<String> arrayList= new ArrayList<String>(Arrays.asList(strs2));
		arrayList.removeAll(Arrays.asList(strs1));
		for (String str : arrayList) {
			if (Arrays.binarySearch(strs3, str) >=0)
				count++;
		}
			
		return count;
	}
	
	private static List<String[]> orderArraysByLength(String[] strs1, String[] strs2, String[] strs3) {
		
		
		List<String[]> strList = new LinkedList<String[]>();
		strList.add(strs1);
		strList.add(strs2);
		strList.add(strs3);
		Collections.sort(strList, new Comparator<String[]>() {
			public int compare (String[] strs1, String[] strs2) {
				if (strs1.length > strs2.length)
					return 1;
				else if (strs1.length < strs2.length)
					return -1;
				else
					return 0;
			}
		});
		
		return strList;
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
