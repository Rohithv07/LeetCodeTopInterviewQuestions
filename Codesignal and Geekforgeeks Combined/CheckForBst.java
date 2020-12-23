Given a binary tree. Check whether it is a BST or not.

Example 1:

Input:
    2
 /    \
1      3
Output: 1
Example 2:

Input:
  2
   \
    7
     \
      6
       \
        5
         \
          9
           \
            2
             \
              6
Output: 0
Your Task:
You don't need to read input or print anything. Your task is to complete the function isBST() which takes the root of the tree as a parameter and returns true if the given binary tree is BST, else returns false. The printing is done by the driver's code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
0 <= Number of edges <= 100000


/*
Structure of Node:
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

public class Tree
{
    // return true if the given tree is a BST, else return false
    boolean isBST(Node root)
        {
            // code here
            if (root == null)
                return true;
            return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        
    boolean check(Node node, long min, long max) {
        if (node == null)
            return true;
        if (node.data <= min || node.data > max)
            return false;
        return check(node.left, min, node.data) && check(node.right, node.data, max);
        
        
        
        
        
    
    }
}
