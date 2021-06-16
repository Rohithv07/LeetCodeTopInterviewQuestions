/*
Given the reference to the root of a binary tree, return the sum of all leaves at the deepest level.

Ex: Given the following tree…

      2
     / \
    4   5, return 9 (4 and 5 are at the deepest level and sum to 9).
Ex: Given the following tree…

      1
       \
        2
         \
          3, return 3.
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
    private int sum = 0;
    private int depth = 0;
    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;
        dfsTraversal(root, 0);
        return sum;
    }
    
    public void dfsTraversal(TreeNode node, int currentLevel) {
        if (node == null)
            return;
        if (currentLevel > depth) {
            depth = currentLevel;
            sum = 0;
        }
        if (currentLevel == depth) {
            sum += node.val;
        }
        dfsTraversal(node.left, currentLevel + 1);
        dfsTraversal(node.right, currentLevel + 1);
    }
}

// otherwise find the depth, do bfs and only update sum at the depth level
