/*
 * Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.


class Solution {
    
    private TrieNode root;
    
    public Solution() {
        this.root = new TrieNode();
    }
    
    private void insert(String s) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = s;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return result;
        }
        int row = board.length;
        int col = board[0].length;
        TrieNode node = root;
        for (String word : words) {
            insert(word);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // do dfs from each and every cell
                dfs(i, j, board, result, node);
            }
        }
        return result;
    }
    
    private void dfs(int i, int j, char [][] board, List<String> result, TrieNode node) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '.') {
            return;
        }
        int index = board[i][j] - 'a';
        if (node.children[index] == null) {
            return;
        }
        node = node.children[index];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        char tempStore = board[i][j];
        board[i][j] = '.';
        dfs(i + 1, j, board, result, node);
        dfs(i - 1, j, board, result, node);
        dfs(i, j - 1, board, result, node);
        dfs(i, j + 1, board, result, node);
        board[i][j] = tempStore;
    }
}

class TrieNode {
    String word;
    TrieNode [] children;
    
    public TrieNode() {
        this.children = new TrieNode[26];
    }
}
 */