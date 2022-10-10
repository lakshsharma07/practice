package Trie;

public class ImplementTrie {

	private static TrieNode root;
	
	public static void main(String[] args) {
		
		String[] cmds =  {"Trie", "insert", "search", "search", "startsWith", "insert", "search"};
		String[][] words =  {{}, {"apple"}, {"apple"}, {"app"}, {"app"}, {"app"}, {"app"}};
		
		
		for (int i = 0;i<cmds.length;i++) {
			
			if (cmds[i].equals("Trie")) {
				Trie();
				System.out.println("null");
			}
			if (cmds[i].equals("insert")) {
				insert(words[i][0]);
				System.out.println("null");
			}
			if (cmds[i].equals("search")) {
				System.out.println(search(words[i][0]));
			}
			if (cmds[i].equals("startsWith")) {
				System.out.println(startsWith(words[i][0]));
			}
			
		}
	}
	
	public static void Trie() {
        root = new TrieNode();
    }
    
    public static void insert(String word) {
        TrieNode it = root;
        
        for (char c : word.toCharArray()) {
			
        	 int charIndex = c - 'a';
        	 
        	 if (it.getChildren()[charIndex] == null) {
				it.getChildren()[charIndex] = new TrieNode();
			}
        	 it = it.getChildren()[charIndex];
		}
        it.setWord(true);
    }
    
    public static boolean search(String word) {
        TrieNode it = root;
        
        for (char c : word.toCharArray()) {
			
        	 int charIndex = c - 'a';
        	 
        	 if (it.getChildren()[charIndex] == null) {
				return false;
			}else {
				it = it.getChildren()[charIndex];
			}
        	 
		}
        
		return it.isWord();
    }
    
    public static boolean startsWith(String prefix) {
        TrieNode it = root;
        
        for (char c : prefix.toCharArray()) {
			
        	 int charIndex = c - 'a';
        	 
        	 if (it.getChildren()[charIndex] == null) {
				return false;
			}
        	 it = it.getChildren()[charIndex];
		}
        
		return true;
    }

}
