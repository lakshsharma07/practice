package julyDailyChallenge;

public class KInversePairsArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(kInversePairs1(1000, 1000));
	}

	static Integer[][] memo = new Integer[1001][1001];
	static int M = 1000000007;

	// TopDown Approach - TTLE
	public static int kInversePairs1(int n, int k) {

		if (n == 0) {
			memo[n][k] = 0;
			return 0;
		}
		if (k == 0) {
			memo[n][k] = 1;
			return 1;
		}
		if (memo[n][k] != null)
			return memo[n][k];
		int val = 0;
		for (int i = 0; i < n; i++) {
			// System.out.println(n + " , " + k);
			if (k - i >= 0) {
				val = val % M + kInversePairs1(n - 1, k - i) % M;
			}

		}
		memo[n][k] = val % M;

		return memo[n][k];
	}

	// BottomUp Approach
	public static int kInversePairs(int n, int k) {
        int[] dp = new int[k + 1];
        int M = 1000000007;
        for (int i = 1; i <= n; i++) {
            int[] temp = new int[k + 1];
            temp[0] = 1;
            for (int j = 1; j <= k ; j++) {
                int val = (dp[j] + M - ((j - i) >= 0 ? dp[j - i] : 0)) % M;
                temp[j] = (temp[j - 1] + val) % M;
            }
            dp = temp;
        }
        return ((dp[k] + M - (k > 0 ? dp[k - 1] : 0)) % M);}

}
