package com.sran.exercise.job.offer;

import java.util.Stack;

public class No22PushPopOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pushOrder = {1};
		int[] popOrder = null;
		System.out.println(isPopOrder(pushOrder, popOrder));

	}

	//由内侧的循环向外侧写。注意循环的边界条件。注意每个循环的入口部分进行特殊值检查。
	//出现的困惑：不知道弹出和压入操作循环，哪个写外侧，哪个写内侧。
	//一定要先进行压入操作才可进行弹出操作，所以，压入循环写在内侧。
	public static boolean isPopOrder(int[] pushA, int[] popA) {
		boolean possible = false;
		
		if (pushA == null || popA==null || pushA.length == 0 || popA.length == 0) {
			return possible;
		}

		int nextPushIndex = 0;
		int nextPopIndex = 0;
		Stack<Integer> stack = new Stack<Integer>();

		while (nextPopIndex < popA.length) {

			while (stack.isEmpty() || stack.peek() != popA[nextPopIndex]) {
				if (nextPushIndex == pushA.length) {
					break;
				}

				stack.push(pushA[nextPushIndex]);
				nextPushIndex++;
			}
			
			if (stack.peek() != popA[nextPopIndex]) {
				break;
			}

			stack.pop();
			nextPopIndex++;
		}
		
		if (stack.isEmpty() && nextPopIndex == popA.length) {
			possible = true;
		}

		return possible;
	}

}