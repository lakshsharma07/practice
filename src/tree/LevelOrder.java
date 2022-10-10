package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

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

		levelOrder1(root);

	}

	public static List<List<Integer>> levelOrder(TreeNode root) {

		HashMap<TreeNode, Integer> count = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();

		List<Integer> x;
		int index = 0;
		if (root == null) {
			return result;
		}
		count.put(root, 0);
		que.add(root);
		while (!que.isEmpty()) {
			root = que.peek();
			if (root != null) {
				System.out.println(root.val + " -- " + count.get(root));
				if (result.size() > count.get(root)) {
					result.get(count.get(root)).add(root.val);
				} else {
					x = new ArrayList<>();
					x.add(root.val);
					result.add(x);

				}

				index = count.get(root) + 1;
				que.add(root.left);
				count.put(root.left, index);
				que.add(root.right);
				count.put(root.right, index);
				que.poll();
				System.out.println(count);

			} else {
				que.poll();
			}
		}

		System.out.println(result);
		return null;
	}
	
	
	 public static List<List<Integer>> levelOrder1(TreeNode root) {        
	        List<List<Integer>> res = new ArrayList<>();
	        if (root == null) {
	            return res;
	        }
	        var queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        while (!queue.isEmpty()) {
	            var level = new ArrayList<Integer>();
	            var count = queue.size();
	            for (var i = 0; i < count; i++) {
	                var node = queue.poll();
	                level.add(node.val);
	                if (node.left != null) {
	                    queue.add(node.left);
	                }
	                if (node.right != null) {
	                    queue.add(node.right);
	                }
	            }
	            res.add(level);
	        }
	        return res;
	    }

}
