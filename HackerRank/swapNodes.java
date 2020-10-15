https://www.hackerrank.com/challenges/swap-nodes-algo/problem


import java.util.*;
class Node {
    int val;
    int depth;
    Node left;
    Node right;
    Node(){};
    Node(int val, int depth) {
        this.val = val;
        this.depth = depth;
    }
}
class Solution {
    public static void swapNode(Node node, int k) {
        if (node == null)
            return;
        // do the bfs
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.depth%k == 0) {
                Node temp = current.left;
                current.left = current.right;
                current.right = temp;
            }
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }
    public static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.val+" ");
            inorder(node.right);
        }
    }
    public static void print_nodes(Node root, int K){
        swapNode(root, K);
        inorder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node root = new Node(1, 1);
        Node cur = root;
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.offer(cur);
        while (N-->0){
            cur = nodes.poll();
            int leftData = sc.nextInt();
            int rightData = sc.nextInt();
            cur.left = (leftData==-1)? null: new Node(leftData, cur.depth+1);
            cur.right = (rightData==-1)? null: new Node(rightData, cur.depth+1);
            if (cur.left != null && cur.left.val!= -1) 
                nodes.offer(cur.left);
            if (cur.right != null && cur.right.val!=-1) 
                nodes.offer(cur.right);
        }
        int T = sc.nextInt();
        while (T-->0){
            int K = sc.nextInt();
            print_nodes(root, K);
        }
    }
}

