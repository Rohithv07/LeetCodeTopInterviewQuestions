/*
Given the reference to a binary tree, return the total number of magic nodes in the tree.
Note: A node is magical if no value in the path from the root to the current node is greater than the current node’s value.

Ex: Given the following binary tree…

      1
    /   \
   2     3, return 3 (all nodes are magic nodes)
Ex: Given the following binary tree…

      5
    /   \
   4     9
  / \
 8   7, return 4 (5, 8, 7, and 9 are all magic nodes).
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
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return dfs(root, max);
    }
    
    public int dfs(TreeNode node, int max) {
        if (node == null)
            return 0;
        int result = 0;
        if (node.val >= max) {
            result = 1;
        }
        else {
            result = 0;
        }
        result += dfs(node.left, Math.max(max, node.val));
        result += dfs(node.right, Math.max(max, node.val));
        return result;
    }
}
