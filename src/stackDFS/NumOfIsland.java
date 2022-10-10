package stackDFS;

public class NumOfIsland {
	static int ROW;
	static int COL;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] grid = {{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}};
		numIslands( grid);
	}
	
    
    public static int numIslands(char[][] grid) {
        ROW = grid.length;
		COL = grid[0].length;

		boolean visited[][] = new boolean[ROW][COL];

		int count = 0;
		for (int i = 0; i < ROW; ++i)
			for (int j = 0; j < COL; ++j)
				if (grid[i][j] == '1' && !visited[i][j]) // If a cell with
				{
					DFS(grid, i, j, visited);
					++count;
				}
		return count;
    }
    
    static boolean isSafe(char grid[][], int row, int col, boolean visited[][]) {
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (grid[row][col] == '1' && !visited[row][col]);
	}

	static void DFS(char grid[][], int row, int col, boolean visited[][]) {

		int rowNbr[] = new int[] { -1, 0, 0, 1 };
		int colNbr[] = new int[] { 0, -1, 1, 0 };

		visited[row][col] = true;

		for (int k = 0; k < 4; ++k)
			if (isSafe(grid, row + rowNbr[k], col + colNbr[k], visited))
				DFS(grid, row + rowNbr[k], col + colNbr[k], visited);
	}

}
