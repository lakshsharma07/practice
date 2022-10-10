package julyDailyChallenge;

import java.util.Arrays;

public class MaximumUnitsOnATruck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] boxTypes = { { 1, 3 }, { 5, 5 }, { 2, 5 }, { 4, 2 }, { 4, 1 }, { 3, 1 }, { 2, 2 }, { 1, 3 }, { 2, 5 },
				{ 3, 2 } };
		int truckSize = 35;
		System.out.println(maximumUnits(boxTypes, truckSize));
	}

	public static int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

		int sum = 0;
		int totalBoxes = truckSize;
		for (int[] arr1 : boxTypes) {
			int boxCount = Math.min(totalBoxes, arr1[0]);
			sum = sum + boxCount * arr1[1];
			totalBoxes = totalBoxes - boxCount;
			if (totalBoxes == 0)
				break;
		}

		return sum;
	}

}
