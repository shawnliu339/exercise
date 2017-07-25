package com.sran.exercise.sort;

public class QuickSort {

	public static void main(String args[]) {
		int[] array = { 5, 3, 8, 6, 4 };
		QuickSort1 qs = new QuickSort1();
		qs.sort(array);

	}

}

/**
 * 
 * @Description:
 *               <p>
 *               实现快速排序算法
 *               </p>
 *
 * @author 王旭
 * @time 2016-3-3 下午5:07:29
 * 
 */

class QuickSort1 {
	// 一次划分

	public static int partition(int[] arr, int left, int right) {

		int pivotKey = arr[left];

		int pivotPointer = left;

		while (left < right) {

			while (left < right && arr[right] >= pivotKey)
				right--;

			while (left < right && arr[left] <= pivotKey)
				left++;
			swap(arr, left, right);
			// 把大的交换到右边，把小的交换到左边。

		}
		swap(arr, pivotPointer, left);
		// 最后把pivot交换到中间

		return left;
	}

	public static void quickSort(int[] arr, int left, int right) {

		if (left >= right)

			return;

		int pivotPos = partition(arr, left, right);
		quickSort(arr, left, pivotPos - 1);
		quickSort(arr, pivotPos + 1, right);
	}

	public static void sort(int[] arr) {

		if (arr == null || arr.length == 0)

			return;
		quickSort(arr, 0, arr.length - 1);
	}

	public static void swap(int[] arr, int left, int right) {

		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}

/**
 * 
 * @Description:
 *               <p>
 *               实现快速排序算法
 *               </p>
 *
 * @author 王旭
 * @time 2016-3-3 下午5:07:29
 * 
 */

class QuickSort2 {

	/**
	 * 
	 * 划分
	 * 
	 * @param arr
	 * 
	 * @param left
	 * 
	 * @param right
	 * 
	 * @return
	 * 
	 */

	public static int partition(int[] arr, int left, int right) {

		int pivotKey = arr[left];

		while (left < right) {

			while (left < right && arr[right] >= pivotKey)
				right--;
			arr[left] = arr[right]; // 把小的移动到左边

			while (left < right && arr[left] <= pivotKey)
				left++;
			arr[right] = arr[left]; // 把大的移动到右边

		}
		arr[left] = pivotKey; // 最后把pivot赋值到中间

		return left;
	}

	/**
	 * 
	 * 递归划分子序列
	 * 
	 * @param arr
	 * 
	 * @param left
	 * 
	 * @param right
	 * 
	 */

	public static void quickSort(int[] arr, int left, int right) {

		if (left >= right)

			return;

		int pivotPos = partition(arr, left, right);
		quickSort(arr, left, pivotPos - 1);
		quickSort(arr, pivotPos + 1, right);
	}

	public static void sort(int[] arr) {

		if (arr == null || arr.length == 0)

			return;
		quickSort(arr, 0, arr.length - 1);
	}

}
