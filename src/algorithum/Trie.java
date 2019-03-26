package algorithum;

class TrieNode {

	public char val;
	public boolean isWord;
	public TrieNode[] children = new TrieNode[26];

	public TrieNode() {
	}

	TrieNode(char c) {
		this();
		this.val = c;
	}
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
		root.val = ' ';
	}

	public void insert(String word) {
		TrieNode ws = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (ws.children[c - 'a'] == null) {
				ws.children[c - 'a'] = new TrieNode(c);
			}
			ws = ws.children[c - 'a'];
		}
		ws.isWord = true;
		
		System.out.println("Insert word:"+ word);
	}

	public boolean search(String word) {
		TrieNode ws = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (ws.children[c - 'a'] == null)
				return false;
			ws = ws.children[c - 'a'];
		}
		return ws.isWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode ws = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (ws.children[c - 'a'] == null)
				return false;
			ws = ws.children[c - 'a'];
		}
		return true;
	}

	public static void main(String[] args) {

		Trie trie = new Trie();

		String word = "apple";
		String word_blur="app";

		trie.insert(word);
		System.out.println("Search "+word+ ":"+ trie.search(word)); // returns true
		System.out.println("Search "+word_blur+ ":"+ trie.search(word_blur));
		trie.startsWith(word_blur); // returns true
		trie.insert(word_blur);
		System.out.println("Search "+word_blur+ ":"+ trie.search(word_blur)); // returns true

	}
}