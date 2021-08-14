Given an array arr[] of size, N. Find the subarray with maximum XOR. A subarray is a contiguous part of the array.


Example 1:

Input:
N = 4
arr[] = {1,2,3,4}
Output: 7
Explanation: 
The subarray {3,4} has maximum xor 
value equal to 7.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxSubarrayXOR() which takes the array arr[], its size N as input parameters and returns the maximum xor of any subarray.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
1 <= arr[i] <= 105



class Solution{

     final int MAX_SIZE = 32;
     private TrieNode root = new TrieNode();
     
     // insert prexor value
     void insert(int preXor) {
         TrieNode node = root;
         for (int i=MAX_SIZE-1; i>=0; i--) {
             // find the current bit
            int currentBit = (preXor & (1 << i)) >= 1 ? 1 : 0;
            if (node.child[currentBit] == null) {
                node.child[currentBit] = new TrieNode();
            }
            node = node.child[currentBit];
         }
        node.value = preXor;
     }
     
     int search(int preXor) {
         TrieNode node = root;
         for (int i=MAX_SIZE-1; i>=0; i--) {
             // find currentBit
             int currentBit = (preXor & (1 << i)) >= 1 ? 1 : 0;
             // loook for a prefix with opposite bit
             if (node.child[1 - currentBit] != null) {
                 node = node.child[1 - currentBit];
             }
             // if no opposite bit, look for same bit
             else if (node.child[currentBit] != null) {
                 node = node.child[currentBit];
             }
         }
         return preXor ^ node.value;
     }
     
     int maxSubarrayXOR(int n, int arr[]){
        // code here
        if (arr == null || n == 0)
            return -1;
        TrieNode node = root;
        insert(0);
        int preXor = 0;
        int result = Integer.MIN_VALUE;
        for (int number : arr) {
            // find the prexor and add it into the trie
            preXor ^= number;
            insert(preXor);
            result = Math.max(result, search(preXor));
        }
        return result;
    }
}

class TrieNode {
    int value;
    TrieNode [] child = new TrieNode[2];
    public TrieNode() {
        value = 0;
        child[0] = null;
        child[1] = null;
    }
}