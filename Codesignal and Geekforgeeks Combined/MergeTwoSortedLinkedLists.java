Given two sorted linked lists consisting of N and M nodes respectively. The task is to merge both of the list (in-place) and return head of the merged list.
 

Example 1:

Input:
N = 4, M = 3 
valueN[] = {5,10,15,40}
valueM[] = {2,3,20}
Output: 2 3 5 10 15 20 40
Explanation: After merging the two linked
lists, we have merged list as 2, 3, 5,
10, 15, 20, 40.
Example 2:

Input:
N = 2, M = 2
valueN[] = {1,1}
valueM[] = {2,4}
Output:1 1 2 4
Explanation: After merging the given two
linked list , we have 1, 1, 2, 4 as
output.
Your Task:
The task is to complete the function sortedMerge() which takes references to the heads of two linked lists as the arguments and returns the head of merged linked list.

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(1)

Constraints:
1 <= N, M <= 104
1 <= Node's data <= 105





// not in place

/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class LinkedList
{
    //Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
     // This is a "method-only" submission. 
     // You only need to complete this method
         Node p1 = head1;
         Node p2 = head2;
         Node result = new Node(-1);
         Node current = result;
         while (p1 != null && p2 != null) {
             if (p1.data <= p2.data) {
                 current.next = new Node(p1.data);
                 p1 = p1.next;
             }
             else {
                 current.next = new Node(p2.data);
                 p2 = p2.next;
             }
             current = current.next;
             if (p1 == null && p2 == null) {
                 break;
             }
             if (p1 == null) {
                 current.next = p2;
             }
             else if (p2 == null) {
                 current.next = p1;
             }
         }
         return result.next;
   } 
}


// inplace


class LinkedList
{
    Node sortedMerge(Node head1, Node head2) {
     
     Node l1=head1;
     Node l2=head2;
     if(l1.data>l2.data)
     {
         Node help=l1;
         l1=l2;
         l2=help;
     }
     Node res=l1;
     while(l1!=null && l2!=null)
     {
         Node temp=null;
         
         while(l1!=null && l1.data<=l2.data)
         {
             temp=l1;
             l1=l1.next;
         }
         
         temp.next=l2;
         
        Node help=l1;
         l1=l2;
         l2=help;
     }
     
     return res;
     
   } 
}