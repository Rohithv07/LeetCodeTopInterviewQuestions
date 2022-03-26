Given a string S which only contains lowercase alphabets. Find the length of the longest substring of S such that the characters in it can be rearranged to form a palindrome.


Example 1:

Input:
S = "aabe"
Output:
3
Explanation:
The substring "aab" can be rearranged to
"aba" which is the longest palindrome
possible for this String.
Example 2:
Input:
S = "adbabd"
Output:
6
Explanation:
The whole string “adbabd” can be
rearranged to form a palindromic substring.
One possible arrangement is "abddba".
Thus, output length of the string is 6. 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function longestSubstring() which takes a String S as input and returns the length of largest possible Palindrome.


Expected Time Complexity: O(|S|*26)
Expected Auxiliary Space: O(|S|*26)


Constraints:
1 ≤ |S| ≤ 105


class Solution {
    static int longestSubstring(String s) {
        // code here
        int n = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int mask = 0;
        map.put(mask, -1);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            mask ^= (1 << index);
            if (map.containsKey(mask)) {
                answer = Math.max(answer, i - map.get(mask));
            }
            else {
                map.put(mask, i);
            }
            for (int j = 0; j < 26; j++) {
                int nextMask = mask ^ (1 << j);
                if (map.containsKey(nextMask)) {
                    answer = Math.max(answer, i - map.get(nextMask));
                }
            }
        }
        return answer;
    }
}