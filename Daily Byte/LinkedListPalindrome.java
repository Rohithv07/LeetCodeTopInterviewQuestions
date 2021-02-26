Given a reference to a linked list, return whether or not it forms a palindrome.

Ex: Given a reference to the following linked list...

head = 1->3->1, return true.
Ex: Given a reference to the following linked list...

head = 1->7, return false.


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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        // find the middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseLinkedList(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    public ListNode reverseLinkedList(ListNode slow) {
        if (slow == null)
            return null;
        ListNode current = slow;
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
