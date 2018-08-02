package com.sran.exercise.job.offer2;

public class NO19RegularExpressionsMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abb";
		String pattern = "ab***";
		NO19RegularExpressionsMatching o = new NO19RegularExpressionsMatching();
		System.out.println(o.match(str.toCharArray(), pattern.toCharArray()));
	}

	public boolean match(char[] strChar, char[] patternChar) {
		// check
		if (strChar == null || patternChar == null || strChar.length == 0 && patternChar.length == 0) {
			return false;
		}

		int strIndex = 0;
		int patternIndex = 0;
		while (strIndex < strChar.length && patternIndex < patternChar.length) {

			// 首先做字符匹配和.匹配。然后，做*匹配
			if (strChar[strIndex] == patternChar[patternIndex] || patternChar[patternIndex] == '.') {
				strIndex++;
				patternIndex++;
			} else if (patternChar[patternIndex + 1] == '*') {
				patternIndex++;
			} else {
				return false;
			}

			// 匹配*
			if (patternIndex < patternChar.length && patternChar[patternIndex] == '*') {
				char prev = patternChar[patternIndex - 1];
				if (strIndex < strChar.length && (prev == strChar[strIndex] || prev=='.')) {
					while (strIndex < strChar.length && (prev == strChar[strIndex] || prev=='.')) {
						strIndex++;
					}
					patternIndex++;
				} else {
					patternIndex++;
				}
			}
		}

		while (patternIndex < patternChar.length) {
			if (patternIndex + 1 < patternChar.length && patternChar[patternIndex + 1] == '*') {
				patternIndex += 2;
			} else {
				return false;
			}
		}

		if (strIndex == strChar.length && patternIndex == patternChar.length) {
			return true;
		} else {
			return false;
		}
	}

}
