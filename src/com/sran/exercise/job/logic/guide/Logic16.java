package com.sran.exercise.job.logic.guide;

public class Logic16 {

	public static void main(String[] args) {

		String str = args[0];
		Character c = null;
		StringBuffer result = new StringBuffer();
		for (int i=0; i<str.length(); i++) {
			
			if (i % 2 == 0) {
				
				c = str.charAt(i);
			} else {
				
				int count = Character.getNumericValue(str.charAt(i));
				for (int j=0; j<count; j++) {
					result.append(c.toString());
				}
				
			}
		}
		System.out.println(result.toString());
	}

}
