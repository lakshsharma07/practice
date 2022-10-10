package recursion;

public class SearchBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {4,2,7,1,3};
		 int val = 2;
		 TreeNode root = new TreeNode(arr[0]);
		 root = createTree(root,arr,0);
		 searchBST( root,  val);
	}
	
	public static TreeNode createTree(TreeNode root, int[] arr, int j) {
		
		if (j>arr.length-1) {
			return null;
		}
		if (j<arr.length-1) {
			root.left = new TreeNode(arr[j+=1]);
		}
		if (j<arr.length-1) {
			root.right  = new TreeNode(arr[j+=1]);
		}
		createTree(root.left, arr, j+=1);
		createTree(root.right, arr, j+=1);
		return root;
		
	}
	
	public static TreeNode searchBST(TreeNode root, int val) {

		if (root == null) {
			return null;
		}
		if (root.val == val) {
			return root;
		}
		if(root.val>val){
            return searchBST(root.left,val);
        }else{
            return searchBST(root.right,val);
        }		}

}
