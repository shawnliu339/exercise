package com.sran.exercise.job.offer2;

public class No05ReplaceSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer("we are happy.");
		int cap = str.capacity();
		str.ensureCapacity(50);

		System.out.println(replaceSpace(str));
	}

	public static String replaceSpace(StringBuffer str) {
		if (str == null || str.length() == 0) {
			return null;
		}

		int numberOfSpace = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				numberOfSpace++;
			}
		}

		int behind = str.length() + numberOfSpace * 2 - 1;
		int front = str.length() - 1;
		str.setLength(behind + 1);

		while (front < behind) {
			if (str.charAt(front) == ' ') {
				str.setCharAt(behind--, '0');
				str.setCharAt(behind--, '2');
				str.setCharAt(behind, '%');
			} else {
				str.setCharAt(behind, str.charAt(front));
			}
			front--;
			behind--;
		}

		return str.toString();

	}

}
