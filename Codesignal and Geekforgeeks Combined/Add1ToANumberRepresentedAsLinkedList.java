A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

Example 1:

Input:
LinkedList: 4->5->6
Output: 457 
Example 2:

Input:
LinkedList: 1->2->3
Output: 124 
Your Task:
Your task is to complete the function addOne() which takes the head of the linked list as the only argument and returns the head of the modified linked list. The driver code prints the number.
Note: The head represents the left-most digit of the number.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 101000




/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        if (head == null) {
            return null;
        }
        Node reverse = findReverseRecursion(head);
        Node current = reverse;
        Node result = new Node(-1);
        Node pointer = result;
        int carry = 0;
        int currentSum = current.data + 1 + carry;
        int currentDigit = currentSum % 10;
        carry = currentSum / 10;
        pointer.next = new Node(currentDigit);
        pointer = pointer.next;
        current = current.next;
        while (current != null) {
            if (carry == 0) {
                pointer.next = new Node(current.data);
                pointer = pointer.next;
                current = current.next;
            }
            else {
                int value = current.data;
                int sum = value  + carry;
                int digit = sum % 10;
                carry = sum / 10;
                pointer.next = new Node(digit);
                pointer = pointer.next;
                current = current.next;
            }
            
        }
        if (carry > 0) {
            pointer.next = new Node(carry);
            pointer = pointer.next;
        }
        Node reversedResult = findReverseRecursion(result.next);
        return reversedResult;
    }
    
    public static Node findReverse(Node node) {
        if (node == null) {
            return null;
        }
        Node current = node;
        Node previous = null;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    
    public static Node findReverseRecursion(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node current = findReverseRecursion(node.next);
        node.next.next = node;
        node.next = null;
        return current;
    }
}
