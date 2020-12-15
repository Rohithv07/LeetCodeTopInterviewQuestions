This question is asked by Amazon. Given two trees s and t return whether or not t is a subtree of s.
Note: For t to be a subtree of s not only must each node’s value in t match its corresponding node’s value in s, but t must also exhibit the exact same structure as s. You may assume both trees s and t exist.

Ex: Given the following trees s and t…

s = 1
   / \
  3   8
t = 1
     \
      8
return false

Ex: Given the following trees s and t…

s = 7
   / \
  8   3
t = 7
   / \
  8   3
return true

Ex: Given the following trees s and t…

s = 7
   / \
  8   3
t = 7
   / \
  8   3
     /
    1
return false



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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (isSameHelper(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean isSameHelper(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;
        return isSameHelper(s.left, t.left) && isSameHelper(s.right, t.right);
    }
}
