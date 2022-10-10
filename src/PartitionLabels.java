import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "eaaaabaaec"; // 9,1
		String s1 = "abaccbdeffed"; // 6,6
		String s2 = "ababcbacadefegdehijhklij"; // 9,7,8
		String s3 = "caedbdedda";//1,9
		String s4 = "eccbbbbdec"; // 10
		String s5 = "vhaagbqkaq";//1,1,8
		partitionLabels(s5);
	}

	public static List<Integer> partitionLabels(String s) {

		List<Integer> sizeList = new ArrayList<>();
		int i = 0;
		int size = 0;
		for (int j = 0; j < s.length(); j++) {
			//System.out.println(s.charAt(i));
			int x = s.lastIndexOf(s.charAt(i));
			if (x == size && i == size) {
			//	System.out.println(s.charAt(i)  + "---" + x);
				sizeList.add(x+1);
				//System.out.println(s.substring(0, x + 1));
				s =s.substring(x+1, s.length());
				i=-1;
				size = 0;
			}
			else if (x>size) {
			//	System.out.println(s.charAt(i) + "+++" + x);
				size = x;
			//	System.out.println(size);
			}			
		}
		if (s.length()>0) {
			sizeList.add(s.length());
		}
		System.out.println(sizeList);

		return sizeList;

	}
	
	
	public List<Integer> partitionLabels1(String S) {
		 int[] last = new int[26];
       for (int i = 0; i < S.length(); ++i)
           last[S.charAt(i) - 'a'] = i;
       
       int j = 0, anchor = 0;
       List<Integer> ans = new ArrayList();
       for (int i = 0; i < S.length(); ++i) {
           j = Math.max(j, last[S.charAt(i) - 'a']);
           if (i == j) {
               ans.add(i - anchor + 1);
               anchor = i + 1;
           }
       }
       return ans;
   }

}
