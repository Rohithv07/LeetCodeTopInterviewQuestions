/*
Given the root of a binary tree, return the total number of subtrees that all contain the same value.

Ex: Given the following binary tree...

          2
        /   \
       5     7
     /   \     \
    3     3     7, return 4 (both threes and both sevens).
    */


// ref : https://www.techiedelight.com/count-subtrees-value-nodes-binary-tree/#:~:text=Given%20a%20binary%20tree%2C%20count,subtree%20has%20the%20same%20value.&text=The%20time%20complexity%20of%20this,tree%20in%20a%20postorder%20fashion.

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int val) {
		this.val = val;
	}
	TreeNode (int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class SameValueTrees {

	public static int countSubtrees(TreeNode root) {
		AtomicInteger count = new AtomicInteger(0);
		countSubTreesHelper(root, count);
		return count.get();
	}

	public static int countSubTreesHelper(TreeNode root, AtomicInteger count) {
		if (root == null)
			return Integer.MIN_VALUE;
		// both left and right null, increment count and return node value
		if (root.left == null && root.right == null) {
			count.incrementAndGet();
			return root.val;
		}

		// recursion for the left and right
		int left = countSubTreesHelper(root.left, count);
		int right = countSubTreesHelper(root.right, count);
		// 1. left min value and right root value or
		// 2. right min value and left root value or
		// 3. left == right and they equal to rootvalue
		// then increment count and return root value
		if ((left == Integer.MIN_VALUE && right == root.val) || 
			(right == Integer.MIN_VALUE && left == root.val) ||
			(left == right && left == root.val)) {
			count.incrementAndGet();
			return root.val;
		}
		// return integer max if no such values
		return Integer.MAX_VALUE;
	}

	public static void main(String [] args) {
		/* Construct the following tree
                     1
                   /   \
                  2     3
                /     /   \
               4     5     6
             /     /   \     \
            4     5     5     7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(5);
        root.right.right.right = new TreeNode(7);
 
        System.out.print(countSubtrees(root));
	}
}