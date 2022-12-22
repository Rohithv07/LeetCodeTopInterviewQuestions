You are given N balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array arr. You are asked to brust all the balloons.
If you brust the ith  balloon,, you will get arr[ i - 1 ] * arr[ i ] * arr[ i + 1] coins. If i - 1, or i + 1 goes out of bounds of the array, consider it as if there is a balloon with a 1 painted on it.
Return the maximum coins you can collect by brusting the balloons wisely.

Example 1:

Input:
N = 4
arr[ ] = {3, 1, 5, 8}
Output: 167
Explanation: 
arr[ ] = {3, 1, 5, 8}  - - > {3, 5, 8} - - > {3, 8} - - > { 8} - -> { }
coins = 3 *1 *5,      +      3*5*8     +   1*3*8   +  1*8*1   = 167
 
 

Example 2:

Input:
N = 2
arr[ ] = {1, 10}
Output: 20
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxCoins() which takes the array of integers arr and N as parameters and returns the maximum coin you can collect.

Expected Time Complexity: O(N*N*N)
Expected Auxiliary Space: O(N*N)

Constraints:
1 ≤ N ≤ 300
0 ≤ arr [ i ]  ≤ 100


class Solution {

    

    public static int f(int i,int j,int[] arr,int[][] dp)

    {

        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        

        int max=Integer.MIN_VALUE;

        for(int k=i;k<=j;k++)

        {

            int cost=arr[i-1]*arr[k]*arr[j+1]+f(i,k-1,arr,dp)+f(k+1,j,arr,dp);

            max=Math.max(max,cost);

        }

        

        return dp[i][j]=max;

    }

        

    public static int maxCoins(int N, int[] a) {

    

    int[] arr=new int[a.length+2];

    arr[0]=1;

    arr[a.length+1]=1;

    

    for(int i=0;i<a.length;i++)

        arr[i+1]=a[i];

        

    int[][] dp=new int[N+1][N+1];

        

    for(int[] p: dp)

        Arrays.fill(p,-1);

        

    return f(1,N,arr,dp);    

 

  }

}