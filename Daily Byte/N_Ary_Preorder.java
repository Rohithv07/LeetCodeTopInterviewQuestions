/*
Given an N-ary tree, return a list containing the preorder traversal of its elements.
Note: You may assume that each node in the tree has a children attribute to access all of its N child nodes.

Ex: Given the following N-ary tree…

       1
     / | \
    2  3  4, return [1, 2, 3, 4].
Ex: Given the following N-ary tree…

       1
     /   \
    2     3 
        / | \
       4  7  9, return [1, 2, 3, 4, 7, 9].
*/


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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.val);
            int size = current.children.size();
            for (int i = size - 1; i>=0; i--) {
                stack.push(current.children.get(i));
            }
        }
        return result;
    }
}
