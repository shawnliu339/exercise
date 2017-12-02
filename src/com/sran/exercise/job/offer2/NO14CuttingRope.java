package com.sran.exercise.job.offer2;

public class NO14CuttingRope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NO14CuttingRope o = new NO14CuttingRope();
		System.out.println(o.maxProductAfterCutting(8));
	}
	
	public int maxProductAfterCutting(int length) {
	    if (length < 2) {
	        return 0;
	    }

	    if (length == 2) {
	        return 1;
	    }
	    
	    if (length == 3) {
	        return 2;
	    }

	    int[] product = new int[length+1];
	    product[1] = 1;
	    product[2] = 2;
	    product[3] = 3;

	    for (int i=4; i<=length; i++) {
	        int max = 0;
	        for (int j=1; j<i; j++) {
	            product[i] = product[j] * product[i-j];
	            if (max<product[i]) {
	                max = product[i];
	            }
	        }
	        product[i] = max;
	    }

	    return product[length];
	}

}
