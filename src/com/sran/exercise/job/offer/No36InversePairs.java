package com.sran.exercise.job.offer;

public class No36InversePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(inversePairsCore(new int[] { 7, 5, 6, 4 }));
	}

	public static int inversePairsCore(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}

		int[] dest = nums.clone();
		return inversePairsCore(nums, dest, 0, nums.length - 1);
	}

	public static int inversePairsCore(int[] src, int[] dest, int low, int high) {
		if (low >= high) {
			return 0;
		}

		int mid = (low + high) >>> 1;
		int left = inversePairsCore(dest, src, low, mid);
		int right = inversePairsCore(dest, src, mid + 1, high);

		int count = 0;
		int i = high, p = mid, q = high;
		while (p >= low && q >= mid + 1) {
			if (src[p] > src[q]) {
				count += q - mid;
				dest[i--] = src[p--];
			} else {
				dest[i--] = src[q--];
			}
		}

		for (; p >= low; p--) {
			dest[i--] = src[p];
		}

		for (; q >= mid + 1; q--) {
			dest[i--] = src[q];
		}

		return left + right + count;
	}

}
