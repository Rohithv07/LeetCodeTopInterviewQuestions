// https://practice.geeksforgeeks.org/contest/interview-series-62/problems/#

// https://www.youtube.com/watch?v=Ngfzp9d6YYk&t=480s



//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int n, String s, int x) 
    { 
        // code here
        // each of the wifi can cover a range like from i - x to i + x
        // we just need to track this range and find is there any or point where
        // the wifi is not covered
        
        int [] range = new int [n + 2]; // why n + 2, otherwise n + 1would become out of bound
        // this is range update algorithm
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                int left = i - x;
                int right = i + x;
                if (left < 0) {
                    left = 0;
                }
                if (right > n) {
                    right = n;
                }
                range[left]++;
                range[right + 1]--;
            }
        }
        for (int i = 1; i <= n; i++) {
            range[i] += range[i - 1];
        }
        for (int i = 0; i < n; i++) {
            if (range[i] == 0) {
                // this is not covered
                return false;
            }
        }
        return true;
    }
} 