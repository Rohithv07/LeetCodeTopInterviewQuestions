Given an n-ary tree, return a list containing the post order traversal of the tree. Write your solution iteratively.

Ex: Given the following n-ary tree...

        1
      / | \
     2  3  4, return [2, 3, 4, 1]



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
    List<Integer> postOrder = new ArrayList<>(); - this is used for recursive - dont get confused
    public List<Integer> postorder(Node root) {
        List<Integer> postOrder = new ArrayList<>();
        if (root == null)
            return postOrder;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            postOrder.add(current.val);
            for (Node child : current.children) {
                stack.push(child);
            }
        }
        Collections.reverse(postOrder);
        return postOrder;
        
        // recursive
        if (root == null)
            return postOrder;
        for (Node node : root.children) {
            postorder(node);
        }
        postOrder.add(root.val);
        return postOrder;
    }
}
