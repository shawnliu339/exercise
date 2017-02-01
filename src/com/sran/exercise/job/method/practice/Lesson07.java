package com.sran.exercise.job.method.practice;

public class Lesson07 {
	public static void main(String[] args) {
		// int型配列の受け取り
		int[] ints = createIntArray(args[0].split(","));
		// int型配列を表示
		for (int i = 0; i < ints.length; i++)
			System.out.println("" + ints[i]);
	}

	private static int[] createIntArray(String[] strs) {
		
		int [] ints = new int[strs.length];
		for (int i=0; i<ints.length; i++) {
			
			ints[i] = strs[i].length();
		}
		return ints;
	}

	// ここにメソッドを記述してください
}
