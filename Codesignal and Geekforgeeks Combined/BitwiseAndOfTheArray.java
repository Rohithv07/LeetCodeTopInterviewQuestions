Given an array A[ ] of N integers and an integer X. In one operation, you can change the ith element of the array to any integer value where 1 ≤ i ≤ N. Calculate minimum number of such operations required such that the bitwise AND of all the elements of the array is strictly greater than X.

Example 1:

Input:
N = 4, X = 2
A[] = {3, 1, 2, 7}
Output: 
2
Explanation: 
After performing two operations:
Modified array: {3, 3, 11, 7} 
Now, Bitwise AND of all the elements
is 3 & 3 & 11 & 7 = 3 
Example 2:

Input:
N = 3, X = 1
A[] = {2, 2, 2}
Output: 
0
Your Task:
You don't need to read input or print anything. Your task is to complete the function count( ) which takes N, A[ ] and X as input parameters and returns the minimum number of operations required.

Expected Time Complexity: O(N * Log(max(A[ ])))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 109
1 ≤ X ≤ 109

//User function Template for Java
class Solution 
{ 
    int count(int n, int a[], int x) 
    {   
        // code here
        int prefix = 0;
        int min = n;
        for (int i=30; i>=0; i--) {
            if (((x >> i) & 1) != 0) {
                prefix ^= (1l<<i);
                continue;
            }
            int count = 0;
            long p = prefix ^ (1l << i);
            for (int j=0; j<n; j++) {
                if ((a[j] & p) == p) {
                    count++;
                }
            }
            min = Math.min(min, n - count);
        }
        return min;
    }
} 


class Solution 
{ 
    int count(int n, int a[], int x) 
    {   
        // code here
        if (n == 1 && a[0] <= x) {
            return 1;
        }
        int totalAnd = a[0];
        for (int i = 1; i < n; i++) {
            totalAnd &= a[i];
        }
        if (totalAnd > x) {
            return 0;
        }
        int mask = 0;
        int result = n;
        for (int i = 31; i >= 0; i--) {
            if (((x >> i) & 1) == 1) {
                mask ^= (1 << i);
                continue;
            }
            int count = 0;
            int tempMask = mask ^ (1 << i);
            for (int num : a) {
                if ((num & tempMask) == tempMask) {
                    count++;
                }
            }
            result = Math.min(result, n - count);
        }
        return result;
    }
} 