Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200


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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode less = new ListNode(0);
        ListNode tempLess = less;
        ListNode greater = new ListNode(0);
        ListNode tempGreater = greater;
        while (current != null) {
            if (current.val < x) {
                tempLess.next = new ListNode(current.val);
                tempLess = tempLess.next;
            }
            else {
                tempGreater.next = new ListNode(current.val);
                tempGreater = tempGreater.next;
            }
            current = current.next;
        }
        tempLess.next = greater.next;
        return less.next;
    }
}