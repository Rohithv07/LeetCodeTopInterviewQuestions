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

/* 
Here there are 4 possibilities
1. No left child, then return right
2. No right child, return left
3. No right, No left, return null
4. Both left and right, then find minimum from right, moves it into current, then recursively delete minimum value
*/
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val > key)
            root.left = deleteNode(root.left, key);
        else if (root.val < key)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            TreeNode minimum = findMinimum(root.right);
            root.val = minimum.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    public TreeNode findMinimum(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
}
