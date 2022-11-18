Given two binary trees, the task is to check if each of their levels are anagrams of each other or not. 

Example 1:

Input:

Output: 1
Explanation: 
Tree 1:
Level 0 : 1
Level 1 : 3, 2
Level 2 : 5, 4

Tree 2:
Level 0 : 1
Level 1 : 2, 3
Level 2 : 4, 5

As we can clearly see all the levels of above two binary trees 
are anagrams of each other, hence return true.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function areAnagrams() which takes the root of two trees as input and returns an 1 if all the levels are anagrams, else returns 0 as output.
 

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 104
1 <= tree.val <= 109








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

class Solution {
    public static boolean areAnagrams(Node node1, Node node2) {
        // code here
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.data != node2.data) {
            return false;
        }
        return areAnagrams(node1.left, node2.right) && areAnagrams(node1.right, node2.left);
    }
}
        
