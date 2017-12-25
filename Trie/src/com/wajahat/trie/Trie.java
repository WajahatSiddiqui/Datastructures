package com.wajahat.trie;

public class Trie {
	private TrieNode root;
	int wordCount = 0;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		int wordLen = word.length();
		for (int i = 0; i < wordLen; i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.isCompleteWord = true;
		wordCount++;
	}

	public void delete(String word) {
		delete(root, word, 0);
		if (!searchWord(word)) {
			wordCount--;
		}
	}

	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			if (!current.isCompleteWord) {
				return false;
			}
			current.isCompleteWord = false;
			return current.children.size() == 0;
		}

		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}

		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

		if (shouldDeleteCurrentNode) {
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;
	}

	public boolean searchPrefix(String prefix) {
		TrieNode current = root;
		int prefixLen = prefix.length();
		boolean found = true;
		for (int i = 0; i < prefixLen; i++) {
			char ch = prefix.charAt(i);
			if (!current.children.containsKey(ch)) {
				found = false;
				break;
			}
			current = current.children.get(ch);
		}
		return found;
	}

	public boolean searchWord(String word) {
		TrieNode current = root;
		int wordLen = word.length();
		for (int i = 0; i < wordLen; i++) {
			char ch = word.charAt(i);
			if (!current.children.containsKey(ch)) {
				return false;
			}
			current = current.children.get(ch);
		}
		return current.isCompleteWord;		
	}

	public int getWordCount() {
		return wordCount;
	}
}
