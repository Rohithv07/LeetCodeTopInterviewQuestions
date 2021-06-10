Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.

The values smaller than root go to the left side
The values greater and equal to the root go to the right side
Example 1:

Input:
      10
     /  \
    5    50
   /    /  \
  1    40  100
l = 5, h = 45
Output: 3
Explanation: 5 10 40 are the node in the
range
Example 2:

Input:
     5
    /  \
   4    6
  /      \
 3        7
l = 2, h = 8
Output: 5
Explanation: All the nodes are in the
given range.
Your Task:
This is a function problem. You don't have to take input. You are required to complete the function getCountOfNode() that takes root, l ,h as parameters and returns the count.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes <= 100
1 <= l < h < 103


// approach 1 

class Tree
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int low, int high)
    {
        //Your code here
        if (root == null)
            return 0;
        if (root.data < low)
            return getCount(root.right, low, high);
        if (root.data > high)
            return getCount(root.left, low, high);
        return 1 + getCount(root.left, low, high) + getCount(root.right, low, high);
    }
}



// approach 2 - preorder

class Tree
{
    private int count = 0;
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        //Your code here
        if (root == null)
            return 0;
        return dfsHelper(root, l, h);
    }
    
    int dfsHelper(Node node, int low, int high) {
        if (node == null)
            return 0;
        if (node.data >= low && node.data <= high) {
            count += 1;
        }
        dfsHelper(node.left, low, high);
        dfsHelper(node.right, low, high);
        return count;
    }
}



