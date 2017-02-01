package com.sran.exercise.job.method.practice;

import java.util.Arrays;

public class Lesson15 {
    public static void main(String[] args) {
        // int型配列の受け取り
        int[] ints = cutIntArray(createIntArray(args[0]), Integer.parseInt(args[1]));
        // int型配列を表示
        for (int i = 0; i < ints.length; i++) System.out.println("" + ints[i]);
    }

    private static int[] cutIntArray(int[] ints, int len) {
    	
    	if(len <= 0)
    		len = ints.length;
    	int[] newInts = Arrays.copyOf(ints, len);
    	
		return newInts;
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
