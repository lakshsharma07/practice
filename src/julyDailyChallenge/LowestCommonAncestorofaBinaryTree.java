package julyDailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tree.TreeNode;

public class LowestCommonAncestorofaBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> st = Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
		int p = 5;
		int q = 1;
		TreeNode root = insertLevelOrder(st, 0);

		TreeNode pNode = new TreeNode(p);
		TreeNode qNode = new TreeNode(q);
		System.out.println(lowestCommonAncestor(root, pNode, qNode).val);
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

	static ArrayList<Integer> count = new ArrayList<>();
	static int nodeCount = 0;

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return null;
		}
		System.out.println(root.val + " , " + count);
		if (root != null && nodeCount < 1) {
			count.add(root.val);
		}
		if (root.val == p.val || root.val == q.val) {
			nodeCount += 1;
			if (nodeCount == 2) {
				return root;
			}
		}
		lowestCommonAncestor(root.left, p, q);
		if (nodeCount == 2 && count.contains(root.val)) {
			//return root;
			System.out.println(root.val);
		}

		lowestCommonAncestor(root.right, p, q);
		if (nodeCount == 2 && count.contains(root.val)) {
			//return root;
			System.out.println(root.val);
		}

		return q;
	}

}
