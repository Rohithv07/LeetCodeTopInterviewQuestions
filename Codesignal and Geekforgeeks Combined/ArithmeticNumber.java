// https://practice.geeksforgeeks.org/contest/interview-series-44/problems/


class Solution{
    static int inSequence(int a, int b, int c){
        // code here
        if (c == 0) {
            return a == b ? 1 : 0;
        }
        long n = ((b - a) / c) + 1;
        if (n <= 0) {
            return 0;
        }
        long correct = a + (n - 1) * c;
        return correct == b ? 1 : 0;
    }
}