// reference : https://youtu.be/t5amQL_LJjo


class Solution
{
    public:
    long long findMaxSubsetSum(long long a[], int n)
    {
        //code here
        long long SMALL = -1000000000000000L;
        // we can either take the ith element or i + 1th element
        // should not take 2 consecutive element 
        // dp[i][0] = means we need to take the ith element
        // dp[i][1] = means either ith element or i + 1th element which is giving us max result
        long long dp[n + 1][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = SMALL;
            dp[i][1] = SMALL;
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][1] + a[i - 1];
            dp[i][1] = max(dp[i - 1][0], dp[i - 1][1] + a[i - 1]);
        }
        return max(dp[n][0], dp[n][1]);
    }
