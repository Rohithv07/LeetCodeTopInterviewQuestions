This question is asked by Microsoft. Implement a trie class that supports insertion and search functionalities.
Note: You may assume only lowercase alphabetical characters will added to your trie.

Ex: Given the following operations on your trie…

Trie trie = new Trie()
trie.insert("programming");
trie.search("computer") // returns false.
trie.search("programming") // returns true.


public class TrieNode {
    private TrieNode [] links;
    private final int R = 26;
    private boolean isEnd;
    public TrieNode() {
        links = new TrieNode[R];
    }
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch-'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            char current = word.charAt(i);
            if (!node.containsKey(current))
                node.put(current, new TrieNode());
            node = node.get(current);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchForAPrefix(word);
        return node != null && node.isEnd();
    }
    public TrieNode searchForAPrefix(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            char current = word.charAt(i);
            if (node.containsKey(current))
                node = node.get(current);
            else
                return null;
        }
        return node;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchForAPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */