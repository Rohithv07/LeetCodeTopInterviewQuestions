Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

 

Example 1:


Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0
Example 3:

Input: head = [1]
Output: 1
Example 4:

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880
Example 5:

Input: head = [0,0]
Output: 0
 

Constraints:

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.


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
    public int getDecimalValue(ListNode head) {
        // 2 pass solution by finding the lenght and processing
        if (head == null) {
            return -1;
        }
        int decimalValue = 0;
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        current = head;
        int decrement = 1;
        while (current != null) {
            decimalValue += ((int)Math.pow(2, length - decrement) * current.val);
            decrement++;
            current = current.next;
        }
        return decimalValue;
    }
}




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
    public int getDecimalValue(ListNode head) {
        // one pass using normal operations
        if (head == null) {
            return -1;
        }
        int decimalValue = head.val;
        while (head.next != null) {
            decimalValue = decimalValue * 2 + head.next.val;
            head = head.next;
        }
        return decimalValue;
    }
}


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
    public int getDecimalValue(ListNode head) {
        // one pass using bit operation
        if (head == null) {
            return -1;
        }
        int decimalValue = head.val;
        while (head.next != null) {
            decimalValue = (decimalValue << 1) | head.next.val;
            head = head.next;
        }
        return decimalValue;
    }
}