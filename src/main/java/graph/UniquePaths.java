package graph;

public class UniquePaths {
	public int uniquePaths(int A, int B) {
		int [][] paths = new int[A][B];
		for (int i = 0; i < A; i++) {
			paths[i][0] = 1;
		}
		for (int j = 0; j < B; j++) {
			paths[0][j] = 1;
		}

		for (int i = 1; i<A; i++){
			for (int j = 1; j < B; j++) {
				paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
			}
		}
		return paths[A-1][B-1];
	}
}
