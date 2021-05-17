Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2. For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.

 

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chain is "a","ba","bda","bdca".
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of English lowercase letters.

class Solution {
    public int longestStrChain(String[] words) {
        if (words.length == 0 || words == null)
            return 0;
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String word : words) {
            map.put(word, 1);
            for (int i=0; i<word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                String compare = sb.deleteCharAt(i).toString();
                if (map.containsKey(compare) && map.get(compare) + 1 > map.get(word)) {
                    map.put(word, map.get(compare) + 1);
                }
            }
            result = Math.max(result, map.get(word));
        }
        return result;
    }
}
