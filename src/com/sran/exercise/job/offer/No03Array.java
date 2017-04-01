package com.sran.exercise.job.offer;

public class No03Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] array = {{1,2,8,9,10},{2,4,9,12,13},{4,7,10,13,14},{6,8,11,15,16}};
		find(array, 14);
	}

	@SuppressWarnings("unused")
	private static boolean find(int[][] array, int num) {
		int i = 0;
		int j = array[0].length-1;
		/*
		 * 如果该数小于被扫描的数
		 * 则代表该数一定在左侧
		 * 如果该数大于被扫描的数
		 * 则代表该数一定在下侧
		 */
		while(i<array.length && j>=0) {
			
			if (num<array[i][j]) {
				j--;
				continue;
			} else if (num>array[i][j]) {
				i++;
				continue;
			} else if (num==array[i][j]) {
				System.out.println("coordinate is " + "(" + (i+1) + "," + (j+1) + ")");
				return true;
			}
			
		}
		
		System.out.println("not fonud!");
		return false;
		
	}

}
