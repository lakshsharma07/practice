import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pascal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rowIndex = 30;
		getRow3( rowIndex);
	}
	
	
	private static void getRow(int n) {
		List<List<Integer>> arr = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			List<Integer> arr1 = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					arr1.add(1);
				}else {
					arr1.add(arr.get(i-1).get(j-1) +arr.get(i-1).get(j));
				}
			}
			for (int j : arr1) {
				System.out.print(j+" ");
			}
			System.out.println();
			arr.add(arr1);
		}
	}
	
	
	
	 public static List<Integer> getRow1(int rowIndex) {
	        List<Integer> arr = new ArrayList<>();
	        
			for (int i = 0; i <= rowIndex; i++) {
				List<Integer> arr1 = new ArrayList<>();
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) {
						arr1.add(1);
					}else {
						arr1.add(arr.get(j-1) +arr.get(j));
					}
				}
				arr = arr1;
			}
			System.out.println(arr);
			return arr;
	    }
	 
	 
	 // belongs to combinations nc0 nc1 nc2 .....ncr
	 // ncr = ncr-1 * n-r+1/r
	 public List<Integer> getRow2(int rowIndex) {
	        List<Integer>result=new ArrayList<>();
	        
	        long first=1;
	        result.add((int)first);
	        for(int i=1;i<=rowIndex;i++){
	            long second=((first*(rowIndex-i+1))/i);
	            result.add((int)second);
	            first=second;
	        }
	        return result;
	    }
	 
	 
	 
	 
	 // Recursion 
	 public static List<Integer> getRow3(int rowIndex) {
	        List<Integer>result=new ArrayList<>();
	        int[][] arr = new int[rowIndex+1][rowIndex+1];
	        for (int i = 0; i <= rowIndex; i++) {
				result.add(fetchValue(rowIndex , i,arr));
			}
	        System.out.println(result);
	        return result;
	    }
	 
	 
	 public static int fetchValue(int row, int col, int[][] arr) {
		 System.out.println(row+" , "+ col);
	        if (col == 0 || row == col) {
				return 1;
			}
	        else {
	        	if (arr[row][col] == 0) {
	        		arr[row][col] = (fetchValue(row - 1, col-1,arr)+fetchValue(row - 1, col,arr));
				}
				return arr[row][col];
			}
	}
}
