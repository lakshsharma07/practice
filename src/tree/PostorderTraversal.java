package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostorderTraversal {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		List<Integer> st = Arrays.asList(3,null,1,2);
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
		
		
		TreeNode root1 = new TreeNode();
		postorderTraversal(root1);
	
	}
	
	static List<Integer> result = new ArrayList<>();
    public static List<Integer> postorderTraversal(TreeNode root) {
        
        if (root == null) {
            return result;
        }
        dfs(root);
       System.out.println(result);
        return result;
    }
    
    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        result.add(root.val);
        
    }

}
