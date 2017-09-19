package com.sran.exercise.job.offer;

public class No10NumberOf1InBinary {

	public static void main(String[] args) {
		System.out.println(numberOf1(-22));
		System.out.println(numberOf1_2(-22));
		System.out.println(numberOf1_3(-22));
	}

	public static int numberOf1(int num) {

		int count = 0;
		if (num==-1) {
			return 32;
		}
		while (num != 0 && num != -1) {
			if ((num & 1) == 1) {
				count++;
			}
			
			num = num>>1;
		}
		return count;

	}
	
	/**
	 * 常规解法
	 * @param num
	 * @return
	 */
	public static int numberOf1_2(int num) {
		int count = 0;
		int flag = 1;
		while(flag!=0) {
			if ((num & flag) !=0) {
				count++;
			}
			
			flag = flag << 1;
		}
		
		return count;
	}
	
	/**
	 * 巧妙解法
	 * @param n
	 * @return
	 */
	public static int numberOf1_3(int n) {
		int count=0;  
        while(n!=0) {  
            count++;  
            n=(n-1) & n;  
        }  
        return count;
	}

}
