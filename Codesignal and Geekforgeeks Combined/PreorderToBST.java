Given an array arr[] of N nodes representing preorder traversal of some BST. You have to build the exact BST from it's given preorder traversal. 
In Pre-Order traversal, the root node is visited before the left child and right child nodes.

Example 1:

Input:
N = 5
arr[]  = {40,30,35,80,100}
Output: 35 30 100 80 40
Explanation: PreOrder: 40 30 35 80 100
InOrder: 30 35 40 80 100
Therefore, the BST will be:
              40
           /      \
         30       80
           \        \   
           35      100
Hence, the postOrder traversal will
be: 35 30 100 80 40
Example 2:

Input:
N = 8
arr[]  = {40,30,32,35,80,90,100,120}
Output: 35 32 30 120 100 90 80 40
Your Task:
You need to complete the given function and return the root of the tree. The driver code will then use this root to print the post order traversal.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103
1 <= arr[i] <= 104


//Function that constructs BST from its preorder traversal.
public static Node post_order(int pre[], int size) 
{
    //Your code here
    if (pre == null || size == 0) {
        return null;
    }
    Node root = new Node(pre[0]);
    for (int i = 1; i < size; i++) {
        buildBST(root, pre[i]);
    }
    return root;
} 

private static Node buildBST(Node node, int key) {
    if (node == null) {
        return new Node(key);
    }
    if (node.data < key) {
        node.right = buildBST(node.right, key);
    }
    else {
        node.left = buildBST(node.left, key);
    }
    return node;
}