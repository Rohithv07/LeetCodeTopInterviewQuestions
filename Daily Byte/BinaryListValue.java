/*Given a binary number represented as a linked list, return its decimal value.

Ex: Given the following linked list…

1 -> 0 -> 0 -> 1, return 9 (1001 in decimal is 9).
Ex: Given the following linked list…

0 -> 0 -> 1, return 1./*



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


// another simple answer is => value = value * 2 + head.val
// also using bit manipulation => value = (value << 1) | head.val
// this had to be done inside the loop
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode reversedHead = reverse(head);
        int value = 0;
        int power = 0;
        while (reversedHead != null) {
            value += ((int)Math.pow(2, power) * reversedHead.val);
            reversedHead = reversedHead.next;
            power += 1;
        }
        return value;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
