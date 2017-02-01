package com.sran.exercise.job.method.practice;

public class Lesson09 {
	public static void main(String[] args) {
		// String型配列の受け取り
		String[] strs = createStringArray(args[0].split(","), args[1].split(","), args[2]);
		// String型配列を表示
		for (int i = 0; i < strs.length; i++)
			System.out.println(strs[i]);
	}

	private static String[] createStringArray(String[] strs1, String[] strs2, String replace) {
		for (int i=0; i<strs1.length; i++) {
			for (int j=0; j<strs2.length; j++) {
				if(strs1[i].contains(strs2[j]))
					strs1[i] = replace;
			}
		}
		return strs1;
	}

	// ここにメソッドを記述してください
}
