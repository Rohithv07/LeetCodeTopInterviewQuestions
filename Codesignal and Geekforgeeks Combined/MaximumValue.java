Find the maximum values of each level in a binary tree



//User function Template for Java
/*
Tree node structure  used in the program
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> maximumValue(Node node) {
       //code here
       ArrayList<Integer> result = new ArrayList<>();
       if (node == null) {
           return result;
       }
       bfsHelper(node, result);
       return result;
    }
    
    void bfsHelper(Node node, ArrayList<Integer> result) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentMax = Integer.MIN_VALUE;
            for (int i=0; i<size; i++) {
                Node currentNode = queue.poll();
                currentMax = Math.max(currentMax, currentNode.data);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentMax);
        }
    }
}

