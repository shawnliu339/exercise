package com.sran.exercise.job.method.practice;

public class Lesson01 {
    public static void main(String[] args) {
        // 文字列の受け取り
        String str = cutString(args[0]);
        // 文字列を表示
        System.out.println(str);
    }

	private static String cutString(String str) {
		
		if (str.length() >4) {
			
			str = str.substring(0, 3);
			str += "...";
		}
		
		return str;
	}

    // ここにメソッドを記述してください
}