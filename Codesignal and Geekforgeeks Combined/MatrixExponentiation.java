Given an equation of the form f(n) = f(n-1) + f(n-2) where f(0) = 1, F(1) = 1 , the task is to find the nth term of this sequence.
 

Example 1:

Input: n = 3
Output: 3
Explanation: f(3) = f(2) + f(1) = 3

Example 2:

Input: n = 2
Output: 2
Explanation: f(2) = f(1) + f(0) = 2
 

Yout Task:
You don't need to read or print anything. Your task is to complete the function FindNthTerm() which takes n as input parameter and returns nth term mod 10^9+7 .


Expected Time Compelxity: O(log(n))
Expected Space Complexity: O(K) where K is constant.
 

Constraints:
1 <= n <= 109



class Solution
{
  long mod=(long)1e9+7;
   void multiply(long arr[][],long arr1[][])
   {
       long ans[][]=new long[2][2];
       long x=(arr[0][0]%mod*arr1[0][0]%mod+arr[0][1]%mod*arr1[1][0]%mod)%mod;
       long y=(arr[0][0]%mod*arr1[0][1]%mod+arr[0][1]%mod*arr1[1][1]%mod)%mod;
       long z=(arr[1][0]%mod*arr1[0][0]%mod+arr[1][1]%mod*arr1[1][0]%mod)%mod;
       long w=(arr[1][0]%mod*arr1[0][1]%mod+arr[1][1]%mod*arr1[1][1]%mod)%mod;
       arr[0][0]=x%mod;
       arr[0][1]=y%mod;
       arr[1][0]=z%mod;
       arr[1][1]=w%mod;
   
   }
 
   void solve(long arr[][],int n)
   {
        if(n==0||n==1)
       return ;
       long f[][]= new long[][]{{1,1},{1,0}};
       solve(arr,n/2);
       multiply(arr,arr);
       if(n%2==1)
       multiply(arr,f);
   }
   public int FindNthTerm(int n)
   {
   long arr[][]=new long [][]{{1,1},{1,0}};
    if(n==0)
    return 0;
   solve(arr,n);
     return (int) arr[0][0];
   }
}