package com.wajahat.lrucache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * LruCache Implementation
 * @author Wajahat Siddiqui
 */
public class LruCache<Key, Value> {
	
	private ConcurrentHashMap<Key, Value> map;
	private ConcurrentLinkedQueue<Key> queue;
	private int capacity;
	
	public LruCache(int capacity) {
		this.capacity = capacity;
		map = new ConcurrentHashMap<Key, Value>(capacity);
		queue = new ConcurrentLinkedQueue<Key>();
	}
	
	/**
	 * Put <Key, Value> Pair into cache
	 * @param key - the key 
	 * @param value - the value
	 */
	public void put(Key key, Value value) {
		if (contains(key)) {
			queue.remove(key);
		}
		
		if (size() >= capacity) {
			map.remove(queue.poll());
		}
		
		map.put(key, value);
		queue.add(key);
	}
	
	/**
	 * Gets the value for the corresponding key
	 * @param key - the key
	 * @return Value for the given key
	 */
	public Value get(Key key) {
		return map.get(key);
	}
	
	/**
	 * Checks if key is present in LruCache
	 * @param key - the key
	 * @return true, if key is present, false otherwise.
	 */
	public boolean contains(Key key) {
		return map.get(key) != null;
	}
	
	/**
	 * Removes the key from the lru cache
	 * @param key - the key
	 * @return value which is removed from the cache
	 */
	public Value remove(Key key) {
		if (!contains(key)) return null;
		Value value = get(key);
		map.remove(key);
		queue.remove(key);
		return value;
	}
	
	/**
	 * The current size of the queue
	 * @return size of the lru queue
	 */
	public int size() { return queue.size(); }
	
	/**
	 * Checks if the lru cache is empty
	 * @return true of lru cache is empty, false otherwise
	 */
	public boolean isEmpty() { return size() == 0; }
	
	/**
	 * Returns the string representation of lru cache.
	 */
	@Override
	public String toString() {
		if (isEmpty()) return "";
		return "map: " + map.toString() + "\nqueue: " + queue.toString();
	}
}
