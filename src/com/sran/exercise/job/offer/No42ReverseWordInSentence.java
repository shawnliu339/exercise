package com.sran.exercise.job.offer;

public class No42ReverseWordInSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = reverseSentence("I am a student.");
		System.out.println(test);
	}
	
	public static String reverseSentence(String str) {
		if (str==null || str.length()<=0) {
			return "";
		}
		
		char[] chars = str.toCharArray();
        reverse(chars, 0, str.length()-1);
        int start = 0;
        int end = 0;
        while (start<chars.length) {
        	if (chars[start]==' ') {
        		start++;
        		end++;
        	} else if (end==chars.length || chars[end]==' '){
        		reverse(chars, start, end-1);
        		start = end;
        	} else {
        		end++;
        	}
        }
        
        return String.valueOf(chars);
        
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
