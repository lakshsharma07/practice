package tree;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
    static int index = 0;
    static char temp;
    public void reverseString(char[] s) {
        if(index>s.length/2) return;
        temp = s[index];
        s[index] = s[s.length-1-index];
        s[s.length-1-index] = temp;
        index++;
        reverseString(s);
    }
}
