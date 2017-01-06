package com.sran.exercise.job.method.guide;

import java.util.Arrays;

public class Lesson02 {
    public static void main(String[] args) {
        // 整数の受け取り
        int num = getInt(args[0], args[1], args[2]);
        // 整数を表示
        System.out.println("" + num);
    }

	private static int getInt(String num1, String num2, String num3) {
		
		int[] len = new int[3];
		len[0] = num1.length();
		len[1] = num2.length();
		len[2] = num3.length();
		
		Arrays.sort(len);
		
		return len[2];
	}

    // ここにメソッドを記述してください
}
