You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // using stack
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode head = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();
            head.val = sum % 10;
            ListNode temp = new ListNode(sum / 10);
            temp.next = head;
            head = temp;
            sum /= 10;
        }
        return head.val == 0 ? head.next : head;
        
        // without using stack
        ListNode reversedL1 = reverse(l1);
        ListNode reversedL2 = reverse(l2);
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (reversedL1 != null || reversedL2 != null) {
            int a = (reversedL1 == null) ? 0 : reversedL1.val;
            int b = (reversedL2 == null) ? 0 : reversedL2.val;
            int sum = a + b + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            if (reversedL1 != null)
                reversedL1 = reversedL1.next;
            if (reversedL2 != null)
                reversedL2 = reversedL2.next;
            current = current.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
            current = current.next;
        }
        ListNode finalResult = reverse(head.next);
        return finalResult;
    }
    public ListNode reverse(ListNode node) {
        if (node == null || node.next == null)
            return node;
        ListNode current = node;
        ListNode previous = null;
        while (current != null) {
            ListNode currentNext = current.next;
            current.next = previous;
            previous = current;
            current = currentNext;
        }
        return previous;
    }
}
