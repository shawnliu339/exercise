package com.sran.exercise.job.offer2;

public class No03DuplicationInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,1,3,1,4};
		int[] duplication = {-1};
		duplicate2(arr,arr.length,duplication);
		System.out.println(duplication[0]);
	}
	
	public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null || length<=0) {
        	return false;
    	}

		for (int i=0; i<length; i++) {
            if (numbers[i] == i) {
                continue;
            }

            if (numbers[i] == numbers[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            } else {
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
		}

		return false;

    }
	
	public static boolean duplicate2 (int[] numbers, int length, int[]duplication) {
		if (numbers==null || length==0) {
			return false;
		}

		int start = 1;
		int end = length - 1;
	    int middle = 0;
		int count = 0;

		//注意while的循环条件！！
		//该种循环条件，有等于与没等于的区别就是是否执行相遇后的操作。
		//有等于，相遇后仍要执行一次逻辑。
		//无等于，相遇前一次就停止操作。
		while (start <= end) {
			middle = ((end-start)>>>1) + start;
			count = countRange(numbers, start, middle);

			if (start==end) {
				if (count>1) {
					duplication[0] = start;
					return true;
				}  else {
					return false;
				}
			}

			//count的大小并非从1开始，所以比较时要减掉前半部分，即减掉start-1
	        //-1是因为，在上一轮的循环中只验证了start-1个数
			if (count > middle-start+1) {
				end = middle;
			} else {
				start = middle + 1;
			}
		}

		return false;
	}

	public static int countRange(int[] numbers, int start, int end) {
		if (numbers==null) {
			return 0;
		}

		int count = 0;
		for (int i=0; i<numbers.length; i++) {
			if (numbers[i]>=start && numbers[i]<=end) {
				count++;
			}
		}

		return count;
	}

}
