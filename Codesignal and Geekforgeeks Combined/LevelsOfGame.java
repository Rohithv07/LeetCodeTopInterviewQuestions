You are playing a game. At each level of the game, you have to choose one of the roads to go to the next level. Initially, you have h amount of health and m amount of money.
If you take the first road then your health increases by 3 and money increase by 2. If you take the second road then your health decreases by 5 and money decrease by 10. If you take the third road then health decreases by 20 and money increase by 5.
You have to tell what is the maximum level you can reach up to under the constraints that in no two consecutive levels you can select the same road twice and once your health or money becomes <= 0 game ends(that level is not counted).

Example 1:

Input:
H=2
M=10
Output:
1
Explanation:
For the first level, we can only choose the first road.
Now we cannot move ahead anymore.
Example 2:

Input:
H=20
M=8
Output:
5
Explanation:
Go like this:- R1(23,10)->R3(3,15)->R1(6,17)->
R2(1,7)->R1(4,9)-> game ends as we cannot choose
any more roads.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxLevel() which takes in the health and the money as input and returns the maximum level that can be reached by you.

 

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N*N)


class Solution {
    public static int maxLevel(int h,int m) {
        // code here
        int [][] dp = new int [3001][3001];
        for (int i = 0; i <= 3000; i++) {
            Arrays.fill(dp[i], -1);
        }
        return levelFinder(dp, h, m, 0);
    }
    
    private static int levelFinder(int [][] dp, int h, int m, int previousChosen) {
        if (h <= 0 || m <= 0) {
            return -1;
        }
        if (dp[h][m] != -1) {
            return dp[h][m];
        }
        //dp[h][m] = 0;
        int r1 = -1;
        int r2 = -1;
        int r3 = -1;
        if (previousChosen != 1) {
            r1 = levelFinder(dp, h + 3, m + 2, 1);
        }
        if (previousChosen != 2) {
            r2 = levelFinder(dp, h - 5, m - 10, 2);
        }
        if (previousChosen != 3) {
            r3 = levelFinder(dp, h - 20, m + 5, 3);
        }
        //System.out.println(dp[h][m]);
        dp[h][m] = Math.max(r1, Math.max(r2, r3)) + 1;
        return dp[h][m];
    }
}
        
