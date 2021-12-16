Complete the function to find spiral order traversal of a tree. For below tree, function should return 1, 2, 3, 4, 5, 6, 7.


 
 

Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 
Your Task:
The task is to complete the function findSpiral() which takes root node as input parameter and returns the elements in spiral form of level order traversal as a list. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
0 <= Number of nodes <= 105
0 <= Data of a node <= 105




/*
// A Binary Tree node
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

class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code here
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        bfs(root, result);
        return result;
    }
    void bfs(Node node, ArrayList<Integer> result) {
        Queue<Node> queue = new LinkedList<>();
        boolean leftToRight = false;
        // false means right to left, true means left to right
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> currentLevelElements = new ArrayList<>();
            for (int i=0; i<size; i++) {
                Node current = queue.poll();
                currentLevelElements.add(current.data);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (!leftToRight) {
                Collections.reverse(currentLevelElements);
            }
            for (int element : currentLevelElements) {
                result.add(element);
            }
            leftToRight = !leftToRight;
        }
    }
}