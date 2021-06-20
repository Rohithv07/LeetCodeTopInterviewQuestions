Given two BSTs, return elements of both BSTs in sorted form.

Example 1:

Input:
BST1:
       5
     /   \
    3     6
   / \
  2   4  
BST2:
        2
      /   \
     1     3
            \
             7
            /
           6
Output: 1 2 2 3 3 4 5 6 6 7
Explanation: 
After merging and sorting the
two BST we get 1 2 2 3 3 4 5 6 6 7.
Example 2:

Input:
BST1:
       12
     /   
    9
   / \    
  6   11
    
BST2:
      8
    /  \
   5    10
  /
 2
Output: 2 5 6 8 9 10 11 12
Explanation: 
After merging and sorting the
two BST we get 2 5 6 8 9 10 11 12.
Your Task:
You don't need to read input or print anything. Your task is to complete the function merge() which takes roots of both the BSTs as its input and returns an array of integers denoting the node values of both the BSTs in a sorted order.

Expected Time Complexity: O(M+N) where M and N are the sizes if the two BSTs.
Expected Auxiliary Space: O(Height of BST1 + Height of BST2).

Constraints:
1 <= Number of Nodes <= 100000




/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
    
*/
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        // O(m + n + mlogm + nlogn) - not optimal, we can do better
        if (root1 == null && root2 == null)
            return new ArrayList<>();
        List<Integer> sortedAndMerged = new ArrayList<>();
        inorder(root1, sortedAndMerged);
        inorder(root2, sortedAndMerged);
        Collections.sort(sortedAndMerged);
        return sortedAndMerged;
    }
    
    public void inorder(Node node, List<Integer> sortedAndMerged) {
        if (node == null)
            return;
        inorder(node.left, sortedAndMerged);
        sortedAndMerged.add(node.data);
        inorder(node.right, sortedAndMerged);
    }
}

/*
This is the optimised approach and need to have some look on it
class Solution{
    public List<Integer> merge(Node root1,Node root2){
        List<Integer> arr = new ArrayList<>();
        Stack<Node> stk1 = new Stack<>();
        Stack<Node> stk2 = new Stack<>();
        while(root1 != null){
            stk1.push(root1);
            root1 = root1.left;
        }
        while(root2 != null){
            stk2.push(root2);
            root2 = root2.left;
        }
        while(!stk1.isEmpty() || !stk2.isEmpty()){
            root1 = null;
            root2 = null;
            if(!stk1.isEmpty())
                root1 = stk1.peek();
            if(!stk2.isEmpty())
                root2 = stk2.peek();
            if(root1 == null)
                arr.add(stk2.pop().data);
            else if(root2 == null)
                arr.add(stk1.pop().data);
            else if(root1.data < root2.data){
                arr.add(stk1.pop().data);
                root2 = null;
            }
            else{
                arr.add(stk2.pop().data);
                root1 = null;
            }
            if(root1 != null && root1.right != null){
                root1 = root1.right;
                while(root1 != null){
                    stk1.push(root1);
                    root1 = root1.left;
                }
            }
            if(root2 != null && root2.right != null){
                root2 = root2.right;
                while(root2 != null){
                    stk2.push(root2);
                    root2 = root2.left;
                }
            }
        }
        return arr;
    }
}
*/

