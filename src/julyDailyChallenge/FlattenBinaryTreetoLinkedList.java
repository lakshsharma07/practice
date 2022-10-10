package julyDailyChallenge;

import java.util.Arrays;
import java.util.List;

import tree.TreeNode;

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> st = Arrays.asList(1, 2, 5, 3, 4, null, 6);

		TreeNode root = insertLevelOrder(st, 0);

		flatten(root);
	}

	public static TreeNode insertLevelOrder(List<Integer> arr, int i) {
		TreeNode root = null;
		if (i < arr.size() && arr.get(i) != null) {
			root = new TreeNode(arr.get(i));

			root.left = insertLevelOrder(arr, 2 * i + 1);
			root.right = insertLevelOrder(arr, 2 * i + 2);
		}
		return root;
	}

	private static TreeNode prev = null;

	public static void flatten(TreeNode root) {
		if (root == null)
			return;

		flatten(root.right);
		System.out.println(root.val);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}


	public static void flatten1(TreeNode root) {
		if (root == null) {
			return;
		}
		//System.out.println(root.val);
		TreeNode right = root.right;

		root.right = root.left;
		root.left = null;
		flatten(root.right);
		flatten(right);
		

	}

}
