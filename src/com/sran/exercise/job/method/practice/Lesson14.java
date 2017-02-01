package com.sran.exercise.job.method.practice;

public class Lesson14 {
    public static void main(String[] args) {
        // 整数の受け取り
        int num = calcInt(createIntArray(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        // 整数を表示
        System.out.println("" + num);
    }

    private static int calcInt(int[] ints, int int1, int int2) {
    	
    	int sum = 0;
    	try {
			for (int i=int1; i<=int2; i++) {
				sum += ints[i];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			sum = 0;
		}
		return sum;
		
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
