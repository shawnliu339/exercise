package com.sran.exercise.job.offer;

public class No03Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] array = {{1,2,8,9,10},{2,4,9,12,13},{4,7,10,13,14},{6,8,11,15,16}};
		find(array, 20);
	}

	@SuppressWarnings("unused")
	private static boolean find(int[][] array, int num) {
		int i=0;
		int j;
		
			for (j=array[0].length-1; j>=0; j--) {
				
				if (array[i][j]>num) {
					continue;
				} else if (array[i][j]<num) {
					break;
				} else if (array[i][j] == num){
					System.out.println(i + "," + j);
					return true;
				} else {
					System.out.println("no");
					return false;
				}
			}
			for(i=0; i<array.length; i++) {
				if (array[i][j]<num)
					continue;
				else if (array[i][j] > num) {
					System.out.println("no");
					return false;
				}
				else {
					System.out.println(i + "," + j);
					return true;
				}
			}
			System.out.println("no");
			return false;
			
		
		
		
	}

}
