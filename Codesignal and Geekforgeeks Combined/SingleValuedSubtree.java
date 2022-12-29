Given a binary tree, count the number of Single Valued Subtrees. A Single Valued Subtree is one in which all the nodes have same value. 

Example 1

Input :
              5
             / \
            1   5
           / \   \
          5   5   5
Output : 4
Explanation : 
There are 4 subtrees with single values.
Example 2:

Input:
              5
             / \
            4   5
           / \   \
          4   4   5   
Output: 5
Explanation: 
There are five subtrees with single values.
Your task :
You don't have to read input or print anything. Your task is to complete the function singlevalued() which takes the root of the tree as input and returns the count of single valued subtrees.
 
Expected Time Complexity : O(n)
Expected Auxiliary Space : O(n)
 
Constraints :
1 <= n <= 10^5


//User function Template for Java

/*class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/

class Solution
{
    public int singlevalued(Node root)
    {
        //code here
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int [] result = new int [1];
        isSubtreeSingle(root, result);
        return result[0];
    }
    
    private boolean isSubtreeSingle(Node node, int [] result) {
        if (node == null) {
            return true;
        }
        boolean isLeftSingle = isSubtreeSingle(node.left, result);
        boolean isRightSingle = isSubtreeSingle(node.right, result);
        // inorder to have single valued subtree, both left and right have to be true
        if (!isLeftSingle || !isRightSingle) {
            return false;
        }
        // we have to make sure the values are same, ie single value
        if (node.left != null && node.data != node.left.data) {
            return false;
        }
        if (node.right != null && node.data != node.right.data) {
            return false;
        }
        // we are sure the subtree is single valued, increment counter and return true;
        result[0]++;
        return true;
    }
}