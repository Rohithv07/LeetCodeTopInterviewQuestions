Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is less than or equal to k.

 

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 105





// we split the string or divide the string when we see a count < k
class Solution {
    public int longestSubstring(String s, int k) {
        return divideAndConquer(s, 0, s.length(), k);
    }
    public int divideAndConquer(String s, int start, int end, int k) {
        if (end - start < k)
            return 0;
        int [] count = new int [26];
        for (int i=start; i<end; i++) {
            count[s.charAt(i) - 'a'] += 1;
        }
        for (int i=0; i<26; i++) {
            if (count[i] < k && count[i] > 0) {
                for (int j=start; j<end; j++) {
                    if (s.charAt(j) == i + 'a') {
                        int left = divideAndConquer(s, start, j, k);
                        int right = divideAndConquer(s, j+1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }
}
