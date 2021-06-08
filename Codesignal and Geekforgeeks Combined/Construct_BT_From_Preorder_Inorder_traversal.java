Given 2 Arrays of Inorder and preorder traversal. Construct a tree and print the Postorder traversal. 

Example 1:

Input:
N = 4
inorder[] = {1 6 8 7}
preorder[] = {1 6 7 8}
Output: 8 7 6 1
Example 2:

Input:
N = 6
inorder[] = {3 1 4 0 5 2}
preorder[] = {0 1 3 4 2 5}
Output: 3 4 1 5 2 0
Explanation: The tree will look like
       0
    /     \
   1       2
 /   \    /
3    4   5
Your Task:
Your task is to complete the function buildTree() which takes 3 arguments(inorder traversal array, preorder traversal array, and size of tree n) and returns the root node to the tree constructed. You are not required to print anything and a new line is added automatically (The post order of the returned tree is printed by the driver's code.)

Expected Time Complexity: O(N*N).
Expected Auxiliary Space: O(N).

Constraints:
1<=Number of Nodes<=1000

class Solution
{
     int pre = 0;
     int in = 0;
    public  Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here
        return construct(preorder, inorder, Integer.MIN_VALUE);
    }
    
    public Node construct(int [] preorder, int [] inorder, int stop) {
        if (pre >= preorder.length)
            return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        Node node = new Node(preorder[pre++]);
        node.left = construct(preorder, inorder, node.data);
        node.right = construct(preorder, inorder, stop);
        return node;
    }
}

