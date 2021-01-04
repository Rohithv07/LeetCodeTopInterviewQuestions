Reverse a linked list. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL,

return 5->4->3->2->1->NULL.

PROBLEM APPROACH :

Complete solution code in the hints







/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A) {
        if (A == null)
            return null;
        ListNode current = A;
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

