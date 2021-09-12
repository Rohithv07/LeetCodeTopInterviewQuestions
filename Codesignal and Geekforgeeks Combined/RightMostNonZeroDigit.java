You will be given an array A of N non-negative integers. Your task is to find the rightmost non-zero digit in the product of array elements.


Example 1:

Input:
N = 4, A = {3, 23, 30, 45}
Output:
5
Explanation:
Product of these numbers 
are 93150.Rightmost 
non-zero digit is 5.
Example 2:

Input:
N = 5, A = {1, 2, 3, 4, 5}
Output:
2
Explanation:
Product of these numbers 
are 120. Rightmost 
non-zero digit is 2.

Your Task:

You don't need to read input or print anything. Your task is to complete the function rightmostNonZeroDigit() which takes an array A and returns the rightmost non-zero digit in the product of array elements, if there is no right most non zero digit, then return -1.


Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
0 ≤ A[i] ≤ 105 


class Solution{
    static int rightmostNonZeroDigit(int n, int[] a){
        // code here
        if (a == null || n == 0) {
            return -1;
        }
        int count = 0;
        for (int i=0; i<n; i++) {
            while (a[i] > 0 && a[i] % 5 == 0) {
                a[i] /= 5;
                count++;
            }
        }
        for (int i=0; i<n; i++) {
            while (count !=0 && a[i] > 0 && a[i] % 2 == 0) {
                a[i] /= 2;
                count--;
            }
        }
        int answer = 1;
        for (int i=0; i<n; i++) {
            answer = (answer * a[i] % 10) % 10;
        }
        if (count != 0) {
            answer = (answer * 5) % 10;
        }
        if (answer != 0) {
            return answer;
        }
        return -1;
    }
}