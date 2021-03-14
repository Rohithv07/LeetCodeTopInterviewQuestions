You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
Example 3:

Input: head = [1], k = 1
Output: [1]
Example 4:

Input: head = [1,2], k = 1
Output: [2,1]
Example 5:

Input: head = [1,2,3], k = 2
Output: [1,2,3]
 

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
        int index = 0;
        ListNode dummyPointer = head;
        ListNode pointerFromStart = head;
        ListNode pointerFromLast = head;
        while (index < k - 1) {
            dummyPointer = dummyPointer.next;
            index += 1;
        }
        // this dummyPointer will be the required kth node from first
        pointerFromStart = dummyPointer;
        dummyPointer = dummyPointer.next;
        
        // now to find the kth pointer from end, we just move dummypointer until it reaches null, simultaneously we move the
        // pointerFromLast
        
        while (dummyPointer != null) {
            pointerFromLast = pointerFromLast.next;
            dummyPointer = dummyPointer.next;
        }
        // swap
        int temp = pointerFromLast.val;
        pointerFromLast.val = pointerFromStart.val;
        pointerFromStart.val = temp;
        return head;
    }
}
