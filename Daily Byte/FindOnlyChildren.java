/*
Given the reference to the root of a binary tree, return a list containing all the “only children”’s values. An “only child” is a node that is the sole node under its parent node.
Note: The root node is not be considered an only child.

Ex: Given the following root…

        1
      /   \
     2     4
       \
        7, return [7].
Ex: Given the following root…

        1
      /   \
     2     3 return [].
*/

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

class Tree
{
    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        dfsHelper(node, result);
        if (result.size() != 1)
            result.remove(0);
        // Collections.sort(result);  add this line if we needed the answer in sorted order



        return result;
    }
    
    void dfsHelper(Node node, ArrayList<Integer> result) {
        if (node == null)
            return;
        if (node.left != null && node.right != null) {
            dfsHelper(node.left, result);
            dfsHelper(node.right, result);
        }
        else if (node.left != null) {
            result.add(node.left.data);
            dfsHelper(node.left, result);
        }
        else if (node.right != null) {
            result.add(node.right.data);
            dfsHelper(node.right, result);
        }
    }
}
