package com.sran.exercise.bjsxt;

public class ArrayEx1 {
	
	public static void main(String[] args) {
		
		try {
			Integer[] array = new Integer[args.length];
			for(int i=0; i<args.length; i++) {
				array[i] = Integer.parseInt(args[i]);
			}
			
			selectSort(array);
			
			for(int i=0; i<array.length; i++) {
				
				System.out.println(array[i]);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("您输入的参数不是数字！");
		}
	}
	
	/**
	 * 冒泡排序
	 * @param array
	 */
	static void bubbleSort(Integer[] array) {
		for(int i=0; i<array.length-1; i++) {
			for(int j=0; j<array.length-i-1; j++)
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
		}
	}
	
	
	
	/**
	 * 选择排序
	 * @param array
	 */
	static void selectSort(Integer[] array) {
		int k, temp;
		for(int i=0; i<array.length-1; i++) {
			k=i;
			for(int j=k+1; j<array.length; j++) {
				
				if(array[k]>array[j]) {
					k = j;
				}
			}
			if(k!=i) {
				temp = array[k];
				array[k] = array[i];
				array[i] = temp;
			}
			
		}
	}

}
