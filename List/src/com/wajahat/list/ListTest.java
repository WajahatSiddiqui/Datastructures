package com.wajahat.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ListTest {
	
	private List<Integer> list;
	
	public ListTest() {
		list = new List<Integer>();
		list.insert(10);
		list.insert(20);
		list.insert(30);
	}

	@Test
	public void testInsert() {
		list.insert(40);
		assertTrue(list.contains(40));
		assertEquals(list.size(), 4);
	}

	@Test
	public void testDelete() {
		list.delete(20);
		assertFalse(list.contains(20));
		assertEquals(list.size(), 2);
	}

	@Test
	public void testSize() {
		assertEquals(list.size(), 3);
	}
	
	@Test
	public void testContains() {
		assertTrue(list.contains(30));
	}
	
	@Test
	public void testPrint() {
		System.out.println(list);
	}

}
