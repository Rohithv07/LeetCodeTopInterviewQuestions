// User function Template for Java

class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        int [] ceilSoFar = new int [1];
        ceilSoFar[0] = Integer.MAX_VALUE;
        return bstDfs(root, key, ceilSoFar);
    }
    
    int bstDfs(Node node, int key, int [] ceilSoFar) {
        if (node == null) {
            return ceilSoFar[0] != Integer.MAX_VALUE ? ceilSoFar[0] : -1;
        }
        if (node.data == key) {
            return key;
        }
        if (node.data < key) {
            return bstDfs(node.right, key, ceilSoFar);
        }
        if (node.data > key) {
            ceilSoFar[0] = Math.min(ceilSoFar[0], node.data);
            return bstDfs(node.left, key, ceilSoFar);
        }
        return ceilSoFar[0];
        
    }
}
