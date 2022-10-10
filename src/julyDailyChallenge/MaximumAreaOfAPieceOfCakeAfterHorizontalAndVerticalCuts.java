package julyDailyChallenge;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h = 1000000000;
		int w = 1000000000;
		int[] horizontalCuts = { 2 };
		int[] verticalCuts = { 2 };
		System.out.println(maxArea(h, w, horizontalCuts, verticalCuts));
	}


	public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		long mod = 1000000007;
		int maxH =  horizontalCuts[0]-0;

		for (int i = 1; i < horizontalCuts.length; i++) {
			maxH = Math.max(maxH, horizontalCuts[i]-horizontalCuts[i - 1]);
		}
		maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
		System.out.println(maxH);
		
		
		
		int maxV = verticalCuts[0]-0;
		for (int i = 1; i < verticalCuts.length; i++) {
			maxV = Math.max(maxV, verticalCuts[i]-verticalCuts[i - 1]);
		}

		maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length - 1]);
		System.out.println(maxV);
		

		return (int)(maxH%mod*maxV%mod) ;

	}

}
