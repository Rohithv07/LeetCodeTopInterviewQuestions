Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.

Example 1:

Input: s = "abab"
Output: 2
Explanation: "ab" is the longest proper 
prefix and suffix. 
Example 2:

Input: s = "aaaa"
Output: 3
Explanation: "aaa" is the longest proper 
prefix and suffix. 
Your task:
You do not need to read any input or print anything. The task is to complete the function lps(), which takes a string as input and returns an integer.

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(|s|)

Constraints:
1 ≤ |s| ≤ 105
s contains lower case English alphabets



class Solution {
    int lps(String s) {
        // code here
        int length = s.length();
        int [] store = new int [length];
        for (int i=1; i<length; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (s.charAt(i) == s.charAt(store[j])) {
                    store[i] = store[j] + 1;
                    break;
                }
                else {
                    j = store[j] - 1;
                }
            }
        }
        return store[length - 1];
        // to get the string we can do s.substring(0, store[length - 1])
    }
}
