Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
Example 2:

Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
 

Constraints:

1 <= s.length <= 5 * 104
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.



class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String word : words) { // n
            if (isSubsequence(s, word))
                count += 1;
        }
        return count;
    }
    
    public boolean isSubsequence(String s, String word) {
        int previousCharIndex = 0;
        for (char ch : word.toCharArray()) {  // p
            int index = s.indexOf(ch, previousCharIndex); // m n
            if (index == -1)
                return false;
            previousCharIndex = index + 1;
        }
        return true;
    }
}

// n * p * m * n = n ^2 m p

/*

Need to go through the below solution as it is faster

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            heads[i] = new ArrayList<Node>();

        for (String word: words)
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));

        for (char c: S.toCharArray()) {
            ArrayList<Node> old_bucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();

            for (Node node: old_bucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    ans++;
                } else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            old_bucket.clear();
        }
        return ans;
    }

}

class Node {
    String word;
    int index;
    public Node(String w, int i) {
        word = w;
        index = i;
    }
}
*/
