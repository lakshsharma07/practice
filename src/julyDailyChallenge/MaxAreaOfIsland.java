package julyDailyChallenge;

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(maxAreaOfIsland(grid));
	}
	
	static int count ;
	 public static int maxAreaOfIsland(int[][] grid) {

	        int numIslands = 0;
	        for(int i = 0; i< grid.length;i++){
	            for(int j = 0; j< grid[0].length;j++){
	                if(grid[i][j]==1){
	                	count =1;
	                	System.out.println(i + " , " + j);
	                     markIslandSize(grid, i,j);
	                     System.out.println(count);
	                    if (count>numIslands) {
	                    	numIslands = count;
						}
	                }
	            }
	        }
	        return numIslands;
	 }
	 
	 public static void markIslandSize(int[][] grid, int i, int j){
	        grid[i][j]=2;
	        if(i-1>=0 && grid[i-1][j]==1){
	        	count+=1;
	             markIslandSize(grid, i-1,j);
	        }
	        if(i+1<grid.length && grid[i+1][j]==1){
	        	count+=1;
	        	 markIslandSize(grid, i+1,j);
	        }
	        if(j+1<grid[0].length && grid[i][j+1]==1){
	        	count+=1;
	        	 markIslandSize(grid, i,j+1);
	        }
	        if(j-1>=0 && grid[i][j-1]==1){
	        	count+=1;
	        	 markIslandSize(grid, i,j-1);
	        }
	    }

}
