package tree;

import java.util.Arrays;
import java.util.List;
public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> st = Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);

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
		System.out.println(hasPathSum(root, 22));

	}
	
	public static boolean hasPathSum(TreeNode root, int targetSum) {
		
		if (root == null) {
			return false;
		}
		System.out.println(root.val+ " , "+ (targetSum-root.val));
		if (root.left == null && root.right == null && (targetSum-root.val == 0)) {
			return true;
		}
		
		return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);

	}


//	public static boolean hasPathSum(TreeNode root, int targetSum) {
//		
//		return checkSum(root,0,targetSum);
//
//	}
//
//	public static boolean checkSum(TreeNode root, int val, int target) {
//		
//		if (root == null) {
//			return false;
//		}
//		System.out.println(root.val+ " , "+ (val+root.val));
//		if (val+root.val == target && root.left == null && root.right == null) {
//			return true;
//		}
//		
//		return checkSum(root.left,val+root.val,target) || checkSum(root.right,val+root.val,target);
//
//	}

}
