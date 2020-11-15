Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].

 

Example 1:


Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Example 2:


Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
 



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
    public int rangeSumBST(TreeNode root, int low, int high) {
        // we can do bfs here
        if (root == null)
            return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int value = current.val;
            if (value >= low && value <= high) {
                sum += value;
            }
            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);
        }
        return sum;

        
        // dfs is also appplicable
        if (root == null)
            return 0;
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
