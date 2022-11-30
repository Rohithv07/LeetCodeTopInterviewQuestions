Given a singly linked list: A0→A1→...→An-2→An-1, reorder it to: A0→An-1→A1→An-2→A2→An-3→...
For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

Note: It is recommended do this in-place without altering the node's values.

Example 1:

Input:
LinkedList: 1->2->3
Output: 1 3 2
Explanation:
Here n=3, so the correct
order is A0→A2→A1
Example 2:

Input:
Explanation: 1->7->3->4
Output: 1 4 7 3
Explanation:
Here n=4, so the correct
order is A0→A3→A1→A2
Your Task:
The task is to complete the function reorderList() which should reorder the list as required. The reorder list is automatically printed by the driver's code.

Note: Try to solve without using any auxilliary space.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 5*105
1 <= A[ i ] <= 105



/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    Node reorderlist(Node head) {
        // Your code here
        // find middle node
        // revese from the middle
        // now just merge 1->middle, 2->middle+1, 3->middle+2 ......
        
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = findMiddle(head);
        Node first = head;
        Node second = middle.next;
        middle.next = null;
        Node reverseSecond = reverse(second);
        return merge(first, reverseSecond);
    }
    
    Node findMiddle(Node node) {
        if (node == null) {
            return null;
        }
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    Node reverse(Node node) {
        if (node == null) {
            return null;
        }
        Node previous = null;
        Node current = node;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    
    // this is not optimal as we do not do it in-place
    Node merge(Node first, Node second) {
        Node result = new Node(-1);
        Node current = result;
        while (first != null && second != null) {
            current.next = new Node(first.data);
            current = current.next;
            current.next = new Node(second.data);
            current = current.next;
            second = second.next;
            first = first.next;
        }
        while (first != null) {
            current.next = new Node(first.data);
            current = current.next;
            first = first.next;
        }
        while (second != null) {
            current.next = new Node(first.data);
            current = current.next;
            second = second.next;
        }
        return result.next;
    }
}
