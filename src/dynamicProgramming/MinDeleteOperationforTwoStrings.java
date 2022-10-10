package dynamicProgramming;

public class MinDeleteOperationforTwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word1 = "dinitrophenylhydrazine";
		String word2 = "acetylphenylhydrazine";
		System.out.println(minDistance1(word1, word2));
		
	}
	
	static int[][] storage;
	public static int minDistance1(String word1, String word2) {
		storage = new int[word1.length()+1][word2.length()+1];
		return match( word1,  word2,0,0);
	}
	
	
	public static int match(String word1, String word2, int i, int j) {
		if (storage[i][j]>0) {
			return storage[i][j];
		}
		System.out.println(word1.substring(i,word1.length()) + " , "+ word2.substring(j,word2.length()));
		if (word1.length() == i || word2.length() == j) {
			return Integer.max(word1.length()-i,word2.length()-j);
		}
		if (word1.charAt(i) == word2.charAt(j)) {
			return match(word1,word2,i+1,j+1);
		}else {
			
			storage[i][j] = Integer.min(match(word1,word2,i+1, j),match(word1,word2,i, j+1)) +1;
			return storage[i][j];
			
		}
	}

}
