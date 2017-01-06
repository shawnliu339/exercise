package com.sran.exercise.job.logic.guide;

public class Logic11 {

	public static void main(String args[]) {
		
		int[] num = new int[3];
		for (int i=0; i<args.length; i++) {
			num[i] = Integer.parseInt(args[i]);
		}
		
		int k, temp;
		for(int i=0; i<num.length-1; i++) {
			
			k = i;
			for (int j=k+1; j<num.length; j++) {
				
				if (num[k] > num[j]) {
					k=j;
				}
			}
			
			if(k!=i) {
				temp = num[i];
				num[i] = num[k];
				num[k] = temp;
			}
			
		}
		
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
		
		
	}
}
