package recursion;

public class MyPow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x =-1.0000;
		int n = -2147483648;
		
		System.out.println(myPow( x,  n));
	}
	
	static double pow =1;
	public static double myPow(double x, int n) {
		if (pow == 0.0) {
			return 0.0;
		}
		if (x == 1.0) {
			return x;
		}
		if (x == -1.0) {
			return (n%2==0?-x:x);
		}
		if (n == 0 ) {
			return 1;
		}
		if (n>0) {
			pow*=x;
			myPow(x, n-1);
		} 
		if (n<0) {
			pow*=1/x;
			myPow(x, n+1);
			
		} 
		return pow;
        
    }
	
	public double myPow1(double x, int n) {
        return Math.pow(x,n);
    }

}
