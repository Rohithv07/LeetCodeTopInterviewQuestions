/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // lets do a preorder traversal here
        if (root == null)
            return "X";
        String left = serialize(root.left);
        String right = serialize(root.right);
        // we need the answer in string type and lets use string builder
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        sb.append(left);
        sb.append(",");
        sb.append(right);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // here we need to keep track of the characyer we are standing, so lets use a queue
        Queue<String> queue = new LinkedList<>();
        // now lets add all the string into the queue splitted by ,
        queue.addAll(Arrays.asList(data.split(",")));
        return helper(queue);
    }
    public TreeNode helper(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("X"))
            return null;
        TreeNode newNode = new TreeNode(Integer.valueOf(value));
        newNode.left = helper(queue);
        newNode.right = helper(queue);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
