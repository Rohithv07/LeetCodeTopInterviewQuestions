/*
Given the reference to two linked lists, return the node at which they intersect.
Note: If the two lists never intersect, return null.

Ex: Given the following linked lists...

A: A1->A2
          \
           C1->C2->C3
          /
B: B1->B2
return a reference to node C1.
*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null ||headB == null)
            return null;
        ListNode aPointer = headA;
        ListNode bPointer = headB;
        while (aPointer != bPointer) {
            if (aPointer == null) {
                aPointer = headB;
            }
            else {
                aPointer = aPointer.next;
            }
            if (bPointer == null) {
                bPointer = headA;
            }
            else {
                bPointer = bPointer.next;
            }
        }
        return aPointer;
    }
}