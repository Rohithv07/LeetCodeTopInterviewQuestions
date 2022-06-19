
// question link : https://practice.geeksforgeeks.org/contest/interview-series-55/problems/#

// https://www.youtube.com/watch?v=XrniqNQe-R0
class Solution {
    public static int solve(int a, int b) {
        // code here
        if (a == b) {
            return 0;
        }
        if ((a & b) == Math.min(a, b)) {
            return 1;
        }
        return 2;
    }
}
        
