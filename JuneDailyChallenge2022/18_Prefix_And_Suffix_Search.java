Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.

Implement the WordFilter class:

WordFilter(string[] words) Initializes the object with the words in the dictionary.
f(string prefix, string suffix) Returns the index of the word in the dictionary, which has the prefix prefix and the suffix suffix. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
 

Example 1:

Input
["WordFilter", "f"]
[[["apple"]], ["a", "e"]]
Output
[null, 0]

Explanation
WordFilter wordFilter = new WordFilter(["apple"]);
wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".
 

Constraints:

1 <= words.length <= 15000
1 <= words[i].length <= 10
1 <= prefix.length, suffix.length <= 10
words[i], prefix and suffix consist of lower-case English letters only.
At most 15000 calls will be made to the function f.


class WordFilter {

    private TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int length = s.length();
            for (int j = 0; j < length; j++) {
                insert(s.substring(j, length) + '{' + s, i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return startsWith(suffix + '{' + prefix);
    }
    
    private void insert(String s, int i) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.index = i;
        }
    }
    
    private int startsWith(String starts) {
        TrieNode node = root;
        for (char ch : starts.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return -1;
            }
            node = node.children[index];
        }
        return node.index;
    }
}

class TrieNode {
    TrieNode [] children;
    int index;
    public TrieNode() {
        this.children =  new TrieNode [27]; // we are adding 26 alphabets + extra char
        this.index = index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */