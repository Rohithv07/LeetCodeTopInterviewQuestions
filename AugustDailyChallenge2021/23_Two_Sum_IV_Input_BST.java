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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        Set<Integer> complement = new HashSet<>();
        return dfs(root, k, complement);
    }
    
    public boolean dfs(TreeNode node, int target, Set<Integer> complement) {
        if (node == null)
            return false;
        if (complement.contains(target - node.val))
            return true;
        complement.add(node.val);
        return dfs(node.left, target, complement) || dfs(node.right, target, complement);
    }
}