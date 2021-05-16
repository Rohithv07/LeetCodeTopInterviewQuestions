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
    private int result = 0;
    private Set<TreeNode> trackParent;
    public int minCameraCover(TreeNode root) {
        if (root == null)
            return 0;
        trackParent = new HashSet<>();
        trackParent.add(null);
        dfs(root, null);
        return result;
    }
    
    public void dfs(TreeNode node, TreeNode parent) {
        if (node == null)
            return;
        dfs(node.left, node);
        dfs(node.right, node);
        if (parent == null && !trackParent.contains(node) || !trackParent.contains(node.left) || !trackParent.contains(node.right)) {
            trackParent.add(node);
            trackParent.add(node.left);
            trackParent.add(node.right);
            trackParent.add(parent);
            result += 1;
        }
    }
}
