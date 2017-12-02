package com.sran.exercise.job.offer2;

public class NO13RobotMove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NO13RobotMove o = new NO13RobotMove();
		System.out.println(o.movingCount(5,10,10));
	}

	public int movingCount(int threshold, int rows, int cols) {
		// check();

		boolean[] visited = new boolean[rows * cols];
		int count = move(threshold, rows, cols, 0, 0, visited);

		return count;
	}

	public int move(int threshold, int rows, int cols, int row, int col, boolean[] visited) {

		int count = 0;
		if (check(threshold, rows, cols, row, col, visited)) {
			visited[row * cols + col] = true;
			count = 1 + move(threshold, rows, cols, row, col - 1, visited)
					+ move(threshold, rows, cols, row - 1, col, visited)
					+ move(threshold, rows, cols, row, col + 1, visited)
					+ move(threshold, rows, cols, row + 1, col, visited);
		}

		return count;
	}

	public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {

		boolean canVisit = row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col];

		int sum = getDigitSum(row) + getDigitSum(col);

		return sum <= threshold && canVisit;
	}

	public int getDigitSum(int num) {
		int sum = 0;
		while (num > 0) {
			int digit = num % 10;
			sum += digit;
			num /= 10;
		}

		return sum;
	}

}
