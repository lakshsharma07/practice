package Trie;

public class TrieNode {
	
	private TrieNode[] children;
	private boolean isWord;
	
	public TrieNode() {
		setChildren(new TrieNode[26]);
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public TrieNode[] getChildren() {
		return children;
	}

	public void setChildren(TrieNode[] children) {
		this.children = children;
	}

}
