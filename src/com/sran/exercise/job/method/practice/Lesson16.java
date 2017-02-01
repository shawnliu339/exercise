package com.sran.exercise.job.method.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lesson16 {
    public static void main(String[] args) {
        // 整数の受け取り
        int num = calcInt(createIntArray(args[0]));
        // 整数を表示
        System.out.println("" + num);
    }

    private static int calcInt(int[] ints) {
    	List<Integer> list = new ArrayList<Integer>();
    	for (int i=0; i<ints.length; i++) 
    		list.add(ints[i]);
		int max = Collections.max(list);
		int min = Collections.min(list);
		return max-min;
	}

	// カンマ付き文字列をint型配列に変換するメソッド
    public static int[] createIntArray(String str) {
        String[] strs = str.split(",");
        int[] ints = new int[strs.length];
        for (int i = 0; i < strs.length; i++) ints[i] = Integer.parseInt(strs[i]);
        return ints;
    }

    // ここにメソッドを記述してください
}
