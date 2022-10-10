package dailyChalange;

public class MaximumPointsYouCanObtainfromCards {

	public static void main(String[] args) {
		int[] cardPoints = {1,79,80,1,1,1,200,1};
		int k = 3;
		System.out.println( maxScore(cardPoints, k));
	}
	
	 public static int maxScore(int[] cardPoints, int k) {
		 int n = cardPoints.length;
		 int ttl_sum = 0;
		 for (int i = 0; i < k; i++) {
			ttl_sum+=cardPoints[i];
		}
		 if (n == k) {
			return ttl_sum;
		}
		 int sum = ttl_sum;
		 int i = 1;
		 while (i<=k) {
			ttl_sum = ttl_sum-cardPoints[k-i]+cardPoints[n-i];
			System.out.println(ttl_sum);
			if (ttl_sum>sum) {
				sum = ttl_sum;
			}
			i+=1;
		}
		return sum;      
	    }

}
