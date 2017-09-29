package com.sran.exercise.job.offer;

import java.util.Stack;

public class No22PushPopOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pushOrder = {1};
		int[] popOrder = null;
		System.out.println(isPopOrder(pushOrder, popOrder));

	}

	public static boolean isPopOrder(int[] pushOrder, int[] popOrder) {
		boolean possible = false;
		
		if (pushOrder == null || popOrder==null || pushOrder.length == 0 || popOrder.length == 0) {
			return possible;
		}

		int nextPushIndex = 0;
		int nextPopIndex = 0;
		Stack<Integer> stack = new Stack<Integer>();

		while (nextPopIndex < popOrder.length) {

			while (stack.isEmpty() || stack.peek() != popOrder[nextPopIndex]) {
				if (nextPushIndex == pushOrder.length) {
					break;
				}

				stack.push(pushOrder[nextPushIndex]);
				nextPushIndex++;
			}
			
			if (stack.peek() != popOrder[nextPopIndex]) {
				break;
			}

			stack.pop();
			nextPopIndex++;
		}
		
		if (stack.isEmpty() && nextPopIndex == popOrder.length) {
			possible = true;
		}

		return possible;
	}

}
