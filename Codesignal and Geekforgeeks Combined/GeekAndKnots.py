class Solution:
    def knots(self, M, N, K):
        val=max(M,N)
        dp=[0]*(val+1)
        dp[0]=1
        dp[1]=1
        for i in range(2,len(dp)):
            dp[i]=i*dp[i-1]
        v1=dp[M]//(dp[M-K]*dp[K])  # selecting K things out of M things
        v2=dp[N]//(dp[N-K]*dp[K])  # selecting K things out of N things
        return (v1*v2)%(10**9+7)