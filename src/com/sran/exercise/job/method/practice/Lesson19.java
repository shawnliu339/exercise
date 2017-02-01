package com.sran.exercise.job.method.practice;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lesson19 {
	public static void main(String[] args) {
		// 整数の受け取り
		int num = calcInt(createIntArray(args[0]));
		// 整数を表示
		System.out.println("" + num);
	}

	// カンマ付き文字列をint型配列に変換するメソッド
	public static Integer[] createIntArray(String str) {
		String[] strs = str.split(",");
		Integer[] ints = new Integer[strs.length];
		for (int i = 0; i < strs.length; i++)
			ints[i] = Integer.parseInt(strs[i]);
		return ints;
	}

	// ここにメソッドを記述してください
	private static int calcInt(Integer[] ints) {

		if(ints.length < 3)
			return 0;
		
		List<Integer> list = new LinkedList<Integer>();
		int sum = 0;
		for (int i = 0; i < ints.length-2; i++) {
			for (int j = i+1; j < ints.length-1; j++) {
				for (int k = j+1; k < ints.length; k++) {

					sum = ints[i] * ints[j] * ints[k];
					list.add(sum);
				}
			}
		}
		Collections.sort(list);

		return list.get(list.size() - 1);
	}
}
