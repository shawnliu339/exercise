package com.sran.exercise.job.others;

public class IsInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isDouble("1"));

	}
	
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
		
	}
	
	public static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return false;
		}
		if (isInteger(str))
			return false;
		return true;
	}

}
