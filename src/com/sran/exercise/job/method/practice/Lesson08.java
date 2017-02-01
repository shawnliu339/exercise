package com.sran.exercise.job.method.practice;

public class Lesson08 {
	public static void main(String[] args) {
		// String型配列の受け取り
		String[] strs = createStringArray(args[0].split(","), Integer.parseInt(args[1]));
		// String型配列を表示
		for (int i = 0; i < strs.length; i++)
			System.out.println(strs[i]);
	}

	private static String[] createStringArray(String[] strs, int num) {

		if (num <= 0)
			return strs;
		for (int i=0; i<strs.length; i++) {
			if (num < strs[i].length())
				strs[i] = strs[i].substring(0, num);
		}
		return strs;
	}

	// ここにメソッドを記述してください
}
