Given a binary tree. The task is to find subtree with maximum sum in the tree and return its sum.

Example 1:

Input:
              1
            /   \
           2      3
          / \    / \
         4   5  6   7
Output: 28
Explanation: 
As all the tree elements are positive,
the largest subtree sum is equal to
sum of all tree elements.

Example 2:
Input:
               1
            /    \
          -2      3
          / \    /  \
         4   5  -6   2
Output: 7
Explanation: 
Subtree with largest sum is : 
  -2
 /  \ 
4    5
Also, entire tree sum is also 7.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function findLargestSubtreeSum() which takes the root of a binary tree and returns an integer.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 10^5
-10^3 <= tree.val <= 10^3


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static int findLargestSubtreeSum(Node root) {
        // code here
        if (root == null) {
            return 0;
        }
        int [] result = new int [1];
        findMaxSum(root, result);
        return result[0];
    }
    
    private static int findMaxSum(Node node, int [] result) {
        if (node == null) {
            return 0;
        }
        int left = findMaxSum(node.left, result);
        int right = findMaxSum(node.right, result);
        result[0] = Math.max(result[0], left + right + node.data);
        return left + right + node.data;
    }
}
        
