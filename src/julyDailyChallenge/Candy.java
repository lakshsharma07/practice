package julyDailyChallenge;

import java.util.Arrays;

public class Candy {

	private static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] ratings = {1,2,3,5,4,3,2,1};
		int[] ratings = {29,51,87,87,72,12};
		System.out.println(candy1(ratings)); 
	}
	
	public static int candy(int[] ratings) {
		int[] d = new int[ratings.length];
		Arrays.fill(d, 1);
		for (int i = 0; i < ratings.length-1; i++) {
			if (ratings[i] <ratings[i+1]) {
				d[i+1]=d[i]+1;
			}
			if(ratings[i] >ratings[i+1]) {
				/*
				 * if (d[i]<=d[i+1]) { d[i]+=1; }
				 */
				for (int j = i+1; j > 0; j--) {
					if ( d[j-1]-d[j]<=1 && d[j-1]-d[j]>=0 && ratings[j] !=ratings[j-1] ) {
						d[j-1]=d[j]+1;
					}
					else {
						break;
					}
				}
			}
			
			for (int k = 0; k < d.length; k++) {
				System.out.print(d[k]+",");
			}
			System.out.println();
		}
		
		for (int i = 0; i < d.length; i++) {
			count+=d[i];
		}
		return count;
        
    }
	
    public static int candy1(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }
    
    
    public int candy2(int[] ratings) {
        int n = ratings.length;
        int[] tmp = new int[n];
        Arrays.fill(tmp,1);
        for (int i=1; i<n; i++) {
            if (ratings[i]>ratings[i-1]) {
                tmp[i] = tmp[i-1] + 1;
            }
        }
        for (int i=n-2; i>=0; i--) {
            if(ratings[i]>ratings[i+1]) {
                 if(i-1 >= 0 && ratings[i-1] <= ratings[i])
                    tmp[i] = Math.max(tmp[i+1]+1, tmp[i]);
                else
                    tmp[i] = tmp[i+1] + 1;
            }
        }
        int cnt = 0;
        for (int i=0; i<n; i++) {
            // System.out.println(tmp[i]);
            cnt+=tmp[i];
        }
        return cnt;
    }


}
