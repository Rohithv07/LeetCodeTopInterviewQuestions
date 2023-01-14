You are given two strings of the same length s1 and s2 and a string baseStr.

We say s1[i] and s2[i] are equivalent characters.

For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
Equivalent characters follow the usual rules of any equivalence relation:

Reflexivity: 'a' == 'a'.
Symmetry: 'a' == 'b' implies 'b' == 'a'.
Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.

Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.

 

Example 1:

Input: s1 = "parker", s2 = "morris", baseStr = "parser"
Output: "makkek"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
The characters in each group are equivalent and sorted in lexicographical order.
So the answer is "makkek".
Example 2:

Input: s1 = "hello", s2 = "world", baseStr = "hold"
Output: "hdld"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [h,w], [d,e,o], [l,r].
So only the second letter 'o' in baseStr is changed to 'd', the answer is "hdld".
Example 3:

Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
Output: "aauaaaaada"
Explanation: We group the equivalent characters in s1 and s2 as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".
 

Constraints:

1 <= s1.length, s2.length, baseStr <= 1000
s1.length == s2.length
s1, s2, and baseStr consist of lowercase English letters.


class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int [] graph = new int [26];
        int baseLength = baseStr.length();
        int stringLength = s1.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            graph[i] = i;
        }
        for (int i = 0; i < stringLength; i++) {
            int firstCharIndex = s1.charAt(i) - 'a';
            int secondCharIndex = s2.charAt(i) - 'a';
            int end1 = find(graph, firstCharIndex);
            int end2 = find(graph, secondCharIndex);
            if (end1 > end2) {
                graph[end1] = end2;
            }
            else {
                graph[end2] = end1;
            }
        }
        for (int i = 0; i < baseLength; i++) {
            int baseStrChar = baseStr.charAt(i) - 'a';
            char added = (char)('a' + find(graph, baseStrChar));
            result.append(added);
        }
        return result.toString();
    }

    private int find(int [] graph, int index) {
        while (graph[index] != index) {
            index = graph[index];
        }
        return index;
    }
}