//User function template for JAVA

/*Complete the Given Function

Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
    	data=d;
    	left=null;
    	right=null;
    }
}*/

class Solution{
    public void toSumTree(Node root){
         //add code here.
         if (root == null)
            return;
        totalSum(root);
    }
    
    public int totalSum(Node node) {
        if (node == null)
            return  0;
        int initialValue = node.data;
        node.data = totalSum(node.left) + totalSum(node.right);
        return node.data + initialValue;
    }
}