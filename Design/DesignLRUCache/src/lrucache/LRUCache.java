package lrucache;

import java.util.*;

/**
 * Helper class to build Least Recently Used Cache
 * 
 * Assumption : 
 *  What are we caching?
		We are caching the results of web queries
	Can we assume inputs are valid or do we have to validate them?
		Assume they're valid
	Can we assume this fits memory?
		Yes
 * 
 * @see get(key) - O(1)
 * @see put(key) - O(1)
 * @author vazha
 *
 */
public class LRUCache {
	private DoublyLinkedList head = new DoublyLinkedList(-1, -1);
	private DoublyLinkedList tail = new DoublyLinkedList(-1, -1);
	private Map<Integer, DoublyLinkedList> map;
	private int capacity;

	/**
	 * Public constructor
	 * 
	 * @param capacity
	 */
	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head.next = tail;
		tail.previous = head;
	}

	/**
	 * if the map contains key, remove the node from current position, insert it
	 * into front as it is used now and return the value
	 * 
	 * return -1 if the key is not present
	 * 
	 * @param key
	 * @return value
	 */

	public int get(int key) {
		if (map.containsKey(key)) {
			DoublyLinkedList node = map.get(key);
			remove(node);
			insert(node);
			return node.value;
		} else {
			return -1;
		}
	}

	/**
	 * we need to check mainly 2 conditions, if map contains the key, then remove
	 * from the map if map size == capacity, then remove tail.previous insert a new
	 * doubly linked list (key, value)
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
		} else if (map.size() == capacity) {
			remove(tail.previous);
		}
		insert(new DoublyLinkedList(key, value));
	}

	/**
	 * we remove the key from the map at first reposition the nodes previous's next
	 * to the nodes previous reposition the nodes next's previous to the nodes next
	 * 
	 * @param node
	 */
	public void remove(DoublyLinkedList node) {
		map.remove(node.key);
		node.previous.next = node.next;
		node.next.previous = node.previous;
	}

	/**
	 * First of all we insert the value inside the hashmap Now we create a pointer
	 * to the next of head 
	 * head.next = node 
	 * node.previous = head 
	 * headNext.previous = node
	 * node.next = headNext
	 * 
	 * This is basically we are pushing the new node into the front and the
	 * remaining node to the next of new node
	 * 
	 * @param node
	 */

	public void insert(DoublyLinkedList node) {
		map.put(node.key, node);
		DoublyLinkedList headNext = head.next;
		head.next = node;
		node.previous = head;
		headNext.previous = node;
		node.next = headNext;

	}
}
