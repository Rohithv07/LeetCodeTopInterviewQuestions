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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1 == null && l2 == null)
            return null;
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = (l1 == null) ? 0 : l1.val;
            int l2Val = (l2 == null) ? 0 : l2.val;
            int sum = l1Val + l2Val + carry;
            int lastDigit = sum % 10;
            carry = sum / 10;
            ListNode lastDigitNode = new ListNode(lastDigit);
            current.next = lastDigitNode;
            if (l1 != null)
                 l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            current = current.next;
        }
        
        if (carry > 0) {
            ListNode lastDigitNode = new ListNode(carry);
            current.next = lastDigitNode;
            current = current.next;
        }
        return result.next;
    }
}