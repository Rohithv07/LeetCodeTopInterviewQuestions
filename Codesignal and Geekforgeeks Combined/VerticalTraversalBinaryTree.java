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



class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(new TreeNode(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                int d = node.d;
                if (d < min) {
                    min = d;
                }
                if (d > max) {
                    max = d;
                }
                Node n = node.node;
                if (map.containsKey(d)) {
                    map.get(d).add(n.data);
                }
                else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(n.data);
                    map.put(d, list);
                }
                if (n.left != null) {
                    queue.offer(new TreeNode(n.left, d - 1));
                }
                if (n.right != null) {
                    queue.offer(new TreeNode(n.right, d + 1));
                }
            }
        }
        for (int i=min; i<=max; i++) {
            if (map.containsKey(i)) {
                result.addAll(map.get(i));
            }
        }
        return result;
    }
}

class TreeNode {
    Node node;
    int d;
    TreeNode (Node node, int d) {
        this.node = node;
        this.d = d;
    }
}