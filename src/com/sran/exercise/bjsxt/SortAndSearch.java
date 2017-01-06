package com.sran.exercise.bjsxt;

public class SortAndSearch {

	public static void main(String[] args) {
		
		Integer[] array = {8,3,11,7,1,4,18,2,5,10,9,6,20};
		//bubbleSort(array);
		selectSort(array);
		print(array);
		//System.out.println(binarySearch(array, 4));
	}
	
	public static void print(Integer[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void bubbleSort(Integer[] array) {
		
		for (int i=array.length; i>0; i--) {
			for (int j=0; j<i-1; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	public static void selectSort(Integer[] array) {
		
		int k, temp;
		for (int i=0; i<array.length-1; i++) {
			k=i;
			for (int j=k+1; j<array.length; j++ ) {
				
				if (array[k] > array[j]) {
					
					k = j;
				}
			}
			
			if (k!=i) {
				temp = array[i];
				array[i] = array[k];
				array[k] = temp;
			}
		}
		
	}
	
	public static Integer binarySearch(Integer[] array, Integer value) {
		
		Integer startPos = 0;
		Integer endPos = array.length-1;
		Integer middle = (startPos + endPos)/2;
		
		while(startPos <= endPos){
			if(array[middle] < value) {
				
				startPos = middle + 1;
			} else if(array[middle] > value) {
				
				endPos = endPos - 1;
			} else {
				
				return middle;
			}
			middle = (startPos + endPos)/2;
		}
		return -1;
		
	}

}
