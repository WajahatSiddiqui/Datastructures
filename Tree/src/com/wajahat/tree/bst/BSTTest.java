package com.wajahat.tree.bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class BSTTest {

	private BST bst;
	
	public BSTTest() {
		bst = new BST();
		bst.insert(10);
		bst.insert(2);
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
		bst.insert(12);
		bst.insert(14);		
		bst.insert(20);
	}
	
	@Test
	public void testSize() {
		assertEquals(bst.size(), 8);
	}
	
	@Test
	public void testInsert() {
		bst.insert(32);
		assertEquals(bst.size(), 9);
		assertTrue(bst.contains(32));
	}
	
	@Test
	public void testContains() {
		assertTrue(bst.contains(20));
		assertFalse(bst.contains(11));
	}
	
	@Test
	public void testDelete() {
		bst.delete(20);
		assertFalse(bst.contains(20));
		assertEquals(bst.size(), 7);
	}
	
	@Test
	public void testInorder() {
		List<Integer> list = bst.inorder();
		int size = list.size();
		for (int i = 1; i < size; i++) {
			assertTrue(list.get(i-1) < list.get(i));
		}
	}
}
