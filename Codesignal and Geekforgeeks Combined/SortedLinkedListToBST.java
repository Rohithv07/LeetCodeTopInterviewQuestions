Given a Singly Linked List which has data members sorted in ascending order. Construct a Balanced Binary Search Tree which has same data members as the given Linked List.
Note: There might be nodes with same value.

Example 1:

Input:
Linked List: 1->2->3->4->5->6->7
Output:
4 2 1 3 6 5 7
Explanation :
The BST formed using elements of the 
linked list is,
        4
      /   \
     2     6
   /  \   / \
  1   3  5   7  
Hence, preorder traversal of this 
tree is 4 2 1 3 6 5 7
Example 2:

Input:
Linked List : 1->2->3->4
Ouput:
3 2 1 4
Exaplanation:
The BST formed using elements of the 
linked list is,
      3   
    /  \  
   2    4 
 / 
1
Hence, the preorder traversal of this 
tree is 3 2 1 4
Your task :
You don't have to read input or print anything. Your task is to complete the function sortedListToBST(), which takes head of the linked list as an input parameter and returns the root of the BST created.
 
Expected Time Complexity: O(N), N = number of Nodes
Expected Auxiliary Space: O(N), N = number of Nodes
 
Constraints:
1 ≤ Number of Nodes ≤ 106
1 ≤ Value of each node ≤ 106


//User function Template for Java

/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}*/

class Solution
{
    public TNode sortedListToBST(LNode head)
    {
        //code here
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TNode(head.data);
        }
        LNode previous = null;
        LNode slow = head;
        LNode fast = head;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        LNode middle = slow;
        TNode root = new TNode(middle.data);
        previous.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);
        return root;
    }
}