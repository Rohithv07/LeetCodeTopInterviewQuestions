
order and str are strings composed of lowercase letters. In order, no letter occurs more than once.

order was sorted in some custom order previously. We want to permute the characters of str so that they match the order that order was sorted. More specifically, if x occurs before y in order, then x should occur before y in the returned string.

Return any permutation of str (as a string) that satisfies this property.

Example:
Input: 
order = "cba"
str = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
 

Note:

order has length at most 26, and no character is repeated in order.
str has length at most 200.
order and str consist of lowercase letters only.

class Solution {
    public String customSortString(String order, String str) {
        if (order == null || order.length() == 0)
            return str;
        if (str == null || str.length() == 0)
            return "";
        int [] count = new int [26];
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        // order based on the relative of order
        for (char ch : order.toCharArray()) {
            while (count[ch - 'a']-- > 0) {
                sb.append(ch);
            }
        }
        // there might be some letters left in str that is untracked
        for (char ch='a'; ch<='z'; ch++) {
            while (count[ch - 'a']-- > 0)
                sb.append(ch);
        }
        return sb.toString();
    }
}