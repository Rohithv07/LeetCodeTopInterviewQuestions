Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of a given array of strings words.

For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y', and 'z', your algorithm should detect that the suffix "xyz" of the characters "axyz" matches "xyz" from words.

Implement the StreamChecker class:

StreamChecker(String[] words) Initializes the object with the strings array words.
boolean query(char letter) Accepts a new character from the stream and returns true if any non-empty suffix from the stream forms a word that is in words.
 

Example 1:

Input
["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
Output
[null, false, false, false, true, false, true, false, false, false, false, false, true]

Explanation
StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
streamChecker.query("a"); // return False
streamChecker.query("b"); // return False
streamChecker.query("c"); // return False
streamChecker.query("d"); // return True, because 'cd' is in the wordlist
streamChecker.query("e"); // return False
streamChecker.query("f"); // return True, because 'f' is in the wordlist
streamChecker.query("g"); // return False
streamChecker.query("h"); // return False
streamChecker.query("i"); // return False
streamChecker.query("j"); // return False
streamChecker.query("k"); // return False
streamChecker.query("l"); // return True, because 'kl' is in the wordlist
 

Constraints:

1 <= words.length <= 2000
1 <= words[i].length <= 2000
words[i] consists of lowercase English letters.
letter is a lowercase English letter.
At most 4 * 104 calls will be made to query.


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