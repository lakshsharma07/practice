package tree;

import java.util.Arrays;

//Construct Binary Tree from Postorder and Inorder Traversal
public class BuildTree {

	public static void main(String[] args) {
		int[] inorder = { 2, 1 };
		int[] postorder = { 2, 1 };
		
	
		buildTree(inorder, postorder);
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {

		TreeNode node = dfs(new TreeNode(), inorder, postorder);
		// System.out.println(node.val);
		return node;

	}

	public static TreeNode dfs(TreeNode node, int[] inorder, int[] postorder) {

		if (inorder.length == 0 && postorder.length == 0) {
			return null;
		}
		if (inorder.length == 1 && postorder.length == 1) {
			int val = postorder[0];
			node = new TreeNode(val);
			// node.val = val;
			node.left = null;
			node.right = null;
		} else if (inorder.length > 1 && postorder.length > 1) {
			int val = postorder[postorder.length - 1];
			node = new TreeNode(val);

			for (int i = 0; i < postorder.length; i++) {
				if (inorder[i] == val) {
					node.left = dfs(node, Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
					node.right = dfs(node, Arrays.copyOfRange(inorder, i + 1, inorder.length),
							Arrays.copyOfRange(postorder, i, postorder.length - 1));
					return node;
				}
			}
		}
		return node;

	}

}
