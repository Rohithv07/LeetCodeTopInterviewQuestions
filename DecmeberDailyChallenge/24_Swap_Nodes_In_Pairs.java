Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes. Only nodes itself may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
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
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode tempNode = new ListNode(0);
        // let the next of tempNode be head
        tempNode.next = head;
        // let currentNode points to temp, ie typically nothing
        ListNode currentNode = tempNode;
        // check the next or next.next is not null of current
        while (currentNode.next != null && currentNode.next.next != null) {
            ListNode first = currentNode.next;
            ListNode second = currentNode.next.next;
            // now do the swapping, make the next of first as next of second
            first.next = second.next;
            // now the pointing changes. Now the head, or the first element changes
            // also the adjacent element also changes
            currentNode.next = second;
            currentNode.next.next = first;
            currentNode = currentNode.next.next;
        }
        return tempNode.next;
    }
}


/*
|<--|--->   |
1 - 2 - 3 - 4
    |
(1, 2) - (3, 4)
    |
(2, 1) - (4, 3)
    
first.next = second.next
current.next = second
current.next.next = first
current = current.next.next
*/
