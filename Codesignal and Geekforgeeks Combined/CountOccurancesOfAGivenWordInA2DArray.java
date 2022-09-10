Find the number of occurrences of a given search word in  a 2d-Array of characters where the word can go up, down, left, right and around 90 degree bends.


Example 1:

Input: 
R = 4, C = 5
mat = {{S,N,B,S,N},
       {B,A,K,E,A},
       {B,K,B,B,K},
       {S,E,B,S,E}}
target = SNAKES
Output:
3
Explanation: 
S N B S N
B A K E A
B K B B K
S E B S E
Total occurrence of the word is 3
and denoted by color.
Example 2:

Input:
R = 3, C = 3 
mat = {{c,a,t},
       {a,t,c},
       {c,t,a}}
target = cat
Output:
5
Explanation: Same explanation
as first example.

Your task:
You dont need to read input or print anything. Your task is to complete the function findOccurrence() which takes the mat contaning N*M 2-d array of character and target as input parameters and returns thethe number of occurrences of target.


Expected Time Complexity: O(R*C*22*len), Where len is length of target String.
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ len ≤ 15
1 ≤ R, C ≤ 50


//User function Template for Java
class Solution {

    public int findOccurrence(char board[][],String word) {
        int ans = 0;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                ans += exist(board, i, j, word, 0);
            }
        }
        return ans;
    }
    int exist(char[][] board, int i, int j, String word,int ind) {
        int found = 0;
        if(i<board.length && i>=0 && j<board[0].length && j>=0 && word.charAt(ind)==board[i][j]){
            board[i][j] = ' ';
            if (ind == word.length()-1) {
                found = 1;
            } else {
               found += exist(board,i,j-1,word,ind+1);
               found += exist(board,i,j+1,word,ind+1);
               found += exist(board,i-1,j,word,ind+1);
               found += exist(board,i+1,j,word,ind+1);
            }
            board[i][j] = word.charAt(ind);
        }
        return found;
    }
}