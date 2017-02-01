package com.sran.exercise.job.method.practice;

public class Lesson05 {
    public static void main(String[] args) {
        // 整数の受け取り
        int num = calcInt(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        // 整数を表示
        System.out.println("" + num);
    }

	private static int calcInt(int m, int n) {
		
		int count = 0;
		
		if(n == 0) {
			return 0;
		}
		
		for (int i=1; i<=m; i++) {
			if (m%i == n%i) {
				count++;
			}
		}
		return count;
	}

    // ここにメソッドを記述してください
}
