
public class rotate {

	public static void main(String[] args) {
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		//int[][] mat = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		rotate(mat);
	}
	
	public static void rotate(int[][] matrix) {
		for (int[] is : matrix) {
			for (int is2 : is) {
				System.out.print(is2 + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
		int temp;
        for (int i = 0; i < (matrix.length+1)/2; i++) {
			for (int j = 0; j < matrix.length/2; j++) {
				System.out.println(i+","+j);
					temp = matrix[i][j];
					matrix[i][j] = matrix[matrix.length-1-j][i];
					matrix[matrix.length-1-j][i] = matrix[matrix.length-1-i][matrix.length-1-j];
					matrix[matrix.length-1-i][matrix.length-1-j] = matrix[j][matrix.length-1-i];
					matrix[j][matrix.length-1-i] = temp;
					
				for (int[] is : matrix) {
					for (int is2 : is) {
						System.out.print(is2 + " ");
					}
					System.out.println();
				}
				System.out.println("-------------------");
			}
			
		}   
    }

}
