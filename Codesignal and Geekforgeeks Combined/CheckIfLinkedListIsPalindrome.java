Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.

Example 1:

Input:
N = 3
value[] = {1,2,1}
Output: 1
Explanation: The given linked list is
1 2 1 , which is a palindrome and
Hence, the output is 1.
Example 2:

Input:
N = 4
value[] = {1,2,3,4}
Output: 0
Explanation: The given linked list
is 1 2 3 4 , which is not a palindrome
and Hence, the output is 0.
Your Task:
The task is to complete the function isPalindrome() which takes head as reference as the only parameter and returns true or false if linked list is palindrome or not respectively.

Expected Time Complexity: O(N)
Expected Auxialliary Space Usage: O(1)  (ie, you should not use the recursive stack space as well)

Constraints:
1 <= N <= 105



/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
// f.    f.     f
// 1->2->3->2->>1->null
// s. s. s

class Solution
{
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) 
    {
        //Your code here
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node reverseList = reverse2(slow);
        if (reverseList == null) {
            return false;
        }
        slow = reverseList;
        fast = head;
        while (slow != null) {
            if (slow.data != fast.data)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }    
    
    // apply any of these functions for reverse
    Node reverse1(Node node) {
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

    // apply any of these functions for reverse
    Node reverse2(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node p = reverse2(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }
}

