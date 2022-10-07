Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:
1.Search for a node to remove.
2.If the node is found, delete the node.
  
 Example :

Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
  
   /*Code of this problem.*/
  
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
    TreeNode findMin(TreeNode root,TreeNode mini){
        if(root==null)
            return mini;
        
        while(root!=null){
            mini = root;
            root = root.left;
        }
        return mini;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        
        if(root.val==key){
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }else{
                TreeNode mini = null;
                mini = findMin(root.right,mini);
                root.val = mini.val;
                root.right = deleteNode(root.right,root.val);
            }
        }
        
        root.left = deleteNode(root.left,key);
        root.right = deleteNode(root.right,key);
        return root;
    }
}
