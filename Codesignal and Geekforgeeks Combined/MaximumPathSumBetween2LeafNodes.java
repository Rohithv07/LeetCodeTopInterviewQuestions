Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another leaf node.

NOTE: Here Leaf node is a node which is connected to exactly one different node.
Example 1:

Input :      
           3                               
         /    \                          
       4       5                     
      /  \      
    -10   4                          
Output: 16
Explanation :
Maximum Sum lies between leaf node 4 and 5.
4 + 4 + 3 + 5 = 16.
Example 2:

Input :    
            -15                               
         /      \                          
        5         6                      
      /  \       / \
    -8    1     3   9
   /  \              \
  2   -3              0
                     / \
                    4  -1
                       /
                     10  
Output :  27
Explanation:
The maximum possible sum from one leaf node 
to another is (3 + 6 + 9 + 0 + -1 + 10 = 27)

Your Task:  
You dont need to read input or print anything. Complete the function maxPathSum() which takes root node as input parameter and returns the maximum sum between 2 leaf nodes.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of Tree)


Constraints:
2  ≤  Number of nodes  ≤  104
-103  ≤ Value of each node ≤ 103



/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Tree
{
    int maxSum = Integer.MIN_VALUE;
    Node temp = null;
    int maxPathSum(Node root)
    { 
        temp = root;
        int sum = helper(root);
        if (maxSum == Integer.MIN_VALUE) {
            maxSum = sum;
        }
        return maxSum;
        // code here 
    } 
    int helper(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return node.data;
        if (node.right == null)
            return node.data + helper(node.left);
        if (node.left == null)
            return node.data + helper(node.right);
        int leftSum = helper(node.left);
        int rightSum = helper(node.right);
        int sum = leftSum + rightSum + node.data;
        if (sum > maxSum) {
            maxSum = sum;
        }
        int temp = 0;
        if (leftSum >= rightSum) {
            return leftSum + node.data;
        }
        return rightSum + node.data;
    }
}
