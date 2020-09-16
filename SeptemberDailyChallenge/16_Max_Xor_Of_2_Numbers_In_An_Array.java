Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.


Solution:

/* My thought process
Here I couldn't get O(n) solution, but come up with the brute force solution which is also accepted. 
The idea is simple, I just used 2 loops one to gather the current element and another to go through the rest of element and 
to compute the maximum of xor value.
Finally we just return the maximum xor value
*/


class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=1; j<n; j++) {
                int xor = nums[i] ^ nums[j];
                max = Math.max(xor, max);
            }
        }
        return max;
    }
}
