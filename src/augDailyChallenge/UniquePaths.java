package augDailyChallenge;

public class UniquePaths {

	private static int count = 0;
	private static int[][] dp ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3, 3));
	}

	public static int uniquePaths(int m, int n) {
		dp = new int[m][n];
		for (int i = 0; i < m; ++i) { // init
		    for (int j = 0; j < n; ++j) {
		      dp[i][j] = -1;
		    }
		  }
		return dfs(m-1,n-1);
	}

	private static int dfs(int i, int j) {
		System.out.println(i + " , " + j);

		if (i == 0 || j == 0) {
			return 1;
		}
		if (dp[i-1][j] == -1) {
			dp[i-1][j] = dfs(i-1, j);
		}
		if (dp[i][j-1] == -1) {
			dp[i][j-1] = dfs(i-1, j);
		}
		return dfs(i-1, j)+ dfs(i, j-1);

	}

	public static int uniquePaths1(int m, int n) {
		if (m == 0 || n == 0) {
			throw new IllegalArgumentException("m or n can't be 0");
		}
		int[][] dp = new int[m][n];
		// init
		for (int i = 0; i < m; ++i)
			dp[i][0] = 1;
		for (int i = 0; i < n; ++i)
			dp[0][i] = 1;
		// dp
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
	
	static Node leftNode;
	static Node rightNode;
	public Node deleteNode(Node root,int k)
    {
		if (root == null) {
			return null;
		}
		if (root.data>=k) {
			rightNode = root.right;
			leftNode = root.left;
			root = root.left;
			root.right = rightNode;
			deleteNode(root, k);
			deleteNode(root.right, k);
			
		}else {
			deleteNode(root.left, k);
			deleteNode(root.right, k);
		}
		
		return root;
    //add code here.
    }

}


class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
