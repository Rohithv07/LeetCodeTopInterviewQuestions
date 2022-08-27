Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.

TreeToList

Example 1:

Input:
      1
    /  \
   3    2
Output:
3 1 2 
2 1 3 
Explanation: DLL would be 3<=>1<=>2
Example 2:

Input:
       10
      /   \
     20   30
   /   \
  40   60
Output:
40 20 60 10 30 
30 10 60 20 40
Explanation:  DLL would be 
40<=>20<=>60<=>10<=>30.
Your Task:
You don't have to take input. Complete the function bToDLL() that takes root node of the tree as a parameter and returns the head of DLL . The driver code prints the DLL both ways.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree and this space is used implicitly for the recursion stack.

Constraints:
1 ≤ Number of nodes ≤ 105
0 ≤ Data of a node ≤ 105




class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    
    private Node head = null;
    private Node previous = null;
    
    Node bToDLL(Node root)
    {
	//  Your code here	
	    if (root == null) {
	        return null;
	    }
	    inorder(root);
	    return head;
    }
    
    private void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (previous == null) {
            head = node;
        }
        else {
            node.left = previous;
            previous.right = node;
        }
        previous = node;
        inorder(node.right);
    }
}