package dailyChalange;

import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {

	public static void main(String[] args) {
		int[] target = {3,5,9};

		System.out.println(isPossible1(target));

	}

	public static boolean isPossible(int[] target) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
		long total = 0;
		for (int a : target) {
			total += a;
			pq.add(a);
		}
		while (true) {
			System.out.println(pq);
			int a = pq.poll();
			System.out.println("a " + a);
			total -= a;
			System.out.println("total " + total);
			if (a == 1 || total == 1)
				return true;
			if (a < total || total == 0 || a % total == 0)
				return false;
			a %= total;
			total += a;
			pq.add(a);
		}
	}
	
	public static boolean isPossible1(int[] target) {
        long sum = 0;
        int max = 0, index = 0;
        for (int i = 0; i < target.length; i++) {
        	System.out.println( target[i]);
            sum += target[i];
            if (target[i] > max) {
                max = target[i];
                index = i;
            }
        }
        sum -= max;
        if (sum == 1 || max == 1) return true;
        if (max < sum || sum == 0 || max % sum == 0) return false;
        max %= sum;
        target[index] = max;
        return isPossible1(target);
    }

}
