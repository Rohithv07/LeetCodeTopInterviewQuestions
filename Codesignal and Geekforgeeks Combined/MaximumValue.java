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
       //bfs(node, result);
        dfs(node, result, 0);
       return result;
    }
    
    private void dfs(Node node, ArrayList<Integer> result, int level) {
        if (node == null) {
            return;
        }
        if (result.size() == level) {
            result.add(node.data);
        }
        if (result.size() > level) {
            int currentMax = result.get(level);
            int max = Math.max(currentMax, node.data);
            result.set(level, max); 
        }
        dfs(node.left, result, level + 1);
        dfs(node.right, result, level + 1);
    }
    
    private void bfs(Node node, ArrayList<Integer> result) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentLevelMax = 0;
            for (int i = 0; i < size; i++) {
                Node topNode = queue.poll();
                currentLevelMax = Math.max(currentLevelMax, topNode.data);
                if (topNode.left != null) {
                    queue.offer(topNode.left);
                }
                if (topNode.right != null) {
                    queue.offer(topNode.right);
                }
            }
            result.add(currentLevelMax);
        }
    }
}

