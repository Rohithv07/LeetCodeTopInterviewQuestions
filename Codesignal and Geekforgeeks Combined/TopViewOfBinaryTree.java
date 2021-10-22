Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Return nodes from leftmost node to rightmost node.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3
Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
Your Task:
Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter and returns a list of nodes visible from the top view from left to right.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 105
1 ≤ Node Data ≤ 105


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> top = new ArrayList<>();
        levelOrder(root, top);
        return top;
    }
    
    static void levelOrder(Node node, ArrayList<Integer> top) {
        if (node == null) {
            return;
        }
        Queue<Pair> queue = new LinkedList<>();
        // key is level and value is the node
        TreeMap<Integer, Node> map = new TreeMap<>();
        queue.offer(new Pair(node, 0));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node currentNode = current.node;
            int currentLevel = current.level;
            if (!map.containsKey(currentLevel)) {
                map.put(currentLevel, currentNode);
            }
            if (currentNode.left != null) {
                queue.offer(new Pair(currentNode.left, currentLevel - 1));
            }
            if (currentNode.right != null) {
                queue.offer(new Pair(currentNode.right, currentLevel + 1));
            }
        }
        for (Integer key : map.keySet()) {
            Node topNodeCandidate = map.get(key);
            top.add(topNodeCandidate.data);
        }
    }
}

class Pair {
    Node node;
    int level;
    Pair(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}