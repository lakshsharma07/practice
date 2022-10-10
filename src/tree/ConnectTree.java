package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectTree {

	public static void main(String[] args) {
		List<Integer> st = Arrays.asList(3, 9, 20, null, null, 15, 7);

		Node root = new Node(st.get(0));
		Node prevNode = root;
		Node nextNode = root;
		for (int i = 1; i < st.size(); i++) {
			if (nextNode != null) {
				prevNode = nextNode;
				if (st.get(i) != null) {
					nextNode.left = new Node(st.get(i));
				} else {
					nextNode.left = null;
				}
				nextNode = nextNode.left;
			} else {
				if (st.get(i) != null) {
					prevNode.right = new Node(st.get(i));
				} else {
					prevNode.right = null;
				}
				nextNode = prevNode.right;
			}
		}
		connect(root);
	}

	
	static Queue<Node> queue = new LinkedList<Node>();
	public static Node connect(Node root) {
		if (root == null) {
			return null;
		}
		Node node;
		queue.add(root);
		while (!queue.isEmpty()) {
			var level = new ArrayList<Integer>();
			var count = queue.size();
			for (var i = 0; i < count; i++) {
				node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			//node.next = Integer.getInteger("#");
		}
		return root;

	}

}
