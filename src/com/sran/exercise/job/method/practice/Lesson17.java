package com.sran.exercise.job.method.practice;

import java.util.Arrays;


public class Lesson17 {
    public static void main(String[] args) {
        // 整数の受け取り
        int num = calcInt(createIntArray(args[0]), createIntArray(args[1]));
        // 整数を表示
        System.out.println("" + num);
    }

    private static int calcInt(Integer[] ints1, Integer[] ints2) {
    	Arrays.sort(ints1);
    	Arrays.sort(ints2);
    	int max = ints1[ints1.length-1] - ints2[0];
    	if (max < ints2[ints2.length-1] - ints1[0])
    		max = ints2[ints2.length-1] - ints1[0];
		return max;
	}

	// カンマ付き文字列をint型配列に変換するメソッド
    public static Integer[] createIntArray(String str) {
        String[] strs = str.split(",");
        Integer[] ints = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++) ints[i] = Integer.parseInt(strs[i]);
        return ints;
    }

    // ここにメソッドを記述してください
}