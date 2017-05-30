package com.sran.exercise.job.others;

import java.util.regex.Pattern;

public class Others02 {

	public static void main(String[] args) {

		
		System.out.println(Character.isDigit(new Integer("123:")));

	}
	
	public static String calStr(String str) {
		if(str.equals(""))
			return "invalid input";
		String[] neededCals = str.split(" ");
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		if(!pattern.matcher(neededCals[neededCals.length-1]).matches())
			return "invalid input";
		Integer divisor = new Integer(neededCals[neededCals.length-1]);
		StringBuffer result = new StringBuffer();
		for (int i=0; i<neededCals.length-1; i++) {
			String[] neededCal = neededCals[i].split(":");
			if (!pattern.matcher(neededCal[0]).matches())
				return "invalid input";
			else if (divisor % new Integer(neededCal[0]) == 0)
				result.append(neededCal[1]);
		}
		if(result.length()==0)
			return divisor.toString();
		else	
			return result.toString();
		
	}

}
