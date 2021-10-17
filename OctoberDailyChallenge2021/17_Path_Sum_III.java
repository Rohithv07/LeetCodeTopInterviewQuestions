Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

Example 1:


Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000


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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int [] count = new int [1];
        map.put(0, 1);
        dfsHelper(root, 0, targetSum, count, map);
        return count[0];
    }
    
    public void dfsHelper(TreeNode node, int currentSum, int targetSum, int [] count, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        currentSum += node.val;
        if (map.containsKey(currentSum - targetSum)) {
            count[0] += map.get(currentSum - targetSum);
        }
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        dfsHelper(node.left, currentSum, targetSum, count, map);
        dfsHelper(node.right, currentSum, targetSum, count, map);
        map.put(currentSum, map.get(currentSum) - 1);
    }
}