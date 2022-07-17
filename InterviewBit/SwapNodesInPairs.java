Given a linked list, swap every two adjacent nodes and return its head.

For example,

Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode current = node;
        ListNode next = current.next;
        while (current != null && current.next != null) {
            ListNode store = current;
            current = current.next;
            store.next = current.next;
            current.next = store;
            current = store.next;
            if (current != null && current.next != null) {
                store.next = current.next;
            }
        }
        return next;
    }
}
