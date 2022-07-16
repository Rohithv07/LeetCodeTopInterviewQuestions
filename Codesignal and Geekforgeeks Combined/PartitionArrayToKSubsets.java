Given an integer array a[ ] of N elements and an integer K, the task is to check if the array a[ ] could be divided into K non-empty subsets with equal sum of elements.
Note: All elements of this array should be part of exactly one partition.

Example 1:

Input: 
N = 5
a[] = {2,1,4,5,6}
K = 3
Output: 
1
Explanation: we can divide above array 
into 3 parts with equal sum as (2, 4), 
(1, 5), (6)
Example 2:

Input: 
N = 5 
a[] = {2,1,5,5,6}
K = 3
Output: 
0
Explanation: It is not possible to divide
above array into 3 parts with equal sum.
Your Task:
You don't need to read input or print anything. Your task is to complete the function isKPartitionPossible() which takes the array a[], the size of the array N, and the value of K as inputs and returns true(same as 1) if possible, otherwise false(same as 0).

Expected Time Complexity: O(N*2N).
Expected Auxiliary Space: O(2N).

Constraints:
1 ≤ K ≤ N ≤ 10
1 ≤ a[i] ≤ 100


/*You are required to complete this method */

class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here	
	    if (n < k) {
	        return false;
	    }
	    int sum = 0;
	    for (int num : a) {
	        sum += num;
	    }
	    if (sum % k != 0) {
	        return false;
	    }
	    int [] parent = new int [k];
	    for (int i = 0; i < k; i++) {
	        parent[i] = sum / k;
	    }
	    return solve(a, n - 1, parent);
    }
    
    private boolean solve(int [] a, int n, int [] parent) {
        if (n == -1) {
            for (int i = 0; i < parent.length - 1; i++) {
                if (parent[i] != parent[i + 1]) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < parent.length; i++) {
            if (a[n] <= parent[i]) {
                parent[i] -= a[n];
                if (solve(a, n - 1, parent)) {
                    return true;
                }
                parent[i] += a[n];
            }
        }
        return false;
    }
}
