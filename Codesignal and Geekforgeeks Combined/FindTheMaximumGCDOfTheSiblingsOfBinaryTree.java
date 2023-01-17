Given a binary tree. The task is to find the maximum GCD of the siblings of this tree. You have to return the value of the node whose two immediate children has the maximum gcd.
If there are multiple such nodes, return the node which has the maximum value.

Siblings: Nodes with the same parent are called siblings.

GCD (Greatest Common Divisor) of two positive integers is the largest positive integer that divides both numbers without a remainder.

Note:
Return 0 if input tree is empty i.e level of tree is -1.
Consider those nodes which have a sibling.
Return 0 if no such pair of siblings found.
 

Example 1:

Input:
              4
            /   \
           5     2
                /  \
               3    1
              /  \
             6   12

Output: 3
Explanation: For the above tree, the maximum
GCD for the siblings is formed for nodes 6 and 12
for the children of node 3.
 

Example 2:

Input: 
            1
          /   \
        3      5
      /  \    /  \
     6    9  4    8

Output: 5
Explanation: For the above tree, the maximum
GCD for the siblings is formed for nodes 4 and 8
for the children of node 5.
 

Your Task:
You don't need to take input. Just complete the function maxGCD() that takes the root node as a parameter and returns the value of the node whose two immediate children has the maximum gcd.

 

Expected Time Complexity: O(|Number of nodes|) .
Expected Auxiliary Space: O(1) .

 

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105


/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    int maxGCD(Node root) {
        // code here 
        return f(root)[1];
    }
    // 0th index --> Maximum GCD Value
    // 1st index --> Node data according to this max. GCD
    int[] f(Node root) {
        if(root==null) return new int[]{0,0};
        int[] a1 = f(root.left);
        int[] a2 = f(root.right);
        int[] ans = compare(a1,a2);
        if(root.left!=null && root.right!=null) {
            int g = gcd(root.left.data,root.right.data);
            ans = compare(ans,new int[]{g,root.data});
        }
        return ans;
    }
    
    int[] compare(int[] a1,int[] a2) {
        if(a1[0]<a2[0]) {
            return a2;
        } else if(a1[0]==a2[0]) {
            if(a1[1]<a2[1]) {
                return a2;
            } else {
                return a1;
            }
        } else {
            return a1;
        }
    }
    
    int gcd(int a,int b) {
        if(a==0) return b;
        return gcd(b%a,a);
    }
}

