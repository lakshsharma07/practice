
public class coin1 {

	 public static void main (String[] args)
	    {
	        int [] a = {-3,-1,-2};
	        System.out.println("Maximum contiguous sum is " +
	        		maxarray(3, a));
	    }
	
	    static int maxarray(int input1 ,int[] input2)
	    {
	        int max1 = Integer.MIN_VALUE, max2 = 0;
	 
	        for (int i = 0; i < input1; i++)
	        {

	        	max2 = max2 + input2[i];
	            if (max1 < max2)
	            	max1 = max2;
	            if (max2 < 0)
	            	max2 = 0;
	        }
	        return max1;
	    }

}
