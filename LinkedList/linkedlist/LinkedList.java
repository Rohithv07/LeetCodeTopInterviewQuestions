package com.rohith.linkedlist;

public class LinkedList {
	Node head; // head of the list

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	// insertion at
	// 1. Front
	// 2. After a given node
	// 3. End
	public void pushStart(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}

	public void pushAfter(Node previousNode, int newData) {
		if (previousNode == null) {
			System.out.println("Node cannot be null");
			return;
		}
		Node newNode = new Node(newData);
		newNode.next = previousNode.next;
		previousNode.next = newNode;
	}

	public void pushEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = new Node(data);
			return;
		}
		newNode.next = null;
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		return;
	}

	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	// delete a node given the key
	// find the previous node
	// remove the link and give the next of previous to next of deleted node

	public void deleteNode(int key) {
		if (head == null) {
			System.out.println("No items to delete");
			return;
		}
		Node temp = head;
		Node previous = null;
		// if head is the node to be deleted
		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		while (temp != null && temp.data != key) {
			previous = temp;
			temp = temp.next;
		}
		if (temp == null)
			return;
		previous.next = temp.next; // unlink
	}

	// delete at a position
	public void deletePosition(int pos) {
		if (head == null) {
			System.out.println("No element to delete");
			return;
		}
		Node current = head;
		if (pos == 0) {
			head = current.next;
			return;
		}
		int i = 0;
		while (i < pos - 1 && current != null) {
			current = current.next;
			i += 1;
		}
		if (current == null || current.next == null) {
			System.out.println("Position exceeds");
		}
		Node next = current.next.next;
		current.next = next; // unlink
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.pushEnd(6);
		list.pushStart(7);
		list.pushStart(1);
		list.pushEnd(4);
		list.pushAfter(list.head.next, 8);
		list.printList();
		list.deleteNode(4);
		list.printList();
		list.deleteNode(8);
		list.printList();
		list.deletePosition(2);
		list.printList();
		list.deletePosition(0);
		list.printList();
	}
}
