Given an array of size N containing positive integers n and a number k,The absolute difference between values at indices i and j is |a[i] – a[j]|. There are n*(n-1)/2 such pairs and you have to print the kth smallest absolute difference among all these pairs.
 

Example 1:

Input : 
N = 4
A[] = {1, 2, 3, 4}
k = 3
Output : 
1 
Explanation :
The possible absolute differences are :
{1, 2, 3, 1, 2, 1}.
The 3rd smallest value among these is 1.
 
Example 2:
Input : 
N = 2
A[] = {10, 10}
k = 1
Output :
0

Your Task:  
You don't need to read input or print anything. Your task is to complete the function kthDiff() which takes the array A[], its size N and an integer k as inputs and returns the kth smallest absolute difference among all these pairs.

 

Expected Time Complexity: O( N. (Log(N))2 )
Expected Auxiliary Space: O(Log(N))

 

Constraints:
1<=N<=105
1<=a[i]<=105
1 <= k <= n*(n-1)/2








// returns number of pairs with absolute difference
// less than or equal to mid.
int countPairs(int *a, int n, int mid) {
    int res = 0;
    for (int i = 0; i < n; ++i)

        // Upper bound returns pointer to position
        // of next higher number than a[i]+mid in
        // a[i..n-1]. We subtract (a + i + 1) from
        // this position to count
        res += upper_bound(a + i, a + n, a[i] + mid) - (a + i + 1);
    return res;
}

// Returns k-th absolute difference
int kthDiff(int a[], int n, int k) {
    // Sort array
    sort(a, a + n);

    // Minimum absolute difference
    int low = a[1] - a[0];
    for (int i = 1; i <= n - 2; ++i) low = min(low, a[i + 1] - a[i]);

    // Maximum absolute difference
    int high = a[n - 1] - a[0];

    // Do binary search for k-th absolute difference
    while (low < high) {
        int mid = (low + high) >> 1;
        if (countPairs(a, n, mid) < k)
            low = mid + 1;
        else
            high = mid;
    }

    return low;
}