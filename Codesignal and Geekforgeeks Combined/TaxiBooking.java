
// https://practice.geeksforgeeks.org/contest/interview-series-65/problems/



class Solution {
    public static int minimumTime(int n, int cur, int[] pos, int[] time) {
        // code here
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currentPos = pos[i];
            int currentTime = time[i];
            int currentTakenTime = Math.abs(cur - pos[i]) * currentTime;
            minimum = Math.min(minimum, currentTakenTime);
        }
        return minimum;
    }
}
        
