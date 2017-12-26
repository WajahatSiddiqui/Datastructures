package com.wajahat.list;

public class Node<Key> {
	Key key;
	Node<Key> next;
	
	public Node(Key key) {
		this.key = key;
	}
	
	public boolean equivalent(Key obj) {
		return this.key == obj;
	}
}