Given an array of integers of size N and a number K., Your must modify array arr[] exactly K number of times. Here modify array means in each operation you can replace any array element either arr[i] by -arr[i] or -arr[i] by arr[i]. You need to perform this operation in such a way that after K operations, the sum of the array must be maximum.


Example 1:

Input:
N = 5, K = 1
arr[] = {1, 2, -3, 4, 5}
Output:
15
Explanation:
We have k=1 so we can change -3 to 3 and
sum all the elements to produce 15 as output.
Example 2:

Input:
N = 10, K = 5
arr[] = {5, -2, 5, -4, 5, -12, 5, 5, 5, 20}
Output:
68
Explanation:
Here  we have k=5 so we turn -2, -4, -12 to
2, 4, and 12 respectively. Since we have
performed 3 operations so k is now 2. To get
maximum sum of array we can turn positive
turned 2 into negative and then positive
again so k is 0. Now sum is
5+5+4+5+12+5+5+5+20+2 = 68

Your Task:
You don't have to print anything, print ting is done by the driver code itself. You have to complete the function maximizeSum() which takes the array A[], its size N, and an integer K as inputs and returns the maximum possible sum.


Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
-109 ≤ Ai ≤ 109



class Solution {

    public static long maximizeSum(long a[], int n, int k)
    {
        // Your code goes here  
        if (a == null || n == 0) {
            return 0;
        }
        Arrays.sort(a);
        int i = 0;
        long answer = 0;
        while (k > 0) {
            if (i == n) {
                i = n - 1;
            }
            if (a[i] == 0) {
                k = 0;
            }
            else {
                a[i] = -1 * a[i];
                k--;
                if (i == n - 1) {
                    continue;
                }
                if (a[i + 1] < 0 || a[i] > a[i + 1]) {
                    i++;
                }
            }
        }
        for (i=0;i<n; i++) {
            answer += a[i];
        }
        return answer;
    }
}