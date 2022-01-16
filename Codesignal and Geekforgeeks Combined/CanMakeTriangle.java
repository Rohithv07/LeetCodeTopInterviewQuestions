// https://practice.geeksforgeeks.org/contest/interview-series-phonepe/instructions/#

//User function Template for Java
class Solution 
{ 
    int[] canMakeTriangle(int a[], int n) 
    { 
        // code here
        int [] result = new int [n - 2];
        int index = 0;
        for (int i=2; i<n; i++) {
            long sum1 = a[i - 2] + a[i - 1];
            long sum2 = a[i - 2] + a[i];
            long sum3 = a[i] + a[i - 1];
            if (sum1 > a[i] && sum2 > a[i - 1] && sum3 > a[i - 2]) {
                result[index++] = 1;
            }
            else {
                result[index++] = 0;
            }
        }
        return result;
    }
}