Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
Note: It is guaranteed than the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original linked list.
 
Example 1:
Input:
       10
     /    \
    5      8
   / \
  2   20
Output: 1
Explanation:
 
Example 2:

Input:
         11
       /    \
      3      17
       \    /
        4  10
Output: 1 
Explanation: 
By swapping nodes 11 and 10, the BST 
can be fixed.
Your Task:
You don't need to take any input. Just complete the function correctBst() that takes root node as parameter. The function should not return anything, all the changes must be done in the existing tree only. BST will then be checked by driver code and 0 or 1 will be printed.

Expected Time Complexity : O(n)
Expected Auxiliary Space : O(1)
 
Constraints:
1 <= Number of nodes <= 1000


class Sol
{
    //Function to fix a given BST where two nodes are swapped.  
    Node previous = null;
        Node first = null;
        Node second = null;
    public Node correctBST(Node root)
    {
        //code here.
        if (root == null)
            return null;
        findSwappedNode(root);
        swap(first, second);
        return root;
    }
    
    public void findSwappedNode(Node root) {
        if (root == null)
            return;
        findSwappedNode(root.left);
        if (previous != null && root.data < previous.data) {
            if (first == null) {
                first = previous;
            }
            second = root;
        }
        previous = root;
        findSwappedNode(root.right);
    }
    
    public void swap(Node node1, Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
}