package com.sran.exercise.job.method.guide;

public class Lesson04 {
    public static void main(String[] args) {
        // 整数の受け取り
        int num = calcInt(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        // 整数を表示
        System.out.println("" + num);
    }

	private static int calcInt(int num1, int num2) {

		int remainder = num1 % num2;
		while (remainder == 0 && num2 > 1) {
			
			num1 = num1 / num2;
			remainder = num1 % num2;
		}
		
		return remainder;
	}

    // ここにメソッドを記述してください
}
