package com.sran.exercise.job.offer;

import java.util.ArrayList;

public class No28StringPermutation {

	ArrayList<String> results = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permutation("aaab");
	}

	public static void permutation(String str) {
		if (str == null) {
			return;
		}

		char[] charList = str.toCharArray();
		permutation(charList, 0);
	}

	public static void permutation(char[] charList, int start) {

		if (charList.length <= 0 || charList == null) {
			return;
		}

		if (charList.length == start) {
			System.out.print(String.valueOf(charList) + " ");
			return;
		}

		for (int i = start; i < charList.length; i++) {

			if (isSwap(charList, start, i)) {
				char tmp = charList[start];
				charList[start] = charList[i];
				charList[i] = tmp;

				permutation(charList, start + 1);

				// 需要将交换过的字符换回原位，否则递归回最原始的字符串时，会交换错误。
				// 例如：原始字符串为abc,在以a为最首位的最后一次递归中，字符串被交换成了acb，所以，不再进行一次交换则会出错。
				tmp = charList[start];
				charList[start] = charList[i];
				charList[i] = tmp;
			}
		}
	}

	public static boolean isSwap(char[] charList, int startChar, int currentChar) {
		for (int i = startChar; i < currentChar; i++) {
			if (charList[currentChar] == charList[i]) {
				return false;
			}
		}
		return true;
	}

}
