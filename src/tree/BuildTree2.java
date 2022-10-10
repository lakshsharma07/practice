package tree;

import java.util.Arrays;

//Construct Binary Tree from Preorder and Inorder Traversal
public class BuildTree2 {

	public static void main(String[] args) {
		int[] inorder = {9,3,15,20,7 };
		int[] preorder = {3,9,20,15,7};

		buildTree(inorder, preorder);
	}

	public static TreeNode buildTree(int[] inorder, int[] preorder) {


		return dfs(new TreeNode(), inorder, preorder);

	}

	public static TreeNode dfs(TreeNode node, int[] inorder, int[] preorder) {
		System.out.println(inorder.length + " , "+ preorder.length);
		if (inorder.length == 0 && preorder.length == 0) {
			return null;
		}
		if (inorder.length == 1 && preorder.length == 1) {
			int val = preorder[0];
			System.out.println(val);
			node = new TreeNode(val);
			// node.val = val;
			node.left = null;
			node.right = null;
		} else if (inorder.length > 1 && preorder.length > 1) {
			int val = preorder[0];
			System.out.println(val);
			node = new TreeNode(val);

			for (int i = 0; i < inorder.length; i++) {
				if (inorder[i] == val) {
					node.left = dfs(node, Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(preorder,1,i+1));
					node.right = dfs(node, Arrays.copyOfRange(inorder, i + 1, inorder.length),Arrays.copyOfRange(preorder, i+1, preorder.length));
					return node;
				}
			}
		}
		return node;

	}

}
