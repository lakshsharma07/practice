package recursion;

public class kthSymbolGrammar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(kthGrammar(2, 2));
	}

	public static int kthGrammar(int n, int k) {

		// n - row
		// k - index of that element in that row
		if (k == 1) {
			return 0;
		}
		if (k == Math.pow(2, n)) {
			return 1;
		}

		return (kthGrammar(n - 1, (k + 1) / 2) == (k + 1) % 2) ? 0 : 1;

	}

	public int kthGrammar1(int N, int K) {
		if (N == 1)
			return 0;
		if (K <= 1 << N - 2)
			return kthGrammar(N - 1, K);
		return kthGrammar(N - 1, K - (1 << N - 2)) ^ 1;
	}

	public int kthGrammar2(int n, int k) {

		if (n == 1) {
			return 0;
		}

		if (k % 2 == 0) {

			if (kthGrammar(n - 1, k / 2) == 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (kthGrammar(n - 1, (k + 1) / 2) == 0) {
				return 0;
			} else {
				return 1;
			}
		}

	}

}
