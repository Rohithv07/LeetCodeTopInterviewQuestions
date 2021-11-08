Given a binary tree and an integer X. Your task is to complete the function countSubtreesWithSumX() that returns the count of the number of subtress having total node’s data sum equal to the value X.
Example: For the tree given below:            

              5
            /    \
        -10     3
        /    \    /  \
      9     8  -4 7

Subtree with sum 7:
             -10
            /      \
          9        8

and one node 7.

Example 1:

Input:
       5
    /    \
  -10     3
 /   \   /  \
 9   8 -4    7
X = 7
Output: 2
Explanation: Subtrees with sum 7 are
[9, 8, -10] and [7] (refer the example
in the problem description).
Example 2:

Input:
    1
  /  \
 2    3
X = 5
Output: 0
Explanation: No subtree has sum equal
to 5.
Your Task:
You don't need to read input or print anything. Your task is to complete the function countSubtreesWithSumX() which takes the root node and an integer X as inputs and returns the number of subtrees of the given Binary Tree having sum exactly equal to X.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= N <= 103
-103 <= Node Value <= 103


//User function Template for Java


/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/


class Tree
{
    //Function to count number of subtrees having sum equal to given sum.
    private int count = 0;
    int countSubtreesWithSumX(Node root, int x)
    {
	//Add your code here.
	    if (root == null) {
	        return 0;
	    }
	    dfs(root, x);
	    return count;
    }
    
    int dfs(Node node, int x) {
        if (node == null) {
            return 0;
        }
        int sum = node.data + dfs(node.left, x) + dfs(node.right, x);
        if (sum == x) {
            count++;
        }
        return sum;
    }
}

