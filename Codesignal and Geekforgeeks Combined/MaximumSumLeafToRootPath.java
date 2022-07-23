Given a Binary Tree, find the maximum sum path from a leaf to root.


Example 1:

Input:
        1
       / \
      2   3 
Output:
4
Explanation: 
Following the path 3 -> 1, results in a
sum of 4, which is the maximum path sum
from leaf to root for the given tree.
Example 2:

Input:
       10
      /  \
    -2    7
    / \   
   8  -4    
Output:
17
Explanation : 
Following the path 7 -> 10, results in a
sum of 17, which is the maximum path sum
from leaf to root for the given tree.

Your task :
You don't need to read input or print anything. Your task is to complete the function maxPathSum() which takes the root node of the tree as input and returns an integer denoting the maximum possible leaf to root path sum.

Expected Time Complexity: O(n) , where n = number of nodes
Expected Auxiliary Space: O(1)

Constraints : 
1 <= Number of nodes <= 10^5


//User function Template for Java

class Solution
{
    public static int maxPathSum(Node root)
    {
        //code here
        if (root == null) {
            return 0;
        }
        int [] pathsum = new int [1];
        pathsum[0] = root.data;
        inorder(root, pathsum, 0);
        return pathsum[0];
    }
    
    private static void inorder(Node node, int [] pathsum, int runningSum) {
        if (node == null) {
            pathsum[0] = Math.max(pathsum[0], runningSum);
            return;
        }
        inorder(node.left, pathsum, runningSum + node.data);
        inorder(node.right, pathsum, runningSum + node.data);
    }
}