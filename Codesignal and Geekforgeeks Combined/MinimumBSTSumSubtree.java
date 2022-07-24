// https://practice.geeksforgeeks.org/contest/interview-series-60/problems/#

// https://www.youtube.com/watch?v=8VfnEAQfx08

/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

// this is the correct approach, but giving TLE for Java. Same approach for cpp gets accepted


class Solution {
    
    private static HashMap<Node, Integer> sumSubtree = new HashMap<>();
    private static HashMap<Node, Integer> subtreeSize = new HashMap<>();
    private static HashMap<Node, Integer> minValSubtree = new HashMap<>();
    private static HashMap<Node, Integer> maxValSubtree = new HashMap<>();
    private static int minLength;
    
    private static void dfs(Node current) {
        if (current == null) {
            return;
        }
        if (current.left == null && current.right == null) {
            // leaf node
            subtreeSize.put(current, 1);
            sumSubtree.put(current, current.data);
            minValSubtree.put(current, current.data);
            maxValSubtree.put(current, current.data);
            return;
        }
        else if (current.left == null) {
            // only right child
            dfs(current.right);
            subtreeSize.put(current, 1 + subtreeSize.get(current.right));
            sumSubtree.put(current, current.data + sumSubtree.get(current.right));
            minValSubtree.put(current, Math.min(current.data, minValSubtree.get(current.right)));
            maxValSubtree.put(current, Math.max(current.data, maxValSubtree.get(current.right)));
        }
        else if (current.right == null) {
            // only left child
            dfs(current.left);
            subtreeSize.put(current, 1 + subtreeSize.get(current.left));
            sumSubtree.put(current, current.data + sumSubtree.get(current.left));
            minValSubtree.put(current, Math.min(current.data, minValSubtree.get(current.left)));
            maxValSubtree.put(current, Math.max(current.data, maxValSubtree.get(current.left)));
        }
        else {
            // both left and right present
            dfs(current.left);
            dfs(current.right);
            subtreeSize.put(current, 1 + subtreeSize.get(current.left) + subtreeSize.get(current.right));
            sumSubtree.put(current, current.data + sumSubtree.get(current.left) + sumSubtree.get(current.right));
            minValSubtree.put(current, Math.min(current.data, Math.min(minValSubtree.get(current.left), minValSubtree.get(current.right))));
            maxValSubtree.put(current, Math.max(current.data, Math.max(maxValSubtree.get(current.left), maxValSubtree.get(current.right))));
        }
    }
    
    
    // return whether the subtree is a BST + we updates and calculates our answer
    // maxValueOfLeftChild <= current Node <= minValue of right child
    private static boolean findAnswer(Node current, int target) {
        if (current == null) {
            return true;
        }
        else if (current.left == null && current.right == null) {
            // leaf node, if we get node value equal to target, this is the best one.
            if (current.data == target) {
                minLength = 1;
            }
            return true;
        }
        else if (current.left == null) {
            // only right child, check if right child is BST and sum = target
            boolean isRightChildBST = findAnswer(current.right, target);
            if (isRightChildBST && current.data < minValSubtree.get(current.right)) {
                if (sumSubtree.get(current) == target) {
                    minLength = Math.min(minLength, subtreeSize.get(current));
                }
                return true;
            }
            else {
                return false;
            }
        }
        else if (current.right == null) {
            // only left child, check if leftchild is BST and sum = target
            boolean isLeftChildBST = findAnswer(current.left, target);
            if (isLeftChildBST && current.data > maxValSubtree.get(current.left)) {
                if (sumSubtree.get(current) == target) {
                    minLength = Math.min(minLength, subtreeSize.get(current));
                }
                return true;
            }
            else {
                return false;
            }
        }
        else {
            // both left and right child. Check if BST and sum = target
            boolean isLeftChild = findAnswer(current.left, target);
            boolean isRightChild = findAnswer(current.right, target);
            if (isLeftChild && isRightChild && maxValSubtree.get(current.left) < current.data && current.data < minValSubtree.get(current.right)) {
                if (sumSubtree.get(current) == target) {
                    minLength = Math.min(minLength, subtreeSize.get(current));
                }
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    public static int minSubtreeSumBST(int target, Node root) {
        // code here
        if (root == null) {
            return 0;
        }
        dfs(root);
        minLength = Integer.MAX_VALUE;
        findAnswer(root, target);
        //System.out.println(sumSubtree.get(root));
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
