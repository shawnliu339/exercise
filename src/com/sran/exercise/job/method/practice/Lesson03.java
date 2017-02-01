package com.sran.exercise.job.method.practice;

public class Lesson03 {
	public static void main(String[] args) {
		// 文字列の受け取り
		String str = cutString(args[0], Integer.parseInt(args[1]));
		// 文字列を表示
		System.out.println(str);
	}

	private static String cutString(String str, int len) {
		
		int strLen = str.length();
		if (len < strLen && len>0) {
			str = str.substring(0, len);
		}
		if (len > strLen) {
			for (int i=0; i<len-strLen; i++) {
				
				str = "-" + str;
			}
		}
		
		
		return str;
	}

	// ここにメソッドを記述してください
}
