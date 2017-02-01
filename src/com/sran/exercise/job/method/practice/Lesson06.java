package com.sran.exercise.job.method.practice;

import java.util.Arrays;

public class Lesson06 {
	
    public static void main(String[] args) {
        // 整数の受け取り
        int num = calcInt(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        // 整数を表示
        System.out.println("" + num);
    }

	private static int calcInt(int num1, int num2, int num3) {
		
		int[] nums = new int[3];
		nums[0] = num1;
		nums[1] = num2;
		nums[2] = num3;
		
		Arrays.sort(nums);
		
		if (nums[0] <= 0) {
			return 0;
		}
		
		int num=nums[2];
		for (int i=nums[2]; i<=num1*num2*num3; i++) {
			
			if (i%num1==0 && i%num2==0 && i%num3==0) {
				num = i;
				break;
			}
		}
		return num;
	}

    // ここにメソッドを記述してください

}
