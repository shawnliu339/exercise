package com.sran.exercise.sort;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * 
 * @Description:
 *               <p>
 *               简单插入排序算法实现
 *               </p>
 *
 * @author 王旭
 * @time 2016-3-3 下午9:38:55
 * 
 */

class InsertSort1 {

	public static void insertSort(int[] arr) {

		if (arr == null || arr.length == 0)

			return;

		for (int i = 1; i < arr.length; i++) { // 假设第一个数位置时正确的；要往后移，必须要假设第一个。

			int j = i;

			int target = arr[i]; // 待插入的

			// 后移

			while (j > 0 && target < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}

			// 插入

			arr[j] = target;
		}

	}

}