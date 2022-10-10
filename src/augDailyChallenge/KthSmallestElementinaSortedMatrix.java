package augDailyChallenge;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		int k = 6;
		System.out.println(kthSmallest(matrix, k));
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->b-a);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				
				que.add(matrix[i][j]);
				if (que.size()>k) {
					que.poll();
				}
				System.out.println(que);
			}
		}
		
		
		
		return que.peek();
        
    }

}
