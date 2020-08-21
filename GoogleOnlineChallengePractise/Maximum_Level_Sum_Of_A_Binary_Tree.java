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
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList();
        int minimumSum = -Integer.MIN_VALUE;
        int level = 0;
        int resultantLevel = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int sizeOfQueue = queue.size();
            int currentLevelSum = 0;
            level += 1;
            for (int i=0; i<sizeOfQueue; i++) {
                TreeNode temporary = queue.poll();
                currentLevelSum += temporary.val;
                if (temporary.left != null)
                    queue.add(temporary.left);
                if (temporary.right != null)
                    queue.add(temporary.right);
            }
            if (minimumSum < currentLevelSum){
                minimumSum = currentLevelSum;
                resultantLevel = level;
            }
        }
        return resultantLevel;
    }
}
