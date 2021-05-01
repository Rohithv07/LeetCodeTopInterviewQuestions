Design a special dictionary which has some words and allows you to search the words in it by a prefix and a suffix.

Implement the WordFilter class:

WordFilter(string[] words) Initializes the object with the words in the dictionary.
f(string prefix, string suffix) Returns the index of the word in the dictionary which has the prefix prefix and the suffix suffix. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
 

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
    class TrieNode {
        TrieNode[] children;
        int weight;
        public TrieNode() {
            children = new TrieNode[27];
            weight = 0;
        }
        
        public void insert(String s, int weight) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                int n = c - 'a';
                if (cur.children[n] == null) {
                    cur.children[n] = new TrieNode();
                }
                cur = cur.children[n];
                cur.weight = weight;
            }
        }
        
        public int startsWith(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                TrieNode next = cur.children[c - 'a'];
                if (next == null) {
                    return -1;
                }
                cur = next;
            }
            return cur.weight;
        }
    }
    
    TrieNode root;
    
    // apple -> {apple, e{apple, le{apple, ple{apple, pple{apple, apple{apple;
    public WordFilter(String[] words) {
        root = new TrieNode();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            String s = words[i];
            for (int j = 0; j <= s.length(); j++) {
                root.insert(s.substring(j, s.length()) + '{' + s, i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return root.startsWith(suffix + '{' + prefix);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
