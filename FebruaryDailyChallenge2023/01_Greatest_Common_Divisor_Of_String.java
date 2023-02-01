For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.


class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return str2;
        }
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int length1 = str1.length();
        int length2 = str2.length();
        int gcd = findGCD(length1, length2);
        return  str2.substring(0, gcd);
    }

    private int findGCD(int l1, int l2) {
        if (l2 == 0) {
            return l1;
        }
        return findGCD(l2, l1 % l2);
    }
}