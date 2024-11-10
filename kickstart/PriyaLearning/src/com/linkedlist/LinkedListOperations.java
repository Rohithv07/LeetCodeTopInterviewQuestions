package com.linkedlist;

import java.util.Scanner;

public class LinkedListOperations {

	private LinkedListNode linkedListNode;

	public LinkedListOperations() {
		this.linkedListNode = new LinkedListNode();
	}

	private void insertNode(int val, int position) {
		if (position < 0) {
			return;
		}
		LinkedListNode currentWorkingNode = linkedListNode;
		int currentWorkingLength = getLength(currentWorkingNode);
		currentWorkingNode = linkedListNode;
		LinkedListNode storingNode = new LinkedListNode(val);
		// we can insert a new element to the end
		if (currentWorkingLength < position - 1) {
			return;
		}
		if (currentWorkingLength == 0 && position > 0) {
			return;
		}
		if (currentWorkingLength == 0 && position == 0) {
			currentWorkingNode.next = storingNode;
			currentWorkingNode = currentWorkingNode.next;
		} else {
			int pointerMovingFrom = 0;
			while (pointerMovingFrom < position) {
				pointerMovingFrom++;
				currentWorkingNode = currentWorkingNode.next;
			}
			storingNode.next = currentWorkingNode.next;
			currentWorkingNode.next = storingNode;
		}

	}

	private int searchNode(int value) {
		LinkedListNode movingNode = linkedListNode.next;
		int positionOfFoundNode = 0;
		while (movingNode != null) {
			System.out.println(positionOfFoundNode + " " + movingNode.nodeValue);
			if (movingNode.nodeValue == value) {
				return positionOfFoundNode;
			}
			movingNode = movingNode.next;
			positionOfFoundNode++;
		}
		return -1;
	}

	private void printNode() {
		LinkedListNode printedNode = linkedListNode.next;
		while (printedNode != null) {
			System.out.print(printedNode.getNodeValue() + " ");
			printedNode = printedNode.next;
		}
	}

	private int getLength(LinkedListNode currentMovingListNode) {
		int listLength = 0;
		while (currentMovingListNode != null) {
			listLength++;
			currentMovingListNode = currentMovingListNode.next;
		}
		return listLength;
	}

	public static void main(String[] args) {
		LinkedListOperations linkedListOperations = new LinkedListOperations();
		Scanner sc = new Scanner(System.in);
		boolean isEnd = false;
		while (!isEnd) {
			System.out.println("Enter your choice. 1 for Insert, 2 for Print, 3 for search, Anyother key to exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your value and position respectively");
				int insertionValue = sc.nextInt();
				int insertionPosition = sc.nextInt();
				linkedListOperations.insertNode(insertionValue, insertionPosition);
				break;
			case 2:
				System.out.println("Printing the values now");
				linkedListOperations.printNode();
				break;
			case 3:
				System.out.println("Enter the value to be searched in the linkedlist");
				int valueToBeSearched = sc.nextInt();
				int positionFound = linkedListOperations.searchNode(valueToBeSearched);
				if (positionFound == -1) {
					System.out.println("Element is not found in the linkedlist");
				} else {
					System.out.println("Element is found at position " + positionFound);
				}
				break;
			default:
				isEnd = true;
			}
		}
		sc.close();
	}

}
