class TrieNode {
    TrieNode [] child = new TrieNode[26];
    boolean isWord;
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.}




class WordDictionary {

    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] =  new TrieNode();
            }
            node = node.child[index];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return helper(word.toCharArray(), 0, root);
    }
    
    public boolean helper(char [] ch, int pos, TrieNode node) {
        if (ch.length == pos) {
            return node.isWord;
        }
        if (ch[pos] == '.') {
            for (int i=0; i<26; i++) {
                if (node.child[i] != null && helper(ch, pos + 1, node.child[i]))
                    return true;
            }
        }
        else {
            return node.child[ch[pos] - 'a'] != null && helper(ch, pos + 1, node.child[ch[pos] - 'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */