Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

 

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 

Constraints:

1 <= nums.length <= 2 * 105
0 <= nums[i] <= 231 - 1



class Solution {
    
    private TrieNode root = new TrieNode();
    
    public void insert(int number) {
        TrieNode node = root;
        for (int i=31; i>=0; i--) {
            int currentBit = (number >> i) & 1;
            if (node.array[currentBit] == null) {
                node.array[currentBit] = new TrieNode();
            }
            node = node.array[currentBit];
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        int length = nums.length;
        int maxXor = Integer.MIN_VALUE;
        for (int number : nums) {
            insert(number);
        }
       
        for (int number : nums) {
            TrieNode node = root;
            int currentXor = 0;
            for (int i=31; i>=0; i--) {
                int currentBit = (number >> i) & 1;
                if (node.array[currentBit ^ 1] != null) {
                    currentXor += (1 << i);
                    node = node.array[currentBit ^ 1];
                }
                else {
                    node = node.array[currentBit];
                }
            }
            maxXor = Math.max(maxXor, currentXor);
        }
        return maxXor;
    }
}

class TrieNode {
    TrieNode [] array;
    public TrieNode() {
        array = new TrieNode[26];
    }
}