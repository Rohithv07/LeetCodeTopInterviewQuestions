Given an NxN chessboard and a Knight at position (x, y). The Knight has to take exactly K steps, where at each step it chooses any of the 8 directions uniformly at random. Find the probability that the Knight remains in the chessboard after taking K steps, with the condition that it cant enter the board again once it leaves it.
 

Example 1:

Input : N = 8, x = 0, y = 0, K = 3
Output: 0.125000
Example 2:

Input: N = 4, x = 1, y = 2, k = 4
Output: 0.024414
 

Your Task: 
You don't need to read or print anything. Your task is to complete the function findProb() which takes N, x, y and K as input parameter and returns the probability.
 

Expected Time Complexity : O(N 3)
Expected Space Complexity: O(N3)
 

Constraints:
1 <= N <= 100
0 <= x, y <= N

0 <= K <= N




class Solution
{
    public static boolean isValid(int ni, int nj, int n){
      return ni >= 0 && nj >= 0 && ni < n && nj < n;
    }
   public double findProb(int N, int start_x, int start_y, int step)
   {
       // Code here
       // findprob - custom function code
       
       double curr[][] = new double[N][N];
       double next[][] = new double[N][N];
 
   curr[start_x][start_y] = 1;
 
   for (int m = 1; m<=step; m++){
     
       for (int i = 0; i<N; i++){
           for (int j = 0; j<N; j++){
               if(curr[i][j] != 0){
                 
                 int ni = 0;
                 int nj = 0;
                 
                 ni = i-2;
                 nj = j+1;
                 if(isValid(ni, nj, N)){
                     next[ni][nj] += curr[i][j]/8.0;
                 }
                 
                 ni = i-1;
                 nj = j+2;
                 if(isValid(ni, nj, N)){
                     next[ni][nj] += curr[i][j]/8.0;
                 }
                 
                 ni = i+1;
                 nj = j+2;
                 if(isValid(ni, nj, N)){
                     next[ni][nj] += curr[i][j]/8.0;
                 }
                 
                 ni = i+2;
                 nj = j+1;
                 if(isValid(ni, nj, N)){
                     next[ni][nj] += curr[i][j]/8.0;
                 }
                 
                 ni = i+2;
                 nj = j-1;
                 if(isValid(ni, nj, N)){
                     next[ni][nj] += curr[i][j]/8.0;
                 }
                 
                 ni = i+1;
                 nj = j-2;
                 if(isValid(ni, nj, N)){
                     next[ni][nj] += curr[i][j]/8.0;
                 }
                 
                 ni = i-1;
                 nj = j-2;
                 if(isValid(ni, nj, N)){
                     next[ni][nj] += curr[i][j]/8.0;
                 }
                 
                 ni = i-2;
                 nj = j-1;
                 if(isValid(ni, nj, N)){
                     next[ni][nj] += curr[i][j]/8.0;
               }
                 
               }
           }
       }
     
       curr = next;
       next = new double[N][N];
     
     
   }
 
   double sum = 0;
   for (int i = 0; i<N; i++){
       for (int j = 0; j<N; j++){
           sum += curr[i][j];
       }
   }
       
       return sum;
   }
}