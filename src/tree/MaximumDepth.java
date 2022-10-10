package tree;

import java.util.Arrays;
import java.util.List;

public class MaximumDepth {

	public static void main(String[] args) {
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
	System.out.println(maximum_depth(root));
		
	}
	
	public static int maximum_depth(TreeNode root) {
	    if (root == null) {
	        return 0;                                   // return 0 for null node
	    }
	    int left_depth = maximum_depth(root.left);
	    int right_depth = maximum_depth(root.right);
	    return Math.max(left_depth, right_depth) + 1;   // return depth of the subtree rooted at root
	}

}
