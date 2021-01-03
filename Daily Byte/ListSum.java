import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class ListSum {
	public static ListNode findTheSum(ListNode root1, ListNode root2) {
		if (root1 == null && root2 == null)
			return null;
		ListNode root3 = new ListNode(0);
		ListNode dummy = root3;
		int carry = 0;
		while (root1 != null || root2 != null) {
			int value1 = (root1 != null) ? root1.val : 0;
			int value2 = (root2 != null) ? root2.val : 0;
			int sum = value1 + value2 + carry;
			carry = sum / 10;
			int lastDigit = sum % 10;
			ListNode newLastDigit = new ListNode(lastDigit);
			dummy.next = newLastDigit;
			if (root1 != null)
				root1 = root1.next;
			if (root2 != null)
				root2 = root2.next;
			dummy = dummy.next;
		}
		if (carry > 0) {
			ListNode lastDigit = new ListNode(carry);
			dummy.next = lastDigit;
			dummy = dummy.next;
		}
		return root3.next;
	}

	public static void main(String [] args) {
		ListNode root1 = new ListNode(2);
		root1.next = new ListNode(4);
		root1.next.next = new ListNode(3);
		ListNode root2 = new ListNode(5);
		root2.next = new ListNode(6);
		root2.next.next = new ListNode(4);
		ListNode root3 = findTheSum(root1, root2);
		while (root3 != null) {
			System.out.println(root3.val);
			root3 = root3.next;
		}
	}
}