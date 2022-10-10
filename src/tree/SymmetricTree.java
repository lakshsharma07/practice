package tree;

import java.util.Arrays;
import java.util.List;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> st = Arrays.asList(3, 9, 20, null, null, 15, 7);

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
		System.out.println(isSymmetric(root));

	}

	public static boolean isSymmetric(TreeNode root) {
		return check(root.left, root.right);
	}

	public static boolean check(TreeNode leftNode, TreeNode rightNode) {
		if (leftNode == null && rightNode == null) {
			return true;
		}
		if (leftNode == null || rightNode == null) {
			return false;
		}
		
		if (leftNode.val == rightNode.val) {
			System.out.println(leftNode.val + "," + rightNode.val);

			return (check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left));

		}
		return false;

	}

}
