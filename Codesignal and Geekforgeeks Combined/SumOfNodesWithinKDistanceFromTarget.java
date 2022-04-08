Geek is at the geek summer carnival. To unlock discounts on exclusive courses he is given a card with a binary tree, a target node and a positive integer k on it. 
He needs to find the sum of all nodes within a max distance k from target node such that the target node is included in sum.

Example 1:

Input:
target = 9 
k = 1
Binary Tree = 
            1
           /  \
          2    9
        /     /  \
       4     5    7
      /  \       /  \
     8    19    20   11
    /   /   \
  30   40   50

Output: 22

Explanation: 
Nodes within distance 1 from 9 
9 + 5 + 7 + 1 = 22

Example 2:

Input:
target = 40 
k = 2
Binary Tree = 
            1
           /  \
          2    9
        /     /  \
       4     5    7
      /  \       /  \
     8    19    20   11
    /   /   \
  30   40   50

Output: 113

Explanation:
Nodes within distance 2 from 40,
40 + 19 + 50 + 4 = 113
Your Task:
You don't need to read input or print anything. Complete the function sum_at_distK() that takes the root of the given binary tree, target and k as input parameters and return the required sum. 

Expected time complexity: O(n)
Expected space complexity: O(n)

Constraints:
1 <= number of nodes <= 1000
1 <= data in nodes,target <= 10000
1 <= k <= 20






/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class solver{
    private static int sum;
    private static Node targetNode;
    static int sum_at_distK(Node root, int target, int k){
        // code here
        if (root == null) {
            return 0;
        }
        sum = 0;
        targetNode = null;
        Map<Node, Node> nodeToParent = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        fillTheNodeToParentMap(root, null, target, nodeToParent);
        findTheSum(targetNode, k, nodeToParent, visited);
        return sum;
    }
    
    static void fillTheNodeToParentMap(Node node, Node parent, int target, Map<Node, Node> nodeToParent) {
        if (node == null) {
            return;
        }
        if (node.data == target) {
            targetNode = node;
        }
        nodeToParent.put(node, parent);
        fillTheNodeToParentMap(node.left, node, target, nodeToParent);
        fillTheNodeToParentMap(node.right, node, target, nodeToParent);
    }
    
    static void findTheSum(Node node, int k, Map<Node,Node> nodeToParent, Set<Node> visited) {
        if (node == null) {
            return;
        }
        if (k < 0) {
            return;
        }
        if (visited.contains(node)) {
            return;
        }
        sum += node.data;
        visited.add(node);
        findTheSum(node.left, k - 1, nodeToParent, visited);
        findTheSum(node.right, k - 1, nodeToParent, visited);
        findTheSum(nodeToParent.get(node), k - 1, nodeToParent, visited);
    }
    
}

