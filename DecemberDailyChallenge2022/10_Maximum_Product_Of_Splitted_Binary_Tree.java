Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.

Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.

Note that you need to maximize the answer before taking the mod and not after taking it.

 

Example 1:


Input: root = [1,2,3,4,5,6]
Output: 110
Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
Example 2:


Input: root = [1,null,2,3,4,null,null,5,6]
Output: 90
Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
 

Constraints:

The number of nodes in the tree is in the range [2, 5 * 104].
1 <= Node.val <= 104


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
    private long result = 0;
    private long totalSum = 0;
    public int maxProduct(TreeNode root) {
        if (root == null)
            return 0;
        long mod = (long)1e9 + 7;
        totalSum = dfs(root);
        dfs(root);
        return (int)(result % mod);
    }
    
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int currentSum = dfs(node.left) + dfs(node.right) + node.val;
        result = Math.max(result, (totalSum - currentSum) * currentSum);
        return currentSum;
    }
}