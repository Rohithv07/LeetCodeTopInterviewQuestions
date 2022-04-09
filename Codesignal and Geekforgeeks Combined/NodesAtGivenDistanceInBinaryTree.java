Given a binary tree, a target node in the binary tree, and an integer value k, find all the nodes that are at distance k from the given target node. No parent pointers are available.

Example 1:

Input:      
          20
        /    \
      8       22 
    /   \
   4    12 
       /   \
      10    14
Target Node = 8
K = 2
Output: 10 14 22
Explanation: The three nodes at distance 2
from node 8 are 10, 14, 22.

Example 2:

Input:      
         20
       /    \
      7      24
    /   \
   4     3
        /  
       1    
Target Node = 7
K = 2
Output: 1 24
Your Task:  
You don't need to read input or print anything. Complete the function KDistanceNodes() which takes the root of the tree, target, and K as input parameters and returns a list of nodes at k distance from target in a sorted order.


Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(Height of tree)


Constraints:
1 ≤ N ≤ 103
1 ≤ data of node ≤ 104
1 ≤ target ≤ 104
1 ≤ k ≤ 20


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    private static Node targetNode;
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        targetNode = null;
        Map<Node, Node> nodeToParent = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        fillTheNodeToParent(root, null, target, nodeToParent);
        fillTheResult(targetNode, k, 0, visited, nodeToParent, result);
        Collections.sort(result);
        return result;
    }
    
    private static void fillTheNodeToParent(Node node, Node parent, int target, Map<Node, Node> nodeToParent) {
        if (node == null) {
            return;
        }
        if (node.data == target) {
            targetNode = node;
        }
        nodeToParent.put(node, parent);
        fillTheNodeToParent(node.left, node, target, nodeToParent);
        fillTheNodeToParent(node.right, node, target, nodeToParent);
    }
    
    private static void fillTheResult(Node node, int k, int currentK, Set<Node> visited, Map<Node, Node> nodeToParent, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        if (currentK > k) {
            return;
        }
        if (visited.contains(node)) {
            return;
        }
        if (currentK == k) {
            result.add(node.data);
        }
        visited.add(node);
        fillTheResult(node.left, k, currentK + 1, visited, nodeToParent, result);
        fillTheResult(node.right, k, currentK + 1, visited, nodeToParent, result);
        fillTheResult(nodeToParent.get(node), k, currentK + 1, visited, nodeToParent, result);
    }
}