Given a string str of length N, you have to find number of palindromic subsequence (need not necessarily be distinct) which could be formed from the string str.
Note: You have to return the answer module 109+7;
 

Example 1:

Input: 
Str = "abcd"
Output: 
4
Explanation:
palindromic subsequence are : "a" ,"b", "c" ,"d"
 

Example 2:

Input: 
Str = "aab"
Output: 
4
Explanation:
palindromic subsequence are :"a", "a", "b", "aa"
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function countPs() which takes a string str as input parameter and returns the number of palindromic subsequence.
 

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N*N)


Constraints:
1<=length of string str <=1000



class Solution
{
    long mod=1000000007;
    long[][] dp;
    long countPS(String str)
    {
        // Your code here
        int n=str.length();
        dp=new long[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        long ans=countPs(str,0,n-1);
        return ans<0?ans+mod:ans;
    }
    
    long countPs(String p,int i,int j){
        if(i>j) return dp[i][j]=0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==j) return dp[i][j]=1;

        if(p.charAt(i)==p.charAt(j)){
            return dp[i][j]=(1+countPs(p,i,j-1)%mod+countPs(p,i+1,j)%mod)%mod;
        }else{
            return dp[i][j]=(countPs(p,i,j-1)%mod+countPs(p,i+1,j)%mod-countPs(p,i+1,j-1)%mod)%mod;
        }
    }
}