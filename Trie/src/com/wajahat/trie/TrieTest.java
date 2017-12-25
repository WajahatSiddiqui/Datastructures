package com.wajahat.trie;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrieTest {
	
	private Trie trie;
	
	public TrieTest() {
		trie = new Trie();
		trie.insert("abc");
		trie.insert("abgl");
		trie.insert("cdf");
		trie.insert("abcd");
		trie.insert("lmn");
	}

	@Test
	public void testInsert() {
		assertEquals(trie.getWordCount(), 5);
	}
	
	@Test
	public void testDelete() {
		trie.delete("lmn");
		assertEquals(trie.getWordCount(), 4);
	}
	
	@Test
	public void testSearchWord() {
		assertTrue(trie.searchWord("abc"));
	}
	
	@Test
	public void testSearchPrefix() {
		assertTrue(trie.searchPrefix("cd"));
	}
}
