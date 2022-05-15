Given the root of a binary tree, return the sum of values of its deepest leaves.
 

Example 1:


Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100

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
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxHeight = findHeight(root);
        int [] sum = new int [1];
        inorder(root, maxHeight, 1, sum);
        return sum[0];
    }
    
    private int findHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = findHeight(node.left);
        int right = findHeight(node.right);
        return 1 + Math.max(left, right);
    }
    
    private void inorder(TreeNode node, int maxHeight, int currentHeight, int [] sum) {
        if (node == null) {
            return;
        }
        inorder(node.left, maxHeight, currentHeight + 1, sum);
        if (currentHeight == maxHeight) {
            sum[0] += node.val;
        }
        inorder(node.right, maxHeight, currentHeight + 1, sum);
    }
}


// same concept but only one dfs function

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