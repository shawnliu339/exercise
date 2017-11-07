package com.sran.exercise.job.offer;

public class No42LeftRotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(leftRotateString("abcdefg",20));
	}
	
	public static String leftRotateString(String str,int n) {
        if (str==null || str.length()<=0) {
        	return "";
        }
        
        if (n<0 || n>str.length()) {
        	return str;
        }
        
        char[] data = str.toCharArray();
        reverse(data, 0, data.length-1);
        reverse(data, data.length-n, data.length-1);
        reverse(data, 0, data.length-n-1);
        
        return String.valueOf(data);
    }
	
	private static void reverse(char[] chars, int start, int end) {
		if (chars==null || chars.length<=0) {
			return;
		}
		
		while (start<end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}

}
