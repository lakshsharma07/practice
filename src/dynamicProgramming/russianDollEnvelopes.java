package dynamicProgramming;

public class russianDollEnvelopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
		maxEnvelopes(envelopes);
	}
	
public static int maxEnvelopes(int[][] envelopes) {
	

	for (int[] is : envelopes) {
		System.out.println(is[0]+","+is[1]);
	}
	return 0;
        
    }

}
