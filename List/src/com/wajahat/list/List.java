package com.wajahat.list;

public class List<Key> {

	private Node<Key> head;
	private int size;
	
	public List() {
		head = null;
		size = 0;
	}

	public void insert(Key key) {
		Node<Key> node = new Node<>(key);
		if (head == null) {
			head = node;
		} else {
			Node<Key> curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = node;
		}
		size++;
	}

	public void delete(Key key) {
		if (head == null) return;
		Node<Key> curr = head, prev = head;
		while (curr != null && !curr.equivalent(key)) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
		size--;
	}

	public int size() {
		return size;
	}
	
	public boolean contains(Key key) {
		if (head == null) return false;
		
		Node<Key> curr = head;
		while (curr != null) {
			if (curr.equivalent(key)) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}
	
	@Override
	public String toString() {
		if (head == null) return "";
		Node<Key> curr = head;
		StringBuffer sb = new StringBuffer();
		while (curr != null) {
			sb.append(curr.key);
			curr = curr.next;
			if (curr != null) {
				sb.append("->");
			}
		}
		return sb.toString();
	}
}
