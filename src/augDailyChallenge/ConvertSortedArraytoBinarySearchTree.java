package augDailyChallenge;

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {
		int[] nums = { 0,1,2,3,4,5,6 };

		sortedArrayToBST(nums);

	}

	public static TreeNode sortedArrayToBST(int[] nums) {

		int n = nums.length;
		TreeNode root = new TreeNode(nums[n / 2]);

		int i = n / 2 - 1;
		if (i >= 0) {
			TreeNode leftRoot = root;
			
			while (i >= 0) {
				System.out.println(i);
				if (i>1) {		
					leftRoot.left = new TreeNode(nums[i-1]);
					leftRoot = leftRoot.left;
					leftRoot.right = new TreeNode(nums[i]);
					i-=2;
				}
				else {
					leftRoot.left = new TreeNode(nums[i]);
					leftRoot = leftRoot.left;
					i--;
				}

			}
		}
		i = n / 2 + 1;
		if (i < n) {
			TreeNode rightRoot = root;
			while (i < n) {
				System.out.println(i);
				if (n-i-1>1) {		
					rightRoot.right = new TreeNode(nums[i+1]);
					rightRoot = rightRoot.right;
					rightRoot.left = new TreeNode(nums[i]);
					i+=2;
				}
				else {
					rightRoot.right = new TreeNode(nums[i]);
					rightRoot = rightRoot.right;
					i++;
				}
			}
		}

		return root;

	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
