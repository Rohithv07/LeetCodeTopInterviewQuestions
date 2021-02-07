Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.

 

Example 1:

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Example 2:

Input: s = "aaab", c = "b"
Output: [3,2,1,0]
 

Constraints:

1 <= s.length <= 104
s[i] and c are lowercase English letters.
c occurs at least once in s.




class Solution {
    public int[] shortestToChar(String s, char c) {
        
        // initialize a count array of len(s)
        int length = s.length();
        int [] count = new int [length];
        // except all the char c, just make the value as maximum
        for (int i=0; i<length; i++) {
            if (s.charAt(i) != c)
                count[i] = Integer.MAX_VALUE;
        }
        // now from left to right, if the value is max, update the place as min(dp[i+1], dp[i] + 1)
        for (int i=0; i<length - 1; i++) {
            if (count[i] != Integer.MAX_VALUE) {
                count[i + 1] = Math.min(count[i + 1], count[i] + 1);
            }
        }
        for (int i=length - 1; i>0; i--) {
            count[i - 1] = Math.min(count[i - 1], count[i] + 1);
        }
        return count;


		
	// 2. Another method
        int length = s.length();
        int currentCPosition = -length;
        int [] result = new int [length];
        for (int i=0; i<length; i++) {
            if (s.charAt(i) == c)
                currentCPosition = i;
            result[i] = i - currentCPosition;
        }
        for (int i=length - 1; i>=0; i--) {
            if (s.charAt(i) == c)
                currentCPosition = i;
            result[i] = Math.min(result[i], Math.abs(i - currentCPosition));
        }
        return result;
    }
}
