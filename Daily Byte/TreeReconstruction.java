/*
Given two integer arrays, preorder and inorder, that represent the preorder and inorder traversal of the same binary tree respectively, construct and return the binary tree that they represent.
Note: Both preorder and inorder consist of unique values.

Ex: Given the following preorder and inorder…

preorder = [1, 2, 3], inorder = [2, 1, 3], return the reference to a binary tree that looks as follows...
        1
      /   \
     2     3
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
    private int pre = 0;
    private int in = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        return constructTree(preorder, inorder, Integer.MIN_VALUE);
    }
    
    public TreeNode constructTree(int [] preorder, int [] inorder, int value) {
        if (pre >= preorder.length) {
            return null;
        }
        if (inorder[in] == value) {
            in++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre++]);
        root.left = constructTree(preorder, inorder, root.val);
        root.right = constructTree(preorder, inorder, value);
        return root;
    }
}