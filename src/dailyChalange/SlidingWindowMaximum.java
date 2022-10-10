package dailyChalange;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		System.out.println(maxSlidingWindow1(nums, k));
	}

	// maxHeap
	public int[] maxSlidingWindow(int[] arr, int k) {
		int n = arr.length, j = 0;
		int[] ans = new int[n - k + 1];
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		for (int i = 0; i < n; i++) {
			maxHeap.add(new int[] { arr[i], i });
			if (i + 1 >= k) {
				ans[j++] = maxHeap.peek()[0];
			}
			while (maxHeap.size() > 0 && i - maxHeap.peek()[1] + 1 >= k) { // discard max elements of heap that out of
																			// range k
				maxHeap.poll();
			}
		}
		return ans;
	}

	// Binary Search Tree - TreeMap
	public int[] maxSlidingWindow2(int[] arr, int k) {
		int n = arr.length, j = 0;
		int[] ans = new int[n - k + 1];
		TreeMap<Integer, Integer> bst = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			bst.put(arr[i], bst.getOrDefault(arr[i], 0) + 1);
			if (i + 1 >= k) {
				ans[j++] = bst.lastKey(); // return max element in BST
				removeElement(bst, arr[i + 1 - k]);
			}
		}
		return ans;
	}

	void removeElement(TreeMap<Integer, Integer> bst, int x) {
		bst.put(x, bst.getOrDefault(x, 0) - 1);
		if (bst.get(x) == 0)
			bst.remove(x);
	}

	// Decreasing Deque
	// 1,3,-1,-3,5,3,6,7
	public static int[] maxSlidingWindow1(int[] nums, int k) {
		// assume nums is not null
		int n = nums.length;
		if (n == 0 || k == 0) {
			return new int[0];
		}
		int[] result = new int[n - k + 1]; // number of windows
		Deque<Integer> win = new ArrayDeque<>(); // stores indices

		for (int i = 0; i < n; ++i) {
			System.out.println(win);
			for (Integer js : win) {
				System.out.print(nums[js] + ",");
			}
			System.out.println();
			// remove indices that are out of bound
			while (win.size() > 0 && win.peekFirst() <= i - k) {
				win.pollFirst();
			}
			// remove indices whose corresponding values are less than nums[i]
			while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
				win.pollLast();
			}
			// add nums[i]
			win.offerLast(i);
			// add to result
			if (i >= k - 1) {
				result[i - k + 1] = nums[win.peekFirst()];
			}
		}
		return result;
	}

}
