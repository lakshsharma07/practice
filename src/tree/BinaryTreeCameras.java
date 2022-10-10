package tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreeCameras {

	public static void main(String[] args) {
		List<Integer> st = Arrays.asList(0,null,0,null,0,null,0);

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
		System.out.println(minCameraCover(root));

	}
	static int count = 0;
	static int NotNeeded = 0;
	static int NeedCamera = 1;
	static int HasCamera = 2;
	static int Covered = 3;
	public static int minCameraCover(TreeNode root) {
		
		count = checkCameraNode(root) == NeedCamera?count+=1:count;
		return count;

	}
	//[0,null,0,null,0,null,0]
	public static int checkCameraNode(TreeNode root) {
		if (root == null) {
			return NotNeeded;
		}
		if (root.left == null && root.right == null) {
			return NeedCamera;
		}

		int leftNode = checkCameraNode(root.left);
		int rightNode = checkCameraNode(root.right);
		
		//System.out.println(leftNode+ " , " + rightNode);
		if (leftNode == NeedCamera || rightNode == NeedCamera) {
			count ++;
			
			return HasCamera;
		}
		if (leftNode == HasCamera || rightNode == HasCamera) {
			return Covered;
		}
		return NeedCamera;
	}
	
	
	

    int ans;
    Set<TreeNode> covered;
    public int minCameraCover1(TreeNode root) {
        ans = 0;
        covered = new HashSet();
        covered.add(null);

        dfs(root, null);
        return ans;
	}
 public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right, node);

            if (par == null && !covered.contains(node) ||
                    !covered.contains(node.left) ||
                    !covered.contains(node.right)) {
                ans++;
                covered.add(node);
                covered.add(par);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }

}
