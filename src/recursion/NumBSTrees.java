package recursion;

import java.util.HashMap;

public class NumBSTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(numTrees(3));
	}

	
	//recursion without memorization
	 public static int numTrees(int n) {
			if (treeCount.containsKey(n)) {
				return treeCount.get(n);
			}
			if (n == 1 || n == 0) {
				return 1;
			}
			if (n == 2) {
				return 2;
			}

			int count = 0;
			for (int i = 1; i <= n; i++) {
				count += numTrees(i - 1) * numTrees(n - i);
				treeCount.put(i, count);
			}

			return count;
	    }
	 
	 static HashMap<Integer, Integer> treeCount = new HashMap<>();
	 //recursion with memorization
	 public static int numTrees1(int n) {
			if (treeCount.containsKey(n)) {
				return treeCount.get(n);
			}
			if (n == 1 || n == 0) {
				return 1;
			}
			if (n == 2) {
				return 2;
			}

			int count = 0;
			for (int i = 1; i <= n; i++) {
				treeCount.put(i-1, numTrees1(i - 1));
				treeCount.put(n-i, numTrees1(n - i));
				count += treeCount.get(i - 1) * treeCount.get(n - i);
			}
			return count;

		}

}
