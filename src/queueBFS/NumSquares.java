package queueBFS;
import java.util.LinkedList;
import java.util.Queue;

public class NumSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(numSquares(48));
	}


	public static int numSquares1(int n) {

		if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n)
			return 1;

		for (int i = 1; i <= Math.sqrt(n); i++) {
			int x = n - i * i;
			if ((int) Math.sqrt(x) * (int) Math.sqrt(x) == x)
				return 2;
		}
		;

		while (n % 4 == 0)
			n >>= 2;

		if (n % 8 == 7)
			return 4;

		return 3;

	}

	int res;

	public static int numSquares(int n) {
		int sqrRoot = (int) Math.sqrt(n), level = 0;
		boolean[] visited = new boolean[n];
		int[] perfectSquare = new int[sqrRoot];

		for (int i = 1; i <= sqrRoot; ++i) perfectSquare[i - 1] = i * i;

		Queue<Integer> q = new LinkedList();
		q.offer(n);

		while (!q.isEmpty()) {
			System.out.println(q);
			level++;
			int size = q.size();
			for (int i = 0; i < size; ++i) {
				int num = q.poll();

				for (int pSquare : perfectSquare) {
					int remain = num - pSquare;
					if (remain == 0) {
						return level;
					} else if (remain > 0 && !visited[remain - 1]) {
						visited[remain - 1] = true;
						q.offer(remain);
					} else if (remain < 0) {
						break;
					}
				}
			}
		}

		return 0;
	}

}


