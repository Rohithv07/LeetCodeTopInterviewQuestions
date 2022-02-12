Given a binary tree, find the largest value in each level.

Example 1:

Input :
        1
       / \
      2   3 

Output : 1 3
Explanation : 
There are two levels in the tree :
1. {1}, max = 1
2. {2, 3}, max = 3
Example 2:

Input :
        4
       / \
      9   2
     / \   \
    3   5   7 

Output : 4 9 7
Explanation : 
There are three levels in the tree:
1. {4}, max = 4
2. {9, 2}, max = 9
3. {3, 5, 7}, max=7
Your task :
You don't need to read input or print anything. Your task is to complete the function largestValues() which takes the root node of the tree as input and returns a vector containing the largest value in each level. 
 
Expected Time Complexity : O(n) , where n = number of nodes
Expected Auxiliary Space : O(n) , where n = number of nodes
 
Constraints : 
1 ≤ Number of nodes ≤ 10^5


//User function Template for Java

class Solution
{
    public ArrayList<Integer> largestValues(Node root)
    {
        //code here
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> storeResult = new ArrayList<>();
        levelOrderTraversal(root, storeResult);
        return storeResult;
    }
    
    public void levelOrderTraversal(Node node, ArrayList<Integer> storeResult) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int currentLevelMax = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                if (currentLevelMax < currentNode.data) {
                    currentLevelMax = currentNode.data;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            storeResult.add(currentLevelMax);
        }
    }
}