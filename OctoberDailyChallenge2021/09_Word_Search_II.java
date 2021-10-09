Given an m x n board of characters and a list of strings words, return all words on the board.

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
    private TrieNode root = new TrieNode();
    
    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }
        node.word = word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        int row = board.length;
        int col = board[0].length;
        TrieNode node = root;
        List<String> result = new ArrayList<>();
        for (String word : words) {
            insert(word);
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                dfs(board, node, i, j, result);
            }
        }
        return result;
    }
    
    public void dfs(char [][] board,  TrieNode node, int i, int j, List<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '.' || node.child[board[i][j] - 'a'] == null) {
            return;
        }
        char temp = board[i][j];
        node = node.child[temp - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[i][j] = '.';
        dfs(board, node, i+1, j, result);
        dfs(board, node, i-1, j, result);
        dfs(board, node, i, j-1, result);
        dfs(board, node, i, j+1, result);
        board[i][j] = temp;
    }
}

class TrieNode {
    String word;
    TrieNode [] child = new TrieNode[26];
}