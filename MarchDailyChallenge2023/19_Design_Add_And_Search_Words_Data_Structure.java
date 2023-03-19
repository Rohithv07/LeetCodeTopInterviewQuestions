class WordDictionary {


    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
                node.children[index].ch = ch;
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word.toCharArray(), 0, root);
    }

    private boolean searchHelper(char [] ch, int pos, TrieNode node) {
        if (ch.length == pos) {
            return node.isEnd;
        }
        if (ch[pos] == '.') {
            for (int i=0; i<26; i++) {
                if (node.children[i] != null && searchHelper(ch, pos + 1, node.children[i]))
                    return true;
            }
        }
        else {
            return node.children[ch[pos] - 'a'] != null && searchHelper(ch, pos + 1, node.children[ch[pos] - 'a']);
        }
        return false;
    }
}

class TrieNode {
    char ch;
    TrieNode [] children;
    boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */