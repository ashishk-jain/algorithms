package dynamic;

public class ConnectedIslands {
	public static void main(String[] args) {
		int [][] matrix = new int[][] {
						{ 1, 1, 0, 0, 0 },
						{ 0, 1, 1, 0, 0 },
						{ 0, 1, 0, 1, 0 },
						{ 1, 0, 0, 0, 0 }
		};
		int count = 0;
		boolean [][] visited  = new boolean[4][5];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (!visited[i][j] && matrix[i][j] == 1) {
					int count2 = findConnected(0, matrix, visited, i, j);
					if (count2 > count) {
						count = count2;
					}
				}
			}
		}
		System.out.println("largest island:" + count);
	}

	private static int findConnected(int count, int[][] matrix, boolean[][] visited, int i, int j) {

		if (!visited[i][j] && matrix[i][j] == 1) {
			count++;
			visited[i][j] = true;
			if (j + 1 < matrix[i].length) {
				count = findConnected(count, matrix, visited, i, j + 1);
			}
			if (j - 1 >= 0) {
				count = findConnected(count, matrix, visited, i, j - 1);
			}
			if (i - 1 >= 0) {
				count = findConnected(count, matrix, visited, i - 1, j);
			}

			if (i + 1 < matrix.length) {
				count = findConnected(count, matrix, visited, i + 1, j);
			}
		}
		return count;
	}

}
