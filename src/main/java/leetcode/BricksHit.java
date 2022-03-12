package leetcode;

public class BricksHit {
	public int[] hitBricks(int[][] grid, int[][] hits) {
		int [] result = new int[hits.length];
		for (int k = 0; k < hits.length; k++) {
			int thisHitCount = 0;
			grid[hits[k][0]][hits[k][1]] = 0;
			boolean connected[][] = new boolean[grid.length][grid[0].length];

			for (int j = 0; j < grid[0].length; j++) {
				if (grid[0][j] == 1) {
					connected[0][j] = true;
					dfs(grid, 1, j, connected);
				}
			}
			for (int i = 1; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (!connected[i][j] && grid[i][j] == 1) {
						grid[i][j] = 0;
						thisHitCount++;
					}
				}
			}
			result[k] = thisHitCount;
		}
		return result;
	}


	private void dfs(int[][] grid, int i, int j, boolean[][] connected) {
		if (grid[i][j] == 0) {
			return;
		}
		if (grid[i][j] == 1 && !connected[i][j]) {
			connected[i][j] = true;
			if (j < grid[0].length - 1) {
				dfs(grid, i, j+1, connected);
			}
			if (j > 0) {
				dfs(grid, i, j-1, connected);
			}
			if (i < grid.length-1) {
				dfs(grid, i+1, j, connected);
			}
			if (i > 1) {
				dfs(grid, i-1, j, connected);
			}
		}
	}


	public static void main(String[] args) {
		{
			int[][] grid = {{1, 0, 0, 0}, {1, 1, 1, 0}};
			int[][] hits = {{1, 0}};
			BricksHit bricksHit = new BricksHit();
			final int[] result = bricksHit.hitBricks(grid, hits);
			assert result.length == 1;
			assert result[0] == 2;
		}

		{
			int[][] grid = {{1, 0, 0, 0}, {1, 1, 0, 0}};
			int[][] hits = {{1, 1}, {1, 0}};
			BricksHit bricksHit = new BricksHit();
			final int[] result = bricksHit.hitBricks(grid, hits);
			assert result.length == 2;
			assert result[0] == 0;
			assert result[1] == 0;
		}



	}

}