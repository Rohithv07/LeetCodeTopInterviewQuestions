package lrucache;

/**
 * Doubly linked list data structure with key, value, next, previous fields
 * 
 * @author vazha
 *
 */
public class DoublyLinkedList {
	int key;
	int value;
	DoublyLinkedList next;
	DoublyLinkedList previous;

	public DoublyLinkedList(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
