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
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set);
    }
    
    public int dfs(TreeNode node, Set<Integer> set) {
        if (node == null)
            return 0;
        if (set.contains(node.val))
            set.remove(node.val);
        else
            set.add(node.val);
        int count = 0;
        if (node.left == null && node.right == null && set.size() <= 1)
            count += 1;
        count += dfs(node.left, new HashSet<>(set)) + dfs(node.right, new HashSet<>(set));
        return count;
    }
}


// optimised solution
class Solution {
    int count = 0;
        
    public void preorder(TreeNode node, int path) {
        if (node != null) {
            // compute occurences of each digit 
            // in the corresponding register
            path = path ^ (1 << node.val);
            // if it's a leaf check if the path is pseudo-palindromic
            if (node.left == null && node.right == null) {
                // check if at most one digit has an odd frequency
                if ((path & (path - 1)) == 0) {
                    ++count;
                }
            }
            preorder(node.left, path);
            preorder(node.right, path) ;
        }
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        preorder(root, 0);
        return count;
    }
}
