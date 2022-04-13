Given a grid with dimensions r x c, the two players (say JON and ARYA ) can move the coin over the grid satisfying the following rules:

There is a coin on (1,1) cell initially.
JON will move first.
Both will play on alternate moves.
In each move they can place coin on following positions if current position of coin is x,y
(x+1,y), (x+2,y), (x+3,y), (x,y+1), (x,y+2), (x,y+3), (x,y+4), (x,y+5), (x,y+6)
They can't go outside the grid.
Player who cannot make any move will lose this game.
Both play optimally.

Example 1:

Input: r = 1, c = 2
Output: JON 
Explanation: ARYA lost the game because
he won't able to move after JON's move.  

Example 2:

Input: r = 2, c = 2
Output: ARYA
Explanation: After first move by JON(1,2 or 2,1)
and second move by ARYA(2,2) JON won't able to
move so ARYA wins.   

Your Task:  
You dont need to read input or print anything. Complete the function movOnGrid() which takes r and c as input parameter and returns the name of the winner ( either JON or ARYA).

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 <= r, c <=105


//User function Template for Java
class Solution
{
    public String movOnGrid(int r, int c)
    {
        // code here
        c = (c - 1) & 3;
        r = (r - 1) % 7;
        return r == c ? "ARYA" : "JON";
    }
}