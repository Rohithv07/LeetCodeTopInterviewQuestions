Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.

 

Example 1:

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
 

Constraints:

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.



class Solution {
    public int maxProduct(String[] words) {
        int length = words.length;
        int max = 0;
        int [] mask = new int [length];
        for (int i=0; i<length; i++) {
            int number = 0;
            for (char ch : words[i].toCharArray()) {
                number |= (1 << (ch - 'a'));
            }
            mask[i] = number;
            // System.out.println(mask[i]);
        }
        for (int i=0; i<length; i++) {
            if (mask[i] == max)
                continue;  // this line to increase time efficiency
            for (int j=0; j<length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
