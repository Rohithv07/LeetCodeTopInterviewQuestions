The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9./**
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
    public int rob(TreeNode root) {
        int [] maximumMoney = dfsHelper(root);
        return Math.max(maximumMoney[0], maximumMoney[1]);
    }
    public int [] dfsHelper(TreeNode node) {
        if (node == null)
            return new int [2];
        // left child
        int [] left = dfsHelper(node.left);
        int [] right = dfsHelper(node.right);
        int [] maximumMoney = new int [2];
        maximumMoney[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        maximumMoney[1] = node.val + left[0] + right[0];
        return maximumMoney;
    }
}
