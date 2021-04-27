Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring the left subtree over the right subtree. 
Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

Example 1:

Input:
        1
      /   \
     2     3    
   
Output: 1 2 3
Explanation:


Example 2:

Input:
          20
        /   \
       8     22
     /   \    \
    4    12    25
        /  \ 
       10   14 

Output: 20 8 4 10 14 25 22
Explanation: 

 

 

 

 

 

 

 

 

Your Task:
This is a function problem. You don't have to take input. Just complete the function printBoundary() that takes the root node as input and returns an array containing the boundary values in anti-clockwise.

 

Expected Time Complexity: O(N). 
Expected Auxiliary Space: O(Height of the Tree).



// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

// class Solution
// {
// 	ArrayList <Integer> printBoundary(Node node)
// 	{
// 	    ArrayList<Integer> result = new ArrayList<>();
// 	    if (node == null)
// 	        return result;
// 	    result.add(node.data);
// 	    printLeftBoundary(node.left, result);
// 	    printLeaf(node.left, result);
// 	    printLeaf(node.right, result);
// 	    printRightBoundary(node.right, result);
// 	    return result;
// 	}
	
// 	public void printLeaf(Node node, ArrayList<Integer> result) {
// 	    if (node == null)
// 	        return;
// 	    printLeaf(node.left, result);
// 	    if (node.left == null && node.right == null) {
// 	        result.add(node.data);
// 	    printLeaf(node.right, result);
// 	    }
// 	}
	
// 	public void printLeftBoundary(Node node, ArrayList<Integer> result) {
// 	    if (node == null)
// 	        return;
// 	    if (node.left != null) {
// 	        result.add(node.data);
// 	        printLeftBoundary(node.left, result);
// 	    }
// 	    else if (node.right != null) {
// 	        result.add(node.data);
// 	        printLeftBoundary(node.right, result);
// 	    }
// 	}
	
// 	public void printRightBoundary(Node node, ArrayList<Integer> result) {
// 	    if (node == null)
// 	        return;
// 	    if (node.right != null) {
// 	        printRightBoundary(node.right, result);
// 	        result.add(node.data);
// 	    }
// 	    else if (node.left != null) {
// 	        printRightBoundary(node.left, result);
// 	        result.add(node.data);
// 	    }
// 	}
// }
class Solution
{
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer> ret=new ArrayList<Integer>();
	    if(node==null){
	     return ret;   
	    }
	    ret.add(node.data);
	    printleft(node.left,ret);
	    printbottom(node,ret);
	    Stack<Integer> s=new Stack<Integer>();
	    printright(node.right,s);
	    while(!s.isEmpty()){
	        ret.add(s.pop());
	    }
	    return ret;
	}
	void printright(Node root,Stack<Integer> s){
	    if(root==null){
	        return;
	    }
	    if(root.left!=null || root.right!=null)
	    {
	    s.push(root.data);
	    }
	    if(root.right!=null){
	        printright(root.right,s);
	    }
	    else{
	        printright(root.left,s);
	    }
	}
	void printleft(Node root,ArrayList<Integer> al){
	    if(root==null){
	        return;
	    }
	    if(root.left!=null || root.right!=null)
	    {
	    al.add(root.data);    
	    }
	    if(root.left!=null){
	        printleft(root.left,al);
	    }
	    else{
	        printleft(root.right,al);
	    }
	}
	void printbottom(Node root,ArrayList<Integer> al){
	    if(root==null){
	        return;
	    }
	    printbottom(root.left,al);
	    if(root.left==null && root.right==null){
	        al.add(root.data);
	    }
	    printbottom(root.right,al);
	}
}
