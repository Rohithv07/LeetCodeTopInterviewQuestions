// https://practice.geeksforgeeks.org/contest/interview-series-64/problems/#

// https://www.youtube.com/watch?v=oIo8kqdEgJk




class Solution {
    public static int getMaximum(int n, int[] arr) {
        // code here
        
        // the idea is the total number of cookies never changes
        // the change will be only in the number of bowls
        // suppose our total be = total
        // final bowl size = finalSize
        // and each bowl have equal cookies = p
        // therefore finalSize * p = total
        // we cannot break the cookies, so p must be a proper integer
        // which also means, total % finalSize == 0
        // and the finalSize can be in between [1, n]
        
        long total = 0;
        for (int num : arr) {
            total += num;
        }
        int finalSize = -1;
        for (int i = 1; i <= n; i++) {
            if (total % i == 0) {
                finalSize = i;
            }
        }
        return finalSize;
    }
}
        
