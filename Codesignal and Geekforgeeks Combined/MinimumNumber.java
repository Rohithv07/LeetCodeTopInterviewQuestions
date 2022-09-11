// https://www.youtube.com/watch?v=zA4PpSPDh30

// https://practice.geeksforgeeks.org/contest/interview-series-67/problems/#

class Solution {
    public static int minimumNumber(int n, int[] arr) {
        // code here
        
        // we need to find the GCD
        int result = arr[0];
        for (int i = 1; i < n; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
        
    }
    
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
        