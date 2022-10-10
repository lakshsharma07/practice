package recursion;
import java.util.ArrayList;
import java.util.List;

public class Pascal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rowIndex = 3;
		getRow2( rowIndex);
	}
	
	 
	 public static List<Integer> getRow2(int rowIndex) {
	        List<Integer>result=new ArrayList<>();
	        
	        long first=1;
	        result.add((int)first);
	        for(int i=1;i<=rowIndex;i++){
	            long second=((first*(rowIndex-i+1))/i);
	            result.add((int)second);
	            first=second;
	        }
	        return result;
	    }
}
