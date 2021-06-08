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
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        int root = preorder[0];
        TreeNode tree = new TreeNode(root);
        // find the index of this root in order
        // all the elements to the left of the root will be left child and to the right will be rightchild in inroder
        int rootIndexInorder = -1;
        for (int i=0; i<inorder.length; i++) {
            if (inorder[i] == root) {
                rootIndexInorder = i;
                break;
            }
        }
        // copy all the elements to an array using Arrays.copyOfRange
        int [] leftChildIn = Arrays.copyOfRange(inorder, 0, rootIndexInorder);
        int [] rightChildIn = Arrays.copyOfRange(inorder, rootIndexInorder+1, inorder.length);
        int [] leftChildPre = Arrays.copyOfRange(preorder, 1, rootIndexInorder + 1);
        int [] rightChildPre = Arrays.copyOfRange(preorder, rootIndexInorder + 1, preorder.length);
        
        tree.left = buildTree(leftChildPre, leftChildIn);
        tree.right = buildTree(rightChildPre, rightChildIn);
        return tree;
    }
}



// another apporach


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
    private int pre = 0;
    private int in = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, Integer.MIN_VALUE);
    }
    
    public TreeNode construct(int [] preorder, int [] inorder, int stop) {
        if (pre >= preorder.length)
            return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = construct(preorder, inorder, node.val);
        node.right = construct(preorder, inorder, stop);
        
        return node;
    }
}
