package Trie;

public class PrefixandSuffixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] cmd =  {"WordFilter", "f"};
		String[][] words =  {{"app","apple","bat","annime"}};
		String[] prefixSuffix =  {"a", "e"};
		
		for (int i = 0; i < cmd.length; i++) {
			if (cmd[i].equals("WordFilter")) {
				WordFilter(words[0]);
				
			}
			if (cmd[i].equals("f")) {
				System.out.println(f( prefixSuffix[0],  prefixSuffix[1])); 
			}
		}
	}
	
	static TrieNode root = new TrieNode();
	public static void WordFilter(String[] words) {
		for (int i =0; i< words.length ; i++) {
	        for (int j = words[i].length()-1; j >=0; j--) {
		        TrieNode it = root;
		        it.index = i;
		        
				String st = words[i].substring(j, words[i].length())+"{"+words[i];
				System.out.println(st);
		        for (char c : st.toCharArray()) {
		        	 int charIndex = c - 'a';
		        	 if (it.children[charIndex] == null) {
						it.children[charIndex] = new TrieNode();
					}
		        	 it = it.children[charIndex];
		        	 it.index = i;
				}
			}
		}
    }
    
    public static int f(String prefix, String suffix) {
        TrieNode it = root;
        String st = suffix+"{"+prefix;
        for (char c : st.toCharArray()) {
        	 int charIndex = c - 'a';
        	 
        	 if (it.children[charIndex] == null) {
				return -1;
			}
        	 it = it.children[charIndex];
		}

        
    	return it.index;
        
    }
    
    public static class TrieNode {
    	
    	 TrieNode[] children;
    	 int index;
    	
    	public TrieNode() {
    		children = new TrieNode[27];
    	}

    }

}

