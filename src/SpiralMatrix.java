
public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = generateMatrix(5);
		
		for (int[] is : matrix) {
			for (int is2 : is) {
				System.out.print(is2 + "  ");
			}
			System.out.println();
		}

	}

	public static int[][] generateMatrix(int n) {
		int[][] arr = new int[n][n];
		int j = 0;
		int temp1 = 0;
		int temp =1;
		for (int i = 0; i < (n+1)/2; i++) {
			for ( j = i; j < n- i ; j++) {
				arr[i][j] = temp;
				temp++;
			}
			temp1 = j-1;
			for ( j = i+1; j < n-i; j++) {
				arr[j][temp1] = temp;
				temp++;
			}
			temp1 = j-1;
			for ( j = n-2-i; j >=i; j--) {
				arr[temp1][j] = temp;
				temp++;
			}
			temp1 = j+1;
			for ( j = n-2-i; j > i; j--) {
				arr[j][temp1] = temp;
				temp++;
			}
		}
		return arr;  
    }
	

}
