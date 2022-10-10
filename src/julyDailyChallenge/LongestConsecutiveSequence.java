package julyDailyChallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 3, 7, 2, 5, 8, 4,7 , 0, 1 };
		System.out.println(longestConsecutive1(nums));
	}

	public static int longestConsecutive(int[] nums) {
		int max = 0;
		int left = 0;
		int right = 0;
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (Integer n : nums) {
			if (!map.containsKey(n)) {
				left = map.containsKey(n - 1) ? map.get(n - 1) : 0;

				right = map.containsKey(n + 1) ? map.get(n + 1) : 0;

				count = left + right + 1;
				map.put(n, count);

				max = Math.max(max, count);

				map.put(n - left, count);
				map.put(n + right, count);
				System.out.println(map);
			}
		}
		// System.out.println(num);

		return max;

	}

	public static int longestConsecutive1(int[] nums) {
		Set<Integer> num_set = new HashSet<Integer>();
		for (int num : nums) {
			num_set.add(num);
		}
		System.out.println(num_set);
		int longestStreak = 0;

		for (int num : num_set) {
			if (!num_set.contains(num - 1)) {
				System.out.println(num);
				int currentNum = num;
				int currentStreak = 1;

				while (num_set.contains(currentNum + 1)) {
					currentNum += 1;
					currentStreak += 1;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}

		return longestStreak;
	}

}
