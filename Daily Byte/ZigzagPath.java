/*
Given the root of a non-empty binary tree, return the length of the longest zigzag path.
Note: A zigzag path is a path that begins at any node in the tree and alternates between moving left and moving right down the tree. It is guaranteed that the root you’re given is not null.

Ex: Given the following root…

       1
     /   \
    3     4
         /
        8, return 2 (right from 1 then left from 4).
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
    public int longestZigZag(TreeNode root) {
        if (root == null)
            return 0;
        int [] maximum = new int [1];
        dfs(root.left, 0, maximum, false);
        dfs(root.right, 0, maximum, true);
        return maximum[0];
    }
    
    public void dfs(TreeNode node, int depth, int [] maximum, boolean leftRight) {
        maximum[0] = Math.max(maximum[0], depth);
        if (node == null)
            return;
        dfs(node.left, leftRight ? depth + 1 : 0, maximum, false);
        dfs(node.right, !leftRight ? depth + 1 : 0, maximum, true);
        
    }
}