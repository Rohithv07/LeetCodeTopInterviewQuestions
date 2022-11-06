You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string..

Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

 

Example 1:

Input: s = "cba", k = 1
Output: "acb"
Explanation: 
In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".
Example 2:

Input: s = "baaca", k = 3
Output: "aaabc"
Explanation: 
In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".
 

Constraints:

1 <= k <= s.length <= 1000
s consist of lowercase English letters.


class Solution {
    public String orderlyQueue(String s, int k) {
        // we only need to check k = 1
        // for all other k's, its the just regular sorted one
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        if (k == 1) {
            String answer = s;
            for (int i = 0; i < length; i++) {
                String rotated = s.substring(i) + s.substring(0, i);
                if (rotated.compareTo(answer) < 0) {
                    answer = rotated;
                }
            }
            return answer;
        }
        // all other k values > 1
        else {
            char [] sArray = s.toCharArray();
            Arrays.sort(sArray);
            return new String(sArray);
        }
    }
}