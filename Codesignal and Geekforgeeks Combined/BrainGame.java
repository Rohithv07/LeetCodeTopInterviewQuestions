2 players A and B take turns alternatively to play a game in which they have N numbers on a paper. In one turn, a player can replace one of the numbers by any of its factor (except for 1 & the number itself). The player who is unable to make a move looses the game. Find the winner of the game if A starts the game and both play optimally.
 

Example 1:

Input: nums = [5, 7, 3]
Output: B
Explanation: Since all the numbers are prime,
so A will not be able to make the first move. 

Example 2:

Input: nums = [2, 4, 7, 11]
Outptut: A
Explanation: In the first move A will replace 4
by 2, so the numbers will become [2, 2, 7, 11]
now B will not be able to make a move since all 
the remaining numbers can only be divided by 1 
or the number itself.  

Your Task:
You don't need to read or print anything. Your task is to complete the function brainGame() which takes the list of numbers as input parameter and returns true if A wins and false if B wins.
 

Expected Time Complexity: O(N2)
Expected Space Complexity: O(N)
 

Constraints
1 <= N <= 1000
1 <= nums[i] <= 1000


//User function Template for Java

class Solution
{
    public boolean brainGame(int[] nums)
    {
        // Code here
        int [] primeTrack = new int [1001];
        for (int i = 2; i < 1001; i++) {
            for (int j = 2 * i; j < 1001; j += i) {
                primeTrack[j] = Math.max(primeTrack[j], 1 + primeTrack[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count ^= primeTrack[nums[i]];
        }
        return count != 0;
    }
}