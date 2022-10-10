package julyDailyChallenge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class JumpGameVI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//40,30,-100,-100,-10,-7,-3,-3
		int[] nums = {1,-5,-20,4,-1,3,-6,-3};
		int k =2;
		System.out.println(maxResult1(nums, k));
	}

	
	//Approach 1: Naive Dynamic Programming (Time Limit Exceeded)
	public static int maxResult(int[] nums, int k) {

		for (int j = 1; j < nums.length; j++) {
			int minSum = Integer.MIN_VALUE;
			for (int i = j-1; i>=0 && i>=j-k ; i--) {
				if (nums[j]+nums[i] > minSum) {
					minSum = nums[j]+nums[i];
				}
			}
			nums[j] = minSum;
		}
		return nums[nums.length-1];
	}
	//1,-5,-20,4,-1,3,-6,-3
	//Approach 2: Dynamic Programming + Decreasing Deque (Accepted)
    public static int maxResult1(int[] nums, int k) {

        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>(); // store index of `nums` elements, elements is in decreasing order, the front is the maximum element.
        dq.offer(0);
        for (int i = 1; i < n; ++i) {
        	System.out.println(dq);
        	for (Integer js : dq) {
				System.out.print(nums[js] + ",");
			}
			System.out.println();
            // nums[i] = max(nums[i-k], nums[i-k+1], .., nums[i-1]) + nums[i] = nums[dq.front()] + nums[i]
            nums[i] = nums[dq.peekFirst()] + nums[i];

            // Add nums[i] to our deque
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast(); // Eliminate elements less or equal to nums[i], which will never be chosen in the future
            dq.offerLast(i);

            // Remove if the last element is out of window size k
            if (i - dq.peekFirst() >= k) dq.pollFirst();
        }
        return nums[n - 1];
	
    }
  //Approach 3: PriorityQueue (Accepted)
	// [1,-5,-20,4,-1,3,-6,-3]
	public static int maxResult2(int[] nums, int k) {
		int i = 1;
		int sum = nums[0];
		PriorityQueue<int[]> que = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
		while (i < nums.length) {
			// System.out.println(i + " " + k + " , " +que.size());
			if (nums[i] <= 0) {
				if (que.size() >= k) {
					// System.out.println(que.peek()[0] + " , " + que.peek()[1]);
					while (i - que.peek()[1] > k) {
						que.poll();
					}
					que.add(new int[] { que.peek()[0] + nums[i], i });
				}
				else {
					que.add(new int[] { sum + nums[i], i });
				}
				
				
				if(i == nums.length - 1) {
					while (que.peek()[1] != i) {
						que.poll();
					}
					sum = que.peek()[0];
				}
				for (int[] js : que) {
					System.out.print(js[0] + "," + js[1] + " - ");
				}
				System.out.println();
			} else {
				if (que.size() >= k) {
					while (i - que.peek()[1] > k) {
						que.poll();
					}
					sum = que.peek()[0] + nums[i];
				} else {
					sum += nums[i];
				}
				if (que.size()>0) {
					que.clear();
				}

			}
			i += 1;
		}
		return sum;
	}
	
	//Approach 4: PriorityQueue (Accepted)
	
    public int maxResult3(int[] nums, int k) {

        if(nums.length == 0) return 0;
        // Score, Index
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        pq.offer(new int[]{nums[0], 0});

        int maxScore = nums[0];

        for(int i = 1; i<nums.length; i++) {
            while(!(i- pq.peek()[1] <= k)) {
                pq.poll();
            }
            int[] cur = pq.peek();
            maxScore  = cur[0] + nums[i];
            pq.offer(new int[]{maxScore, i});
        }
        return maxScore;
    }

}
