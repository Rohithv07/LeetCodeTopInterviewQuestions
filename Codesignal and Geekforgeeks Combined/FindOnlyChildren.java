Given a Binary Tree of size N, find all the nodes which don't have any sibling. Root node can not have a sibling.

Example 1:

Input :
       37
      /   
    20
    /     
  113 

Output: 20 113
Explanation: 20 and 113 dont have any siblings.

Example 2:

Input :
       1
      / \
     2   3 

Output: -1
Explanation: Every node has a sibling.

Your Task:  
You dont need to read input or print anything. Complete the function noSibling() which takes the root of the tree as input parameter and returns a list of integers containing all the nodes that don't have a sibling in sorted order. If all nodes have a sibling, then the returning list should contain only one element -1.


Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(Height of the tree)


Constraints:
1 ≤ N ≤ 10^4
All nodes have distinct values.







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
        Collections.sort(result);
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
