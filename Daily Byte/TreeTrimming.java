/*
Given the reference to the root of a binary search tree and two values, low and high, update the tree such that any nodes containing values that are strictly outside low and high are removed.

Ex: Given the following root, low, and high...

root = 1
      / \
     2   3, low = 1, high = 2, return the tree updated as follows...
       1
      /
     2
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
        
        // preorder
        if (root == null)
            return null;
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        if (root.val > high)
            return root.left;
        if (root.val < low)
            return root.right;
        return root;
    }
}
