package com.sran.exercise.sort;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * 
 * @Description:
 *               <p>
 *               简单选择排序算法的实现
 *               </p>
 *
 * @author 王旭
 * @time 2016-3-3 下午9:13:35
 * 
 */

class SelectSort1 {

	public static void selectSort(int[] arr) {

		if (arr == null || arr.length == 0)

			return;

		int minIndex = 0;

		for (int i = 0; i < arr.length - 1; i++) { // 只需要比较n-1次

			minIndex = i;

			for (int j = i + 1; j < arr.length; j++) { // 从i+1开始比较，因为minIndex默认为i了，i就没必要比了。

				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			if (minIndex != i) { // 如果minIndex不为i，说明找到了更小的值，交换之。

				swap(arr, i, minIndex);
			}
		}

	}

	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}