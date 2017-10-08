package com.sran.exercise.dynamic_programming;

public class CutSteelPipe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = {0,1,5,8,9,10,17,17,20,24,30};
		System.out.println(cutRod(p, 7));
	}
	
	public static int cutRod(int[] priceList, int length) {
		if (length==0) {
			return 0;
		}
		
		int[] maxValue = new int[11];
		int[] s = new int[11];
		for (int i=1; i<=length; i++) {
			int preMax = 0;
			for (int j=1; j<=i; j++) {
				if (preMax<priceList[j]+maxValue[i-j]) {
					preMax=priceList[j]+maxValue[i-j];
					s[i] = j;
				}
			}
			maxValue[i] = preMax;
		}
		int tmp = length;
		while (tmp>0) {
			System.out.print(s[tmp] + " ");
			tmp -= s[tmp];
		}
		return maxValue[length];
	}
	
	public static int max(int q, int currentQ) {
		if (q < currentQ) {
			return currentQ;
		} else {
			return q;
		}
	}

}
