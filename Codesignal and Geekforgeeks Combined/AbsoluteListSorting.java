Given a linked list of N nodes, sorted in ascending order based on the absolute values of its data,i.e. negative values are considered as positive ones. Sort the linked list in ascending order according to the actual values, and consider negative numbers as negative and positive numbers as positive.


Example 1:

Input: 
List: 1, -2, -3, 4, -5
Output: 
List: -5, -3, -2, 1, 4
Explanation: 
Actual sorted order of {1, -2, -3, 4, -5}
is {-5, -3, -2, 1, 4}
 

Example 2:

Input: 
List: 5, -10
Output: 
List: -10, 5
Explanation:
Actual sorted order of {5, -10}
is {5, 10}
 

Your Task:
You don't need to read or print anyhting. Your Task is to comple the function sortList() which takes the head of the Linked List as input parameter and sort the list in ascending order and return the head pointer of the sorted list.

 

Expected Time Complexity: O(N)
Expected Space Complexity: O(1)


Constraints
1 ≤  N  ≤ 10^5
-10^5 ≤  node.data ≤ 10^5


/*

The below code just uses merge sort and its nlogn complexity.
The main idea for the optimised code is that, the list is sorted in absolute values

So whenever we see any negative number, it have to go up front because since its negative, it will be
smaller in terms of actual values.
So in the list, if a negative number x occurs after a negative number y it means x <= y. 
And for the same 
reason if a positive number x occurs after a positive number y it means y <= x.
*/

class Solution
{
	Node sortList(Node head) {
		// Your code here
		if (head == null || head.next == null) {
		    return head;
		}
		Node previous = null;
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
		    previous = slow;
		    slow = slow.next;
		    fast = fast.next.next;
		}
		previous.next = null;
		Node left = sortList(head);
		Node right = sortList(slow);
		return merge(left, right);
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
	
	Node merge(Node left, Node right) {
	    if (left == null) {
	        return right;
	    }
	    if (right == null) {
	        return left;
	    }
	    if (left.data < right.data) {
	        left.next = merge(left.next, right);
	        return left;
	    }
	    right.next = merge(left, right.next);
	    return right;
	}
}



// optimised O(n) code will be

class Solution
{
	Node sortList(Node head) {
		// Initialize previous and current nodes
		Node prev = head;
		Node curr = head.next;
		
		// Traverse list
		while(curr != null)
		{
			// If curr is smaller than prev, then
            // it must be moved to head
			if(curr.data < prev.data)
			{
				// Detach curr from linked list
				prev.next = curr.next;
				
				// Move current node to beginning
				curr.next = head;
				head = curr;
				
				// Update current
				curr = prev;
			}
			
			// Nothing to do if current element
            // is at right place
			else
			    prev = curr;
		
			// Move current
			curr = curr.next;
		}
		return head;
	}
}