Given an array of size N containing level order traversal of a BST. The task is to complete the function constructBst(), that construct the BST (Binary Search Tree) from its given level order traversal.

Example 1:

Input:
N = 9
BST[] = {7,4,12,3,6,8,1,5,10}
Output: 7 4 3 1 6 5 12 8 10
Explanation: After constructing BST, the
preorder traversal of BST is
7 4 3 1 6 5 12 8 10.
Example 2:

Input:
N = 6
BST[] = {1,3,4,6,7,8}
Output: 1 3 4 6 7 8
Explanation: After constructing BST, the
preorder traversal of BST is 1 3 4 6 7 8.
Your Task:
Your task is to complete the function constructBst() which has two arguments, first as the array containing level order traversal of BST and next argument as the length of array which return the root of the newly constructed BST. The preorder traversal of the tree is printed by the driver's code.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103





// O(n ^ 2) solution
class GFG 
{
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        //Write your code here 
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node root = null;
        for (int number : arr) {
            root = build(root, number);
        }
        return root;
    }
    
    private Node build(Node node, int element) {
        if (node == null) {
            node = new Node(element);
            return node;
        }
        if (node.data <= element) {
            node.right = build(node.right, element);
        }
        else {
            node.left = build(node.left, element);
        }
        return node;
    }
}


// O(n) approach

class GFG 
{
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        //Write your code here 
        if (arr == null) {
            return null;
        }
        Node root = new Node(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(new TreeNode(root));
        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (i < arr.length && arr[i] < current.node.data && arr[i] > current.min) {
                current.node.left = new Node(arr[i]);
                TreeNode newTreeNode = new TreeNode(current.node.left);
                newTreeNode.min = current.min;
                newTreeNode.max = current.node.data;
                queue.offer(newTreeNode);
                i++;
            }
            if (i < arr.length && arr[i] > current.node.data && arr[i] < current.max) {
                current.node.right = new Node(arr[i]);
                TreeNode newTreeNode = new TreeNode(current.node.right);
                newTreeNode.min = current.node.data;
                newTreeNode.max = current.max;
                queue.offer(newTreeNode);
                i++;
            }
        }
        return root;
        
    }
}

class TreeNode {
    Node node;
    int max;
    int min;
    public TreeNode(Node node) {
        this.node = node;
        this.max = Integer.MAX_VALUE;
        this.min = Integer.MIN_VALUE;
    }
}