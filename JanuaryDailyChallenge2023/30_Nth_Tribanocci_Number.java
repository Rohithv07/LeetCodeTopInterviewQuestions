class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int third = 1;
        for (int i = 3; i <= n; i++) {
            int store = first + second + third;
            first = second;
            second = third;
            third = store;
        }
        return third;
    }
}