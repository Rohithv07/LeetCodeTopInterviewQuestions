Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.



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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return constructTree(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    public TreeNode constructTree(int preIndex, int inStart, int inEnd, int [] preorder, int [] inorder) {
        if (preIndex >= preorder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int rootInInorder = -1;
        for (int i=inStart; i<=inEnd; i++) {
            if (preorder[preIndex] == inorder[i]) {
                rootInInorder = i;
                break;
            }
        }
        root.left = constructTree(preIndex+1, inStart, rootInInorder - 1, preorder, inorder);
        root.right = constructTree(preIndex + rootInInorder - inStart + 1, rootInInorder + 1, inEnd, preorder, inorder);
        return root;
    }
}