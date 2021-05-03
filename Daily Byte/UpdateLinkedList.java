/*
Given a reference to the head of a linked list and two values, m, and n, traverse the entire list keeping the first m elements followed by removing the next n elements. Return the resulting list.

Ex: Given the following head, m, and n…

1 -> 2 -> 3 -> null, m = 1, n = 1, return 1 -> 3 -> null.
Ex: Given the following head, m, and n…

1 -> 3 -> 2 -> 4 -> null, m = 2, n = 2, return 1 -> 3 -> null.
*/

import java.util.*;

class ListNode {
	int value;
	ListNode next;
	ListNode(){}
	ListNode(int value) {
		this.value = value;
	}
	ListNode(int value, ListNode next) {
		this.value = value;
		this.next = next;
	}
}

public class UpdateLinkedList {

	public static void updateHead(ListNode head, int m, int n) {
		if (head == null)
			return;
		ListNode current = head;
		while (m-- > 1) {
			current = current.next;
		}
		ListNode skip = current.next;
		while (n-- > 1) {
			skip = skip.next;
		}
		current.next = skip.next;
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		int m = sc.nextInt();
		int n = sc.nextInt();
		updateHead(head, m, n);
	}
}
