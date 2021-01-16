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





class GfG
{
	public int longestConsecutive(Node root){
         //add code here.
         if (root == null)
            return 0;
        int [] result = new int [1];
        longestPath(root, 0, root.data, result);
        return result[0] == 1 ? -1 : result[0];
        }
    
    public void longestPath(Node root, int currentLength, int parentValue, int [] result) {
        if (root == null)
            return;
        if (root.data == parentValue + 1)
            currentLength += 1;
        else
            currentLength = 1;
        result[0] = Math.max(currentLength, result[0]);
        longestPath(root.left, currentLength, root.data, result);
        longestPath(root.right, currentLength, root.data, result);
    }
}

