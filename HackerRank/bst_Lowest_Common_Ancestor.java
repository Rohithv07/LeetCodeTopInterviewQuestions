https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees



import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node root, int v1, int v2) {
      	// Write your code here.
        if (root == null)
            return null;
        if (v1 < root.data && v2 < root.data)
            return lca(root.left, v1, v2);
        if (v1 > root.data && v2 > root.data)
            return lca(root.right, v1, v2);
        return root;
    }

	public static Node insert(Node root, int data) {
