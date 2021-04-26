/*
Given a binary tree, invert it and return the resulting tree.

Ex: Given the following binary tree…

        1
       /  \
      2    3, return...
         1
        /  \
       3    2
Ex: Given the following binary tree…

        1
       /  \
      2     3
     / \   /  \
    4   5 6    7, return...
         1
        /  \
       3     2
     /   \  /  \
    7    6 5    4 
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
        
    }
}
