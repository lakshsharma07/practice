package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author sharma_l
 *
 */
public class PreorderTraversal {

	public static void main(String[] args) {
		List<Integer> st = Arrays.asList();
		TreeNode root = new TreeNode(st.get(0));
		TreeNode prevNode = root;
		TreeNode nextNode = root;
		for (int i = 1; i < st.size(); i++) {
			if (nextNode != null) {
				prevNode = nextNode;
				if (st.get(i)!=null) {
					nextNode.left = new TreeNode(st.get(i));
				} else {
					nextNode.left = null;
				}
				nextNode = nextNode.left;
			}
			else {
				if (st.get(i)!=null) {
					prevNode.right =new TreeNode(st.get(i));
				} else {
					prevNode.right =  null;
				}
				nextNode = prevNode.right;
			}
		}
		
		preorderTraversal(root);
	}
	
	/*
	 * static ArrayList<Integer> result = new ArrayList<>(); static TreeNode
	 * prevNode = null; static TreeNode nextNode =null; public static List<Integer>
	 * preorderTraversal(TreeNode root) {
	 * 
	 * if (root == null) { return result; }
	 * 
	 * if (root != null) { System.out.println(root.val); result.add(root.val);
	 * prevNode = root; preorderTraversal(root.left); } else { if (prevNode == null)
	 * { return null; } nextNode = prevNode.right; prevNode = root;
	 * preorderTraversal(nextNode); } System.out.println(result); return result;
	 * 
	 * }
	 */
	
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorderTraversal(root, result);
        System.out.println(result);
        return result;
    }
    
    private static void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }

//	public static List<Integer> preorderTraversal(TreeNode root) {
//
//		Stack<TreeNode> stack = new Stack<>();
//		TreeNode prevNode = null;
//		ArrayList<Integer> result = new ArrayList<>();
//		stack.add(root);
//		while (stack.size() > 0) {
//			if (stack.peek() != null) {
//				//System.out.println(stack.peek().val);
//				result.add(stack.peek().val);
//				stack.add(stack.peek().left);
//			} else {
//				stack.pop();
//				if (stack.size() > 0) {
//					prevNode = stack.peek().right;
//					stack.pop();
//					stack.add(prevNode);
//				}
//			}
//		}
//		System.out.println(result);
//		return result;
//
//	}

}
