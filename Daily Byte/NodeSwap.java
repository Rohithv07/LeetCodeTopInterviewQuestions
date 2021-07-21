/*
Given the reference to a linked list, head, swap each pair of adjacent nodes and the return a reference to the modified list.

Ex: Given a reference to the following linked list…

1->2->3->4, return 2->1->4->3 (1 and 2 have been swapped and 3 and 4 have been swapped).
*/


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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode currentNode = result;
        while (currentNode.next != null && currentNode.next.next != null) {
            ListNode first = currentNode.next;
            ListNode second = currentNode.next.next;
            first.next = second.next;
            currentNode.next = second;
            currentNode.next.next = first;
            currentNode = currentNode.next.next;
        }
        return result.next;
    }
}