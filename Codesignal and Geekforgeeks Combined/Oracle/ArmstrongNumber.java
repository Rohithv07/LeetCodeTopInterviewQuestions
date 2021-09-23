//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        // code here
        if (n <= 1) {
            return "Yes";
        }
        int store = n;
        int sum = findCubicSum(n, 0);
        return sum == store ? "Yes" : "No";
        // int sum = 0;
        // while (n > 0) {
        //     int rem = n % 10;
        //     sum += rem * rem * rem;
        //     n /= 10;
        // }
        // return sum == store ? "Yes" : "No";
    }
    
    // using recursion
    static int findCubicSum(int n, int currentSum) {
        if (n <= 0)
            return currentSum;
        int rem = n % 10;
        currentSum += rem * rem * rem;
        return findCubicSum(n / 10, currentSum);
    }
}