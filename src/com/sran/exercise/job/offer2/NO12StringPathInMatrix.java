package com.sran.exercise.job.offer2;

public class NO12StringPathInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] matrix = { 'A', 'B', 'C', 'D', 'E', 'F' };
		String m = "ABCESFCSADEE";
		matrix = m.toCharArray();
		char[] str = { 'S', 'E', 'E' };
		System.out.println(hasPath(matrix, 3, 4, str));

	}

	public static boolean hasPath(char[] matrix, int rows, int cols, char str[]) {
		// check();

		int x = 0, y = 0;
		for (x=0; x < rows; x++) {
			for (y=0; y < cols; y++) {
				int index = x * cols + y;
				if (matrix[index] == str[0]) {
					boolean[] visited = new boolean[rows * cols];
					int[] pathLength = { 0 };
					if (move(matrix, rows, cols, x, y, str, pathLength, visited)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public static boolean move(char[] matrix, int rows, int cols, int x, int y, char str[], int[] pathLength,
			boolean[] visited) {

		if (pathLength[0] == str.length) {
			return true;
		}

		boolean result = false;
		if (canVisit(x, y, rows, cols, visited) && matrix[x * cols + y] == str[pathLength[0]]) {
			pathLength[0]++;
			visited[x * cols + y] = true;

			result = move(matrix, rows, cols, x, y - 1, str, pathLength, visited)
					|| move(matrix, rows, cols, x - 1, y, str, pathLength, visited)
					|| move(matrix, rows, cols, x, y + 1, str, pathLength, visited)
					|| move(matrix, rows, cols, x + 1, y, str, pathLength, visited);
			
			if (result==false) {
				pathLength[0]--;
				visited[x*cols+y] = false;
			}
		}

		return result;
	}

	public static boolean canVisit(int x, int y, int rows, int cols, boolean[] visited) {
		return x >= 0 && x < rows && y >= 0 && y < cols && !visited[x * cols + y];
	}

}
