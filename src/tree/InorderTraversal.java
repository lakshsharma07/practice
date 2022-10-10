package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> st = Arrays.asList(1,2,3,4);
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
		
		inorderTraversal(root);
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        inorderTraversal(root, list);
        System.out.println(list);
        return list;
    }
    
    private static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
	
	/*
	 * public static List<Integer> inorderTraversal(TreeNode root) { Stack<TreeNode>
	 * stack = new Stack<>(); TreeNode prevNode = null; ArrayList<Integer> result =
	 * new ArrayList<>(); stack.add(root); while (stack.size()>0) { if (stack.peek()
	 * != null) { stack.add(stack.peek().left); } else { stack.pop(); if
	 * (stack.size()>0) { prevNode = stack.peek().right;
	 * System.out.println(stack.peek().val); result.add(stack.pop().val);
	 * stack.add(prevNode); } } } System.out.println(result); return result; }
	 */



}
