if (curr.next[word.charAt(i) - 'a'] == null) {
                curr.next[word.charAt(i) - 'a'] = new Trie();
            }
            curr = curr.next[word.charAt(i) - 'a'];
        }
        curr.word = true;
    }
    
    public StreamChecker(String[] words) {
        this.root = new Trie();
        for (String word : words) {
            insert(word);
        }
        this.history = new char[2000];
    }
    
    public boolean query(char letter) {
        // System.out.println("query " + letter);
        history[p % 2000] = letter;
        Trie curr = root;
        boolean match = false;
        for (int i = 0; i < 2000 && !match; i++) {
            char curChar = history[(p - i + 2000) % 2000];
            // System.out.println("look " + curChar);
            if (curChar == 0) {
                break;
            }
            if (curr.next[curChar - 'a'] != null) {
                curr = curr.next[curChar - 'a'];
                if (curr.word) {
                    match = true;
                    // System.out.println("match " + curChar);
                }
            } else {
                break;
            }
        }
        p++;
        return match;
    }
}
