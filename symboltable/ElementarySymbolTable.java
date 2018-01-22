package com.wajahat.datastructure.symboltable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ElementarySymbolTable<Key, Value> implements SymbolTable<Key, Value> {
	
	private static class Node<Key, Value> {
		Key k;
		Value v;
		Node(Key k, Value v) {
			this.k = k;
			this.v = v;
		}
		
		@Override
		public String toString() {
			return k + " " + v;
		}
	}
	
	List<Node<Key, Value>> list = new LinkedList<>();

	@Override
	public Value get(Key key) {
		for (Node<Key, Value> node : list) {
			if (node.k == key) {
				return node.v;
			}
		}
		return null;
	}

	@Override
	public void put(Key key, Value value) {
		if (contains(key)) {
		for (Node<Key, Value> node : list) {
			if (node.k == key) {
				node.v = value;
			}
		}
		} else {
			list.add(new Node<>(key, value));
		}
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public void delete(Key key) {
		if (!contains(key)) {
			return;
		}
		for (Node<Key, Value> node : list) {
			if (node.k == key) {
				list.remove(node);
			}
		}
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}
	
	@Override
	public Iterable<Key> keys() {
		return new Iterable<Key>() {

			@Override
			public Iterator<Key> iterator() {
				return null;
			}
		};
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Node<Key, Value> n : list) {
			sb.append(n).append("\n");
		}
		return sb.toString();
	}
}
