Given a singly linked list of size N, and an integer K. You need to swap the Kth node from the beginning and Kth node from the end of the linked list. Swap the nodes through the links. Do not change the content of the nodes.

 

Example 1:

Input:
N = 4,  K = 1
value[] = {1,2,3,4}
Output: 1
Explanation: Here K = 1, hence after
swapping the 1st node from the beginning
and end thenew list will be 4 2 3 1.
 

Example 2:

Input:
N = 5,  K = 7
value[] = {1,2,3,4,5}
Output: 1
Explanation: K > N. Swapping is invalid. 
Return the head node as it is.
 

Your Task: 
You do not need to read input or print anything. The task is to complete the function swapkthnode(), which has takes head of link list, N and K as input parameters and returns the new head.
The generated output will be 1 if you are able to complete your task. 

 

Expected Time Complexity: O(n)
Expected Auxillary space Complexity: O(1)

 

Constraints:
1 <= N <= 103
1 <= K <= 103


//User function Template for Java


/* Linked List Node class
   class Node  {
     int data;
     Node next;
     Node(int data)
     {
         this.data = data;
         next = null;
     }
  }
*/
class GFG
{
    //Function to swap Kth node from beginning and end in a linked list.
    Node swapkthnode(Node head, int num, int k)
    {
        // your code here
        if (head == null) {
            return head;
        }
        if (k > num) {
            return head;
        }
        // begining node will be at k
        // end node will be at n - k + 1
        Node x = head;
        Node prevX = null;
        Node y = head;
        Node prevY = null;
        for (int i = 1; i < k; i++) {
            prevX = x;
            x = x.next;
        }
        for (int i = 1; i < num - k + 1; i++) {
            prevY = y;
            y = y.next;
        }
        if (prevX != null) {
            prevX.next = y;
        }
        if (prevY != null) {
            prevY.next = x;
        }
        Node temp = x.next;
        x.next = y.next;
        y.next = temp;
        if (k == 1) {
            head = y;
        }
        if (k == num) {
            head = x;
        }
        return head;
    }
}
