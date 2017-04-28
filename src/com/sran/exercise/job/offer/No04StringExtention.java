package com.sran.exercise.job.offer;

public class No04StringExtention {
	
	static public void main (String[] args) {
		int[] a1 = new int[2];
		int[] a2 = {1};
		
		a1[0] = 2;
		merge(a2,1,a1,1);
		System.out.println(a1[0] + " " + a1[1]);
	}
	
	static void merge(int[] src,int a2, int[] target, int a1) {
		
		int len = a1 + a2 -1;
		a1 -= 1;
		a2 -= 1;
		
		//只要a2没有全都合并到a1中就一直循环
		while (a2 != -1) {
			if(a1==-1&&a2==0 || src[a2] >= target[a1]) {
				target[len] = src[a2];
				a2--;
				len--;
			} else {
				target[len] = target[a1];
				a1--;
				len--;
			}
			
			
		}
		
	}

}
