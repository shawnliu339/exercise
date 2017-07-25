package com.sran.exercise.job.offer;

public class No08MinNumberInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 0, 1, 1, 1 };

		System.out.println(min(array));

	}

	public static int min(int[] array) {

		if (array == null)
			throw new NullPointerException("Array is empty!");

		int left = 0;
		int right = array.length - 1;
		int mid = left;

		while (array[left] >= array[right]) {
			mid = (left + right) / 2;
			
			//左中右的数值都一样时，无法判断前后序列范围，所以使用顺序查找
			if (array[left] == array[mid] && array[left] == array[right])
				return minInOrder(array, left, right);
			
			if (array[mid] >= array[left])
				left = mid;
			
			if (array[mid] <= array[right])
				right = mid;
			

			if (right - left == 1)
				return array[right];

		}

		return array[mid];
	}

	public static int minInOrder(int[] array, int start, int end) {
		int min = array[start];
		for (int i = start + 1; i <= end - start; i++) {
			if (min > array[i])
				min = array[i];
		}
		return min;
	}

}
