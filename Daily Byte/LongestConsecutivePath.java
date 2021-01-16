/*
Given a Binary Tree find the length of the longest path which comprises of connected nodes with consecutive values in increasing order. 

 

Example 1:

Input :      
           1                               
         /   \                          
        2     3                      

Output: 2

Explanation : Longest sequence is 1, 2.

 

Example 2:

Input :    
            10                               
         /     \                          
       20       30                      
      /  \      /
     40      60   90    

Output :  -1

Explanation: For the above test case no 
sequence is possible. So output is -1.
 

Your Task:  
You dont need to read input or print anything. Complete the function longestConsecutive() which takes root node as input parameter and returns the length of the longest consecutive increasing sequence (of at least length 2) in the given Binary Tree. If such a sequence does not exist, return -1.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of Tree)
*/


import java.util.*;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode() {};
	TreeNode(int value) {
		this.value = value;
	}
	TreeNode(int value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

class LongestConsecutivePath {

	public static int longestConsecutivePath(TreeNode root) {
		if (root == null)
			return -1;
		int [] result = new int [1];
		findPath(root, 0, root.value, result);
		return result[0] == 1 ? -1 : result[0];
	}

	public static void findPath(TreeNode root, int currentLength, int parentValue, int [] result) {
		if (root == null)
			return;
		if (root.value == parentValue + 1)
			currentLength += 1;
		else
			currentLength = 1;
		result[0] = Math.max(result[0], currentLength);
		findPath(root.left, currentLength, root.value, result);
		findPath(root.right, currentLength, root.value, result);
	}

	public static void main(String [] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(8);
		System.out.println(longestConsecutivePath(root));
	}
}