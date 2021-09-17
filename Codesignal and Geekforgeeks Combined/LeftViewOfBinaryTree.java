Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8   

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3

Example 2:

Input:

Output: 10 20 40
Your Task:
You just have to complete the function leftView() that prints the left view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
0 <= Number of nodes <= 100
1 <= Data of a node <= 1000





//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        // using level order
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Node currentNode = queue.poll();
                if (i == 0) {
                    result.add(currentNode.data);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }
    
    // using recursion
    private int maxLevelFound = 0;
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      if (root == null) {
          return new ArrayList<>();
      }
      ArrayList<Integer> result = new ArrayList<>();
      preorder(root, result, 1);
      return result;
    }
    
    private void preorder(Node node, ArrayList<Integer> result, int currentLevel) {
        if (node == null) {
            return;
        }
        if (currentLevel > maxLevelFound) {
            result.add(node.data);
            maxLevelFound = currentLevel;
        }
        preorder(node.left, result, currentLevel + 1);
        preorder(node.right, result, currentLevel + 1);
    }
    
    
}