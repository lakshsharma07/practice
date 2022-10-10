package augDailyChallenge;

public class MirrorReflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int mirrorReflection(int p, int q) {
		while ((p%2==0) && (q%2==0)) {
            p/=2;
            q/=2;
        }
        //both p qnd q can't be even
        if((p%2)==0 && (q%2)!=0){
            return 2;//when p is even and q is odd
        } 
        if((p%2)!=0 && (q%2)!=0){
            return 1;// when p is odd and q is odd
        } 
        return 0;// when p is odd and q is even
}

}
