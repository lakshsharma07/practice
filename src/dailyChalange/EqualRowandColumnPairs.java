package dailyChalange;

import java.util.ArrayList;
import java.util.HashMap;

public class EqualRowandColumnPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{11,1},{1,11}};
		System.out.println(equalPairs(grid));
		
	}
	
	 public static int equalPairs(int[][] grid) {
		 int count = 0;
		 HashMap<String,Integer> map = new HashMap<>();
		 for (int i = 0; i < grid.length; i++) {
			 String s ="";
			for (int j = 0; j < grid[i].length; j++) {
				s+=String.valueOf(grid[i][j])+",";
			}
			map.put(s,map.getOrDefault(s,0)+1);
			
		}	
		 
		 
		 for (int i = 0; i < grid.length; i++) {
			 String s ="";
			for (int j = 0; j < grid[i].length; j++) {
				s+=String.valueOf(grid[j][i])+",";
			}
			count+= map.getOrDefault(s,0);
		}
		 
		 System.out.println(map);
		return count;
	        
	    }

}
