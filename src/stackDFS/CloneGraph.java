package stackDFS;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] adjList = { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } };
		ArrayList<Node> arr;
		ArrayList<Node> nodeList = new ArrayList<>();

		Node node = new Node();
		node.val = 1;

		for (int i = 0; i < adjList.length; i++) {
			arr = new ArrayList<>();
			for (int j = 0; j < adjList[i].length; j++) {
				arr.add(new Node(adjList[i][j]));
			}
			nodeList.add(new Node(i + 1, arr));
		}

		node.neighbors = nodeList;
		cloneGraph(node);
	}

	//static ArrayList<Integer> visited = new ArrayList<>();
	static HashMap<Integer, Node> nodeMap = new HashMap<>();

	public static Node cloneGraph(Node node) {

		Node newNode = new Node();
		ArrayList<Node> nodeList = new ArrayList<>();
		newNode.val = node.val;
		//visited.add(node.val);
		nodeMap.put(node.val, newNode);

		for (Node n1 : node.neighbors) {
			System.out.print(node.val);
			if (!nodeMap.containsKey(node.val)) {
				System.out.println(" neighbour(if) " + n1.val);
				nodeList.add(cloneGraph(n1));

			} else {
				nodeList.add(nodeMap.get(n1.val));
				System.out.println(" neighbour(else) " + n1.val);
			}
		}
		newNode.neighbors = nodeList;

		return newNode;

	}

}
