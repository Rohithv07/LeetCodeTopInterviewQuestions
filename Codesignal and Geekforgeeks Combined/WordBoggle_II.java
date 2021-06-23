Given a dictionary of words and an M x N board where every cell has one character. Find all possible different words from the dictionary that can be formed by a sequence of adjacent characters on the board. We can move to any of 8 adjacent characters, but a word should not have multiple instances of the same cell.


Example 1:

Input: 
N = 1
dictionary = {"CAT"}
R = 3, C = 3
board = {{C,A,P},{A,N,D},{T,I,E}}
Output:
CAT
Explanation: 
C A P
A N D
T I E
Words we got is denoted using same color.
Example 2:

Input:
N = 4
dictionary = {"GEEKS","FOR","QUIZ","GO"}
R = 3, C = 3 
board = {{G,I,Z},{U,E,K},{Q,S,E}}
Output:
GEEKS QUIZ
Explanation: 
G I Z
U E K
Q S E 
Words we got is denoted using same color.

Your task:
You don’t need to read input or print anything. Your task is to complete the function wordBoggle() which takes the dictionary contaning N space-separated strings and R*C board as input parameters and returns a list of words that exist on the board (NOTE: All words returned must be different even it occurs multiple times in the dictionary).


Expected Time Complexity: O(4^(N^2))
Expected Auxiliary Space: O(N^2)


Constraints:
1 ≤ N ≤ 15
1 ≤ R, C ≤ 50
1 ≤ length of Word ≤ 60
All words of Dictionary and all characters of board are in uppercase letters from 'A' to 'Z'

class Solution
{
    
    private TrieNode root = new TrieNode();
    
    public void insert(String [] words) {
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch;
                if (node.child[index] == null) {
                    node.child[index] = new TrieNode();
                }
                node = node.child[index];
            }
            node.word = word;
        }
    }
    
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        int row = board.length;
        int col = board[0].length;
        List<String> result = new ArrayList<>();
        insert(dictionary);
        // for (String word : dictionary) {
        //     insert(word);
        // }
        TrieNode node = root;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                dfsFind(board, node, i, j, result);
            }
        }
        String [] finalResult = new String [result.size()];
        for (int i=0; i<result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
    
    public void dfsFind(char [][] board, TrieNode node, int i, int j, List<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || node.child[board[i][j]] == null)
            return;
        char temp = board[i][j];
        node = node.child[temp];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        dfsFind(board, node, i+1, j, result);
        dfsFind(board, node, i-1, j, result);
        dfsFind(board, node, i, j+1, result);
        dfsFind(board, node, i, j-1, result);
        dfsFind(board, node, i+1, j+1, result);
        dfsFind(board, node, i+1, j-1, result);
        dfsFind(board, node, i-1, j+1, result);
        dfsFind(board, node, i-1, j-1, result);
        board[i][j] = temp;
    }
}

class TrieNode {
    String word;
    TrieNode [] child = new TrieNode[256];
}
