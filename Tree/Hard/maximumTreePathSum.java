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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        dfsHelper(root);
        return result;
    }
    public int dfsHelper(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(dfsHelper(node.left), 0);
        int right = Math.max(dfsHelper(node.right), 0);
        result = Math.max(result, left+right+node.val);
        return Math.max(left, right) + node.val;
    }
}
