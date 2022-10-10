import java.util.HashMap;

public class WordPattern {

	public static void main(String[] args) {
		
		String pattern = "abba";
		String s = "dog cat cat fish";
		System.out.println(wordPattern1(pattern,s));
	}
	
	public static boolean wordPattern(String pattern, String s) {
		String[] word = s.split(" ");
		HashMap<Character,String> map = new HashMap<>();
		
		if (word.length != pattern.length()) {
			return false;
		}
		for (int i = 0; i < word.length; i++) {
			if (map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).contentEquals(word[i])){
				return false;
			} else if (map.containsValue(word[i]) && !map.containsKey(pattern.charAt(i))) {
				return false;
			}
			
			
			map.put(pattern.charAt(i),word[i]);
		}	
		return true;
        
    }
	
	
	public static boolean wordPattern1(String pattern, String s) {
		String[] word = s.split(" ");
		String str= "";
		String[] map = new String[128];
		if (word.length != pattern.length()) {
			return false;
		}
		
		for (int i = 0; i < word.length; i++) {
			if (map[pattern.charAt(i)]!=null && !map[pattern.charAt(i)].contentEquals(word[i])) {
				return false;
			} else if (map[pattern.charAt(i)]==null && str.contains(word[i])) {
				return false;
			}
			map[pattern.charAt(i)] = word[i];
			str = str.concat(word[i] + " ");
			
		}
		return true;
        
    }

}
