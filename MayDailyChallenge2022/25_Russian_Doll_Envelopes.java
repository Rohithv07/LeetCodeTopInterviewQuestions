You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

 

Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
Example 2:

Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1
 

Constraints:

1 <= envelopes.length <= 105
envelopes[i].length == 2
1 <= wi, hi <= 105



class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
        int length = envelopes.length;
        int [] dp = new int [length];
        int result = 0;
        for (int [] env : envelopes) {
            int left = 0;
            int right = result;
            while (left < right) {
                int middle = left + (right - left) / 2;
                if (dp[middle] < env[1]) {
                    left = middle + 1;
                }
                else {
                    right = middle;
                }
            }
            dp[left] = env[1];
            if (left == result) {
                result++;
            }
        }
        return result;
    }
}