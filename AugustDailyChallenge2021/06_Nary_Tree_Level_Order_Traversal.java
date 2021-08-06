Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 

Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 104]


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return new ArrayList<>();
        // bfs
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentList = new ArrayList<>();
            for (int i=0; i<size; i++) {
                Node current = queue.poll();
                currentList.add(current.val);
                queue.addAll(current.children);
            }
            result.add(currentList);
        }
        return result;
        
        // dfs
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, 0);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, Node node, int depth) {
        if (node == null)
            return;
        if (result.size() <= depth) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(node.val);
        for (Node child : node.children) {
            dfs(result, child, depth + 1);
        }
    }
}