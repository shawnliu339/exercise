package com.sran.exercise.search;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int binarySearch(int[] array, int value) throws Exception {
		if (array == null)
			throw new Exception("array is null");

		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (value < array[mid])
				right = mid - 1;
			else if (value > array[mid])
				left = mid + 1;
			else
				return mid;

		}

		return -1;
	}

}
