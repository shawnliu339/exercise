package com.sran.exercise.job.offer;

import java.util.Arrays;

public class No43DicesProbability {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		printProbabilityByLoop(3);
		System.out.println();
		printProbability(3);
	}
	
	private static int maxPointOfDices = 6;
	
	//动态规划题，与其找状态变化方程，不如找状态变化的规律
	public static void printProbabilityByLoop (int numberOfDices) {
		if (numberOfDices<=0) {
			return;
		}
		
		int[] previousTimes = new int[maxPointOfDices*numberOfDices+1];
		int[] currentTimes = new int[maxPointOfDices*numberOfDices+1];
		
		for (int i=1; i<=maxPointOfDices; i++) {
			previousTimes[i] = 1;
		}
		
		for(int i=2; i<=numberOfDices; i++) {
			for (int j=1; j<=i*maxPointOfDices; j++) {
				//与当前骰子数相同的前n项为0
				for (int k=0; k<i; k++) {
					currentTimes[k] = 0;
				}
				
				//currentTimes[j]=previousTimes[j-1]+(previousTimes[j-2]...+previousTimes[0])
				//括号中的部分等于currentTimes[j-1]
				currentTimes[j] = currentTimes[j-1] + previousTimes[j-1];
				
			}
			
			//交换
			int temp[] = previousTimes;
			previousTimes = currentTimes;
			currentTimes = temp;
		}
		double total = Math.pow(maxPointOfDices, numberOfDices);
		for (int i=numberOfDices; i<numberOfDices*maxPointOfDices; i++) {
			double ratio = previousTimes[i] / total;
			System.out.print(ratio + ",");
		}
	}
	
	public static void printProbability (int numberOfDices) {
		if (numberOfDices<=0) {
			return;
		}
		
		int[] appearedTimes = new int[(maxPointOfDices-1)*numberOfDices + 1];
		probability(numberOfDices, appearedTimes);
		
		double total = Math.pow(maxPointOfDices, numberOfDices);
		for (int times: appearedTimes) {
			double ratio = times / total;
			
			System.out.print(ratio + ",");
		}
	}
	
	public static void probability (int amountOfDices, int[] appearedTimes) {
		for (int i=1; i<=maxPointOfDices; i++) {
			probability(amountOfDices, amountOfDices, i, appearedTimes);
		}
	}
	
	public static void probability (int amountOfDices, int remainedDices, int sum, int[] appearedTimes) {
		//如果是最后一枚骰子，则把点数和的对应的数组中次数加1
		if (remainedDices == 1) {
			appearedTimes[sum-amountOfDices]++;
		} else {
			//计算下一个骰子投掷的点数的和
			for (int i=1; i<=maxPointOfDices; i++) {
				probability(amountOfDices, remainedDices-1, sum+i, appearedTimes);
			}
		}
	}
}
