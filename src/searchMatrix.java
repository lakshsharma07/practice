import java.util.Arrays;
import java.util.stream.Collectors;

public class searchMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int[][] matrix1 = { { -1,3 }};
		int target =3;
		System.out.println(searchMatrix2(matrix1, target));
	}
	 public static boolean searchMatrix(int[][] matrix, int target) {
		    for (int i = 0; i < matrix.length; i++) {
					if (target>=matrix[i][0] && target<=matrix[i][matrix[i].length-1]) {
						for (int j = 0; j < matrix[i].length; j++) {
							System.out.println(i+" , "+j);
							if (matrix[i][j] == target) {
								return true;
							}
						}
					}
				}
				return false;
		    }

	public static boolean searchMatrix2(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			if (target>=matrix[i][0] && target<=matrix[i][matrix[i].length-1]) {
				if (matrix[i][(matrix[i].length)/2] >=target) {
					for (int j = 0; j <= (matrix[i].length+1)/2; j++) {
						System.out.println(i+" , "+j);
						if (matrix[i][j] == target) {
							return true;
						}
					}
				
				}
				else {
					for (int j = matrix[i].length/2+1; j < matrix[i].length; j++) {
						System.out.println(i+" , "+j);
						if (matrix[i][j] == target) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static boolean searchMatrix1(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			if (Arrays.stream(matrix[i]).boxed().collect(Collectors.toList()).contains(target)) {
				return true;
			}
		}

		return false;

	}
}
