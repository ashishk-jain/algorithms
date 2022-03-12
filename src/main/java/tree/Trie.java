package tree;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private final TrieNode root;

	public Trie() {
		root = new TrieNode(false);
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addWord("abc");
		trie.addWord("efd");
		trie.addWord("abcd");
		trie.addWord("ab");
	}

	private void addWord(String word) {
		TrieNode currNode = root;
		for (char ch :word.toCharArray()){
			if (currNode.getChildren().containsKey(ch)) {
				currNode = currNode.getChildren().get(ch);
			} else {
				final TrieNode trieNode = new TrieNode(false);
				currNode.getChildren().put(ch, trieNode);
				currNode = trieNode;
			}
		}
		currNode.setEndOfWord(true);
	}
}

class TrieNode {
	private Map<Character, TrieNode> children;

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public boolean isEndOfWord() {
		return endOfWord;
	}

	private boolean endOfWord;

	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}

	public TrieNode(boolean endOfWord) {
		this.endOfWord = endOfWord;
		children = new HashMap<>();
	}
}

