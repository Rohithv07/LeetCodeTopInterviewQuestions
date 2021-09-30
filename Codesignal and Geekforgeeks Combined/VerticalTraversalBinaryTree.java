Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

Example 1:

Input:
           1
         /   \
       2       3
     /   \   /   \
   4      5 6      7
              \      \
               8      9           
Output: 
4 2 1 5 6 3 8 7 9 
Explanation:

Example 2:

Input:
       1
    /    \
   2       3
 /    \      \
4      5      6
Output: 4 2 1 5 3 6
Your Task:
You don't need to read input or print anything. Your task is to complete the function verticalOrder() which takes the root node as input parameter and returns an array containing the vertical order traversal of the tree from the leftmost to the rightmost level. If 2 nodes lie in the same vertical level, they should be printed in the order they appear in the level order traversal of the tree.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= Number of nodes <= 3*104



//User function Template for Java


class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        if (root == null)
            return new ArrayList<>();
        // let roots position be at 0
        // so to the left most it goes like -1, -2, -3 .....
        // so to the right most it goes like 1, 2, 3, .....
        // so we need those nodes at the respective distance from the very minimum to the very maximum
        // make use of hashmap to store the distance and the respective nodes containing at that distance
        // after proper storing store everything from the very minimum to the very maximum in an array lsut
        // the traversal we need to use is level order
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int veryMinimum = 0;
        int veryMaximum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(new TreeNode(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode currentNode = queue.poll();
                Node current = currentNode.node;
                int distance = currentNode.distance;
                if (distance < veryMinimum) {
                    veryMinimum = distance;
                }
                if (distance > veryMaximum) {
                    veryMaximum = distance;
                }
                if (map.containsKey(distance)) {
                    map.get(distance).add(current.data);
                }
                else {
                    map.put(distance, new ArrayList<>());
                    map.get(distance).add(current.data);
                }
                if (current.left != null) {
                    queue.offer(new TreeNode(current.left, distance - 1));
                }
                if (current.right != null) {
                    queue.offer(new TreeNode(current.right, distance + 1));
                }
            }
        }
        for (int i=veryMinimum; i<=veryMaximum; i++) {
            result.addAll(map.get(i));
        }
        return result;
    }
}

class TreeNode {
    Node node;
    int distance;
    TreeNode(Node node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}