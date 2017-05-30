package com.sran.exercise.job.others;

public class Rot13 {

	public static void main(String[] args) {
		
		System.out.println(rot13("anmzANMZ"));

	}
	
	public static String rot13(String str) {
		if (str.equals(""))
			return "";
		StringBuffer result = new StringBuffer();
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i)>='a'&&str.charAt(i)<='m' || 
					str.charAt(i)>='A'&&str.charAt(i)<='M')
				result.append((char) (str.charAt(i)+13));
			else if (str.charAt(i)>='n'&&str.charAt(i)<='z' || 
					str.charAt(i)>='N'&&str.charAt(i)<='Z')
				result.append((char) (str.charAt(i)-13));
			else
				result.append(str.charAt(i));
		}
		return result.toString();
	}

}
