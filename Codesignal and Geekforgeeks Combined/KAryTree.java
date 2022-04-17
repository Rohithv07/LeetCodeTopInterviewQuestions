Find the number of leaf nodes in a full k-ary tree of height m.
Note: You have to return the answer module 109+7.

 

Example 1:

Input:
k = 2, m = 2
Output:
4
Explanation:
A full Binary tree of height 2 has 4 leaf nodes. 
Example 2:

Input:
k = 2, m = 1
Output:
2
Explanation:
A full Binary tree of height 1 has 2 leaf nodes.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function karyTree() which takes 2 Integers k, and m as input and returns the number of leaf nodes in a full k-ary Tree.

 

Expected Time Complexity: O(log(m))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= k,m <= 108




class Solution {
    static Long karyTree(int k, int m) {
        // code here
        long mod = (long)(1e9 + 7);
        long leafCount = 1;
        for (int i = 1; i <= m; i++) {
            leafCount = (leafCount * k) % mod;
        }
        return leafCount;
    }
}