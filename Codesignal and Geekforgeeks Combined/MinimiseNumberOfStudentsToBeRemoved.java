// https://www.youtube.com/watch?v=Wwi-K6rEAfU


class Solution {
    
    public int longestIncreasingSubsequence(int [] H, int N) {
        int [] dp = new int [N];
        dp[0] = H[0];
        int size = 1;
        for (int i=1; i<N; i++) {
            if (H[i] > dp[size - 1]) {
                dp[size] = H[i];
                size += 1;
            }
            else if (H[i] <  dp[size - 1]) {
                int index = binarySearchIndex(dp, 0, size - 1, H[i]);
                dp[index] = H[i];
            }
        }
        return size;
    }
    
    public int binarySearchIndex(int [] dp, int left, int right, int key) {
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (dp[mid] >= key) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    public int removeStudents(int[] H, int N) {
        // code here
        return N - longestIncreasingSubsequence(H, N);
    }
}




