/*
Given the reference to the root of a binary tree, and a target value, remove all the leaf nodes that contain the target and return the modified tree.
Note: If you remove a leaf node that contains the target value and the parent node now becomes a leaf with a value of target, you must remove the parent as well.

Ex: Given the following binary tree and target…

      1
     / \
    2   3
   /
  2, target = 2, return the tree modified as follows...
       1
        \
         3
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

// post order - left -> right -> root
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target)
            return null;
        return root;
    }
}
