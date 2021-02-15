Geek has developed an effective vaccine for Corona virus and he wants each of the N houses in Geek Land to have access to it. Given a binary tree where each node represents a house in Geek Land, find the minimum number of houses that should be supplied with the vaccine kit if one vaccine kit is sufficient for that house, its parent house and it's immediate child nodes.  

 

Example 1:

Input:
    1
   / \
  2   3 
        \
         4
          \
           5
            \
             6

Output:
2
Explanation:
The vaccine kits should be 
supplied to house numbers 1 and 5. 
Example 2:

Input:
    1
   / \
  2   3 
Output:
1
Explanation:
The vaccine kits should be 
supplied to house number 1.

Your Task:
You don't need to read input or print anything. Complete the function supplyVaccine() which takes the root of the housing tree as input parameter and returns the minimum number of houses that should be supplied with the vaccine kit.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105




class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} 

class Solution{
    static int result;
    static Set<Node>covered;
    public static void dfs(Node node1, Node node2) {
        if (node1 != null) {
            dfs(node1.left, node1);
            dfs(node1.right, node1);
            if (node2 == null && !covered.contains(node1) || !covered.contains(node1.left) || !covered.contains(node1.right)) {
                result += 1;
                covered.add(node1);
                covered.add(node2);
                covered.add(node1.left);
                covered.add(node1.right);
            }
        }
        
        
    }
    
    public static int supplyVaccine(Node root){
        result = 0;
        covered = new HashSet<>();
        covered.add(null);
        dfs(root, null);
        return result;
    }
}
