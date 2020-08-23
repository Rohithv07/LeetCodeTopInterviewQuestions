Implement the StreamChecker class as follows:

StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 

Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 

Note:

1 <= words.length <= 2000
1 <= words[i].length <= 2000
Words will only consist of lowercase English letters.
Queries will only consist of lowercase English letters.
The number of queries is at most 40000.

Solution:

class StreamChecker {
    class Trie {
        boolean word;
        Trie[] next;
        public Trie() {
            this.next = new Trie[26];
            this.word = false;
        }
    }
    Trie root = null;
    int p = 0;
    char [] history;
    public void add(String word) {
        Trie current = root;
        for (int i=word.length()-1; i>=0; i--){
            if (current.next[word.charAt(i) - 'a'] == null) {
                current.next[word.charAt(i) - 'a'] = new Trie();
            }
            current = current.next[word.charAt(i) - 'a'];
        }
        current.word = true;
    }
    
    public StreamChecker(String[] words) {
        this.root = new Trie();
        for (String word : words) {
            add(word);
        }
        this.history = new char[2000];
    }
    
    public boolean query(char letter) {
        history[p % 2000] = letter;
        Trie curr = root;
        boolean match = false;
        for (int i = 0; i < 2000 && !match; i++) {
            char curChar = history[(p - i + 2000) % 2000];
            if (curChar == 0) {
                break;
            }
            if (curr.next[curChar - 'a'] != null) {
                curr = curr.next[curChar - 'a'];
                if (curr.word) {
                    match = true;
                }
            } else {
                break;
            }
        }
        p++;
        return match;
    }

}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
