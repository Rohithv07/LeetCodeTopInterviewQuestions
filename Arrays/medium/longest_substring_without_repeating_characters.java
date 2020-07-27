Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


Solution:

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a_pointer = 0, b_pointer = 0, max = 0;
        HashSet<Character> hash = new HashSet<>();
        while(b_pointer < s.length()){
            if(!hash.contains(s.charAt(b_pointer))){
                hash.add(s.charAt(b_pointer));
                b_pointer ++;
                max = Math.max(hash.size(), max);
            }
            else{
                hash.remove(s.charAt(a_pointer));
                a_pointer ++;
            }
        }
        return max;
    
    
    }
}
