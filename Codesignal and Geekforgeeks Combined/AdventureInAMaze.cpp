You have got a maze, which is a n*n Grid. Every cell of the maze contains these numbers 1, 2 or 3. 
If it contains 1 : means we can go Right from that cell only.
If it contains 2 : means we can go Down from that cell only.
If it contains 3 : means we can go Right and Down to both paths from that cell.
We cant go out of the maze at any time.
Initially, You are on the Top Left Corner of The maze(Entry). And, You need to go to the Bottom Right Corner of the Maze(Exit).
You need to find the total number of paths from Entry to Exit Point.
There may be many paths but you need to select that path which contains the maximum number of Adventure.
The Adventure on a path is calculated by taking the sum of all the cell values thatlies in the path.
 

Example 1:

Input: matrix = {{1,1,3,2,1},{3,2,2,1,2},
{1,3,3,1,3},{1,2,3,1,2},{1,1,1,3,1}}
Output: {4,18}
Explanation: There are total 4 Paths Available 
out of which The Max Adventure is 18. Total 
possible Adventures are 18,17,17,16. Of these 
18 is the maximum.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function FindWays() which takes matrix as input parameter and returns a list containg total number of ways to reach at (n, n) modulo 109 + 7 and maximum number of Adventure.
 

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n2)
 

Constraints:
1 <= n <= 100 '



class Solution {
public:
vector<int> FindWays(vector<vector<int>>&matrix){
   // Code here
   int n=matrix.size();
   const int MOD=1000000007;
   pair<int ,int> dp[n][n];
   
   for(int i=0; i<n; i++)
   {
       for(int j=0; j<n; j++)
       dp[i][j]={0, matrix[i][j]};
   }
    dp[0][0]={1,matrix[0][0]};
   for(int i=0; i<n; i++)
   {
       for(int j=0; j<n; j++)
       {
           if(i-1>=0 && (matrix[i-1][j]==3 || matrix[i-1][j]==2))
              {
                if(dp[i-1][j].first)
                dp[i][j]= {dp[i-1][j].first%MOD, dp[i-1][j].second+dp[i][j].second};
              }
           if(j-1>=0 && (matrix[i][j-1]==3|| matrix[i][j-1]==1))
           {
               int f=(dp[i][j].first+dp[i][j-1].first)%MOD;
               int s=dp[i][j].second;
               if(dp[i][j-1].first)
                s=(max(dp[i][j-1].second+matrix[i][j],dp[i][j].second))%MOD;
           
              dp[i][j]= {f,s};
           }
       }
   }
   vector<int> result;
   result.push_back(dp[n-1][n-1].first%MOD);
   if(dp[n-1][n-1].first)
   result.push_back(dp[n-1][n-1].second);
   else
   result.push_back(0);
   return result;
}
};