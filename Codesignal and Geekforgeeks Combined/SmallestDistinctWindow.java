Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.
For eg. A = aabcbcdbca, then the result would be 4 as of the smallest window will be dbca.

 

Example 1:

Input : "AABBBCBBAC"
Output : 3
Explanation : Sub-string -> "BAC"
Example 2:
Input : "aaab"
Output : 2
Explanation : Sub-string -> "ab"
 
Example 3:
Input : "GEEKSGEEKSFOR"
Output : 8
Explanation : Sub-string -> "GEEKSFOR"
 


Your Task:  
You don't need to read input or print anything. Your task is to complete the function findSubString() which takes the string  S as input and returns the length of the smallest such window of the string.


Expected Time Complexity: O(256.N)
Expected Auxiliary Space: O(256)

 

Constraints:
1 ≤ |S| ≤ 105
String may contain both type of English Alphabets.


//User function Template for Java

class Solution {
    public int findSubString( String s) {
        // Your code goes here
        
        // first find the smallest string with atleast 1 char
        // then the problem bolied down to minimum window substring
        
        StringBuilder sb = new StringBuilder();
        int [] count = new int[256];
        for (char ch : s.toCharArray()) {
            if (count[ch] == 0) {
                sb.append(ch);
            }
            count[ch]++;
        }
        String smallestString = sb.toString();
        return minimumWindowSubstring(s, smallestString);
    }
    
    private int minimumWindowSubstring(String s, String t) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, 1);
        }
        int size = map.size();
        int result = length;
        int start = 0;
        int end = 0;
        while (end < length) {
            char currentEnd = s.charAt(end);
            map.put(currentEnd, map.get(currentEnd) - 1);
            if (map.get(currentEnd) == 0) {
                size--;
            }
            end++;
            while (size == 0) {
                char currentStart = s.charAt(start);
                map.put(currentStart, map.get(currentStart) + 1);
                if (map.get(currentStart) > 0) {
                    size++;
                }
                result = Math.min(result, end - start);
                start++;
            }
        }
        return result;
    }
}