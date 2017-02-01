package com.sran.exercise.job.method.practice;

import java.util.LinkedHashSet;
import java.util.Set;

public class Lesson10 {
    public static void main(String[] args) {
        // String型配列の受け取り
        String[] strs = createStringArray(args[0].split(","));
        // String型配列を表示
        for (int i = 0; i < strs.length; i++) System.out.println(strs[i]);
    }

    //字符串数组去重
	private static String[] createStringArray(String[] strs) {
		
		Set<String> strSet = new LinkedHashSet<String>();
		for (int i=0; i<strs.length; i++) {
			strSet.add(strs[i]);
		}
		
		return  strSet.toArray(new String[strSet.size()]);
	}

    // ここにメソッドを記述してください
}
