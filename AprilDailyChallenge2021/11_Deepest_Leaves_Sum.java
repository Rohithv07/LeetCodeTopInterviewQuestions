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
	// using just recursion
        if (root == null)
            return 0;
        int [] deepest = new int [] {0};
        int [] sum = new int [] {0};
        dfsHelper(root, 0, deepest, sum);
        return sum[0];
    }
    
    public void dfsHelper(TreeNode node, int currentLevel, int [] deepest, int [] sum) {
        if (node == null)
            return;
        if (currentLevel > deepest[0]) {
            deepest[0] = currentLevel;
            sum[0] = 0;
        }
        if (currentLevel == deepest[0]) {
            sum[0] += node.val;
        }
        dfsHelper(node.left, currentLevel + 1, deepest, sum);
        dfsHelper(node.right, currentLevel + 1, deepest, sum);
    }
    
    
      //  this is mix of dfs and bfs
        if (root == null)
            return 0;
        int height = findHeight(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;
        int sum = 0;
        while (!queue.isEmpty()) {
            currentLevel += 1;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                if (currentLevel == height) {
                    sum += current.val;
                }
                else {
                    if (current.left != null)
                        queue.add(current.left);
                    if (current.right != null)
                        queue.add(current.right);
                }
            }
        }
        return sum;
    }
    
    public int findHeight(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }
    
}



