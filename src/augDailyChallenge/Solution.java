package augDailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * int n = 16; int k = 15; int[] arr = { 11, 21, 23, 2, 6, 20, 7, 12, 15, 20,
		 * 14, 9, 24, 32, 14, 7 }; System.out.println(kthMex(n, k, arr));
		 */

		int N = 16;
		int[] A = { -7, -15, -15, 14, -3, -2, -15, -1, 11, -18, 9, 20, -5, -2, -16, 3 };
		System.out.println(maximumMultiple(N, A));

	}

	static int kthMex(int n, int k, int arr[]) {
		int count = 1;
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		int i = -1;
		while (count <= k) {
			i++;
			if (!set.contains(i)) {
				count += 1;
			}
			// i+=1;
		}
		return i;
	}

	public static long maximumMultiple(int N, int[] A) {

		Arrays.sort(A);

		for (int i : A) {
			System.out.println(i);
		}

		long max = Integer.MIN_VALUE;
		int n = N / 2;

		for (int i = 0; i < N / 2; i++) {
			max = Math.max(max, Math.min(A[i] * A[n + i], A[i] * A[n - i - 1]));
		}

		return max;
		// code here
	}

	public static ArrayList<String> solve(int N, int M, int Q, String col, int[][] Edge, String[] query) {

		return null;
// add your code here
	}

}
