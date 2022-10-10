package julyDailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tree.TreeNode;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> st = Arrays.asList(1, 2, 3, null, 5, null, 4);
		TreeNode root = new TreeNode(st.get(0));
		TreeNode prevNode = root;
		TreeNode nextNode = root;
		for (int i = 1; i < st.size(); i++) {
			if (nextNode != null) {
				prevNode = nextNode;
				if (st.get(i) != null) {
					nextNode.left = new TreeNode(st.get(i));
				} else {
					nextNode.left = null;
				}
				nextNode = nextNode.left;
			} else {
				if (st.get(i) != null) {
					prevNode.right = new TreeNode(st.get(i));
				} else {
					prevNode.right = null;
				}
				nextNode = prevNode.right;
			}
		}
		System.out.println(rightSideView(root));

	}

	static List<Integer> ans = new ArrayList<>();

	public static List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return ans;
		}

		ans.add(root.val);
		dfs(root.left, root.right, 0);

		return ans;

	}

	private static boolean dfs(TreeNode leftNode, TreeNode rightNode, int i) {

		if (leftNode == null && rightNode == null) {
			return false;
		}

		if (rightNode != null) {
			if (ans.size() < i) {
				ans.add(rightNode.val);
			}

			dfs(rightNode.left, rightNode.right, i + 1);
		}
		if (leftNode != null) {
			if (ans.size() < i) {
				ans.add(leftNode.val);
			}
			dfs(leftNode.left, leftNode.right, i + 1);
		}
		return false;
	}

	public List<Integer> rightSideView1(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}

	public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
		if (curr == null) {
			return;
		}
		if (currDepth == result.size()) {
			result.add(curr.val);
		}

		rightView(curr.right, result, currDepth + 1);
		rightView(curr.left, result, currDepth + 1);

	}

}
