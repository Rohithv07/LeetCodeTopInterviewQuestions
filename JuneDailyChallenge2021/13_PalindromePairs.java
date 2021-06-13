Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.

 

Example 1:

Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]
Example 3:

Input: words = ["a",""]
Output: [[0,1],[1,0]]
 

Constraints:

1 <= words.length <= 5000
0 <= words[i].length <= 300
words[i] consists of lower-case English letters.


//https://leetcode.com/problems/palindrome-pairs/discuss/79195/O(n-*-k2)-java-solution-with-Trie-structure

class Solution {
    
    private TrieNode root = new TrieNode();
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length == 0)
            return result;
        for (int i=0; i<words.length; i++) {
            insert(words[i], i);
        }
        for (int i=0; i<words.length; i++) {
            search(words[i], i, result);
        }
        return result;
    }
    
    public void insert(String word, int index) {
        TrieNode node = root;
        for (int i=word.length() - 1; i>=0; i--) {
            int currentCharIndex = word.charAt(i) - 'a';
            if (node.child[currentCharIndex] == null) {
                node.child[currentCharIndex] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) {
                node.list.add(index);
            }
            node = node.child[currentCharIndex];
        }
        node.list.add(index);
        node.index = index;
    }
    
    public void search(String word, int i, List<List<Integer>> result) {
        TrieNode node = root;
        for (int j=0; j<word.length(); j++) {
            if (node.index != i && node.index >= 0 && isPalindrome(word, j, word.length() - 1)) {
                result.add(Arrays.asList(i, node.index));
            }
            node = node.child[word.charAt(j) - 'a'];
            if (node == null)
                return;
        }
        for (int value : node.list) {
            if (value != i) {
                result.add(Arrays.asList(i, value));
            }
        }
    }
    
    public boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--))
                return false;
        }
        return true;
    }
}

class TrieNode {
    List<Integer> list;
    TrieNode [] child;
    int index;
    TrieNode() {
        index = -1;
        list = new ArrayList<>();
        child = new TrieNode[26];
    }
}
