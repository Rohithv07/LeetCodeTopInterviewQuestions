/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    // we make use of a stack here
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        // first of all we push all the elements to the stack
        pushAllElements(root);
    }
    
    public int next() {
        // pop the top node
        // pushAllElements of right nodes to the stack
        // return the val
        TreeNode node = stack.pop();
        pushAllElements(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        // take the negation of whether the stack is empty or not
        return !stack.isEmpty();
    }
    
    // implement the pushAllElements method
    public void pushAllElements(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;            
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */