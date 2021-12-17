Given a Binary Tree, you need to find the maximum value which you can get by subtracting the value of node B from the value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B. 

Example 1:

Input:
    5
 /    \
2      1
Output: 4
Explanation:The maximum difference we can
get is 4, which is bewteen 5 and 1.
Example 2:

Input:
      1
    /    \
   2      3
           \
            7
Output: -1
Explanation:The maximum difference we can
get is -1, which is between 1 and 2.
Your Task:
The task is to complete the function maxDiff() which finds the maximum difference between the node and its ancestor.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree.

Constraints:
1 <= Number of edges <= 104
0 <= Data of a node <= 105



//User function Template for Java

//Back-end complete function Template for Java

/*
class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree
{
    //Function to return the maximum difference between any 
    //node and its ancestor.
    int maxDiff(Node root)
    {
        //your code here
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int [] maxDiff = new int [] {Integer.MIN_VALUE};
        dfs(root, maxDiff);
        return maxDiff[0];
    }
    
    int dfs(Node root, int [] maxDiff) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        // conditions for leaf
        if (root.left == null && root.right == null) {
            return root.data;
        }
        int left = dfs(root.left, maxDiff);
        int right = dfs(root.right , maxDiff);
        int minimum = Math.min(left, right);
        maxDiff[0] = Math.max(maxDiff[0], root.data - minimum);
        return Math.min(minimum, root.data);
    }
}

