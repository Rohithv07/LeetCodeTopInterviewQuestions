Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

Example 1:

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.
Example 2:

Input: 6 6 3 N 2 9 3 N 8 8 2
            6
        /       \
       6         3
        \      /   \
         2    9     3
          \  /  \
          8 8    2 
Output: 2
Explanation: The following sub-tree is a
BST of size 2: 
       2
    /    \ 
   N      8
Your Task:
You don't need to read input or print anything. Your task is to complete the function largestBst() that takes the root node of the Binary Tree as its input and returns the size of the largest subtree which is also the BST. If the complete Binary Tree is a BST, return the size of the complete Binary Tree. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 106



// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

// https://youtu.be/X0oXMdtUDwo

class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        if (root == null) {
            return 0;
        }
        return findTheLargest(root).size;
    }
    
    static TreeNode findTheLargest(Node node) {
        if (node == null) {
            return new TreeNode(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        TreeNode left = findTheLargest(node.left);
        TreeNode right = findTheLargest(node.right);
        if (left.maxValue < node.data && node.data < right.minValue) {
            // its a bst
            return new TreeNode(Math.min(node.data, left.minValue), Math.max(node.data, right.maxValue), left.size + right.size + 1);
        }
        return new TreeNode(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }
    
}

class TreeNode {
    public int maxValue;
    public int minValue;
    public int size;
    TreeNode(int minValue, int maxValue, int size) {
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.size = size;
    }
}