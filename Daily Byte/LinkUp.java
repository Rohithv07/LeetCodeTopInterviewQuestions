import java.util.*;

This question is asked by Facebook. Given a singly linked list, re-order and group its nodes in such a way that the nodes in odd positions come first and the nodes in even positions come last.

Ex: Given the reference to the following linked list...

4->7->5->6->3->2->1->NULL, return 4->5->3->1->7->6->2->NULL
Ex: Given the reference to the following linked list...

1->2->3->4->5->NULL, return 1->3->5->2->4->NULL


class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class LinkUp {

	public static ListNode oddEvenExchange(ListNode root) {
		if (root == null)
			return null;
		ListNode odd = root;
		ListNode even = root.next;
		ListNode evenHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return root;
	}

	public static void main(String [] args) {
		ListNode root1 = new ListNode(4);
		root1.next = new ListNode(7);
		root1.next.next = new ListNode(5);
		root1.next.next.next = new ListNode(6);
		root1.next.next.next.next = new ListNode(3);
		root1.next.next.next.next.next = new ListNode(2);
		root1.next.next.next.next.next.next = new ListNode(1);
		root1.next.next.next.next.next.next.next = new ListNode();
		root1 = oddEvenExchange(root1);
		while (root1 != null) {
			System.out.print(root1.val + " ");
			root1 = root1.next;
		}
	}
}



