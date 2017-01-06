package com.sran.exercise.job.logic.guide;

public class Logic7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer strb = new StringBuffer(args[0]);
		for (int i=2; i<strb.length(); i+=3) {
			strb.insert(i, '-');
		}
		System.out.println(strb.toString());
	}

}
