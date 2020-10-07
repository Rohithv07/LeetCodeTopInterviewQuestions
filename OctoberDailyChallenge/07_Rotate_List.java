Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

Solution:

/*
1->2->3->4->5->null k = 2
rotate clockwise k timess so that the resulting list will be
rotation 1: 5->1->2->3->4->null
rotation 2: 4->5->1->2->3->null

1. At first lets make use of a fast and slow ListNode and find the total length og the list. Here it is 5.
2. Then we loop from say i - k % i to 0 and move the slow pointer where i = length.
fast = head, slow = head
while (fast.next != null) increment length and fast = fast.next. So here we get length = 5.
now we need to move the current head to length - k % length, ie 5 - 2 = 3. So after rotation current head = 1 will be at 3rd position.
3. fast will be at 5 and slow will be at 4.
so fast.next = head and head = slow.next and slow.next = null.
SO after this we change our list as 4->5->1->2->3->Null
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        // Now find the length of the list.
        int length = 1;
        while (fast.next != null) {
            length += 1;
            fast = fast.next;
        }
        // we got the length. Now traverse from length - k % i and move the slow node.
        for (int i=(length - k % length); i>1; i--)
            slow = slow.next;
        // now our fast is 5, move 5.next to head
        fast.next = head;
        // our slow will be at 4, make it as the new head
        head = slow.next;
        // point slow to null
        slow.next = null;
        return head;
    }
}
