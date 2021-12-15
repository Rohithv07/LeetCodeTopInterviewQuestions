Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.


 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
 

Constraints:

The number of nodes in the list is in the range [1, 5000].
-5000 <= Node.val <= 5000



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
    // we create an null valued node first
    ListNode sorted = null;
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        // store the head to another pointer
        ListNode current = head;
        // traverse
        while (current != null) {
            // store the next node
            ListNode nextNode = current.next;
            // helper function helps in sortibng
            sortList(current);
            current = nextNode;
        }
        head = sorted;
        return head;
    }
    public void sortList(ListNode node) {
        // the base conditon if the sorted is null or the value in sorted > that in current node
        if (sorted == null || sorted.val >= node.val) {
            node.next = sorted;
            sorted = node;
        } 
        else {
            // have a temp node for traversing
            ListNode temp = sorted;
            while (temp.next != null && temp.next.val < node.val)
                temp = temp.next;
            // now we got the position required position
            node.next = temp.next;
            temp.next = node;
        }
    }
} 