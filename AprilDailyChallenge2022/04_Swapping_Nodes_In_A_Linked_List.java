You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100



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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = findLength(head);
        if (k > length) {
            return head;
        }
        ListNode previousFront = null;
        ListNode front = head;
        ListNode previousBack = null;
        ListNode back = head;
        for (int i = 1; i < k; i++) {
            previousFront = front;
            front = front.next;
        }
        for (int i = 1; i < length - k + 1; i++) {
            previousBack = back;
            back = back.next;
        }
        if (previousBack != null) {
            previousBack.next = front;
        }
        if (previousFront != null) {
            previousFront.next = back;
        }
        ListNode temp = front.next;
        front.next = back.next;
        back.next = temp;
        if (k == 1) {
            head = back;
        }
        if (k == length) {
            head = front;
        }
        return head;
    }
    
    private int findLength(ListNode node) {
        if (node == null) {
            return 0;
        }
        if (node.next == null) {
            return 1;
        }
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}