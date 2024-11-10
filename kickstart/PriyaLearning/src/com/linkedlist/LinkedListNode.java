package com.linkedlist;

public class LinkedListNode {
	public int nodeValue;
	public LinkedListNode next;

	public LinkedListNode() {

	}

	public LinkedListNode(int nodeValue) {
		this.setNodeValue(nodeValue);
	}

	public LinkedListNode(int nodeValue, LinkedListNode next) {
		this.setNodeValue(nodeValue);
		this.setNext(next);
	}

	/**
	 * @return the nodeValue
	 */
	public int getNodeValue() {
		return nodeValue;
	}

	/**
	 * @param nodeValue the nodeValue to set
	 */
	public void setNodeValue(int nodeValue) {
		this.nodeValue = nodeValue;
	}

	/**
	 * @return the next
	 */
	public LinkedListNode getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(LinkedListNode next) {
		this.next = next;
	}

}
