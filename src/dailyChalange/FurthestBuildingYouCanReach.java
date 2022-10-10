package dailyChalange;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

	public static void main(String[] args) {
		int[] heights = {4,12,2,7,3,18,20,3,19};
		int bricks = 10;
		int ladders = 2;

		System.out.println(furthestBuilding(heights, bricks, ladders));

	}

	public static int furthestBuilding(int[] heights, int bricks, int ladders) {

		return check(heights, bricks, ladders, 0);

	}

	public static int furthestBuilding1(int[] A, int bricks, int ladders) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < A.length - 1; i++) {
			int d = A[i + 1] - A[i];
			if (d > 0)
				pq.add(d);
			System.out.println(pq);
			if (pq.size() > ladders)
				bricks -= pq.poll();
			if (bricks < 0)
				return i;
		}
		return A.length - 1;

	}

	private static int check(int[] heights, int bricks, int ladders, int i) {
		// System.out.println(heights[i]+" , "+ bricks+" , "+ ladders);
		if (i == heights.length - 1) {
			// System.out.println("------");
			return i;
		}
		int count = heights[i + 1] - heights[i];

		if (bricks - count < 0 && ladders <= 0) {
			// System.out.println("------");
			return i;
		}

		if (count <= 0) {
			// System.out.println("nothing");
			return check(heights, bricks, ladders, i + 1);
		} else {
			int x = 0, y = 0;
			if (bricks - count >= 0) {
				// System.out.println("brick");
				x = check(heights, bricks - count, ladders, i + 1);
			}
			if (ladders > 0) {
				// System.out.println("ladder");
				y = check(heights, bricks, ladders - 1, i + 1);
			}
			return Integer.max(x, y);
		}

	}

}
