Given a sequence of numbers in an array, find the length of its longest increasing subsequence (LIS).
The longest increasing subsequence is a subsequence of a given sequence in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous or unique.

Example

For sequence = [1, 231, 2, 4, 89, 32, 12, 234, 33, 90, 34, 100], the output should be
longestIncreasingSubsequence(sequence) = 7.

The LIS itself is [1, 2, 4, 32, 33, 34, 100].


Solution:

int longestIncreasingSubsequence(int[] sequence) {
    int [] dp = new int [sequence.length];
    int max = 0;
    for (int i=0; i<sequence.length; i++) {
        dp[i] = 1;
    }
    for (int i=1; i<sequence.length; i++) {
        for (int j=0; j<i; j++) {
            if (sequence[i] > sequence[j] && dp[i] < dp[j] + 1)
                dp[i] = dp[j] + 1;
        }
    }
    for (int i=0; i<dp.length; i++) {
        if (max < dp[i])
            max = dp[i];
    }
    return max;
}

