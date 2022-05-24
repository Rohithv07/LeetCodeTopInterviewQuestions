Given an array of N integers, you have to find if it is possible to partition the array with following rules:

Each element should belong to exactly one partition.
Each partition should have atleast K elements.
Absolute difference between any pair of elements in the same partition should not exceed M.
Example 1:

Input:
N = 5
K = 2
M = 3
A[] = {8, 3, 9, 1, 2}
Output:
YES
Explanation:
We can partition the array into two 
partitions: {8, 9} and {3, 1, 2} such that
all rules are satisfied.
Your Task:
You don't need to read input or print anything. Your task is to complete the function partitionArray() which takes the number of elements N, integer K, integer M and array A[ ] as input parameters and returns true if we can partition the array such that all rules are satisfied, else returns false.

Expected Time Complexity: O(N * Log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 2*105
1 ≤ K ≤ N
1 ≤ M ≤ 109
1 ≤ A[i] ≤ 109


// Simple Recursive Approach
class Solution{
    boolean rec( int start , int[] A , int K , int M ){
        int n = A.length ;
        if(start >= n)
            return true ;
        for ( int i = start + K - 1 ; i < n ; i ++ ){
            if( (A[i] - A[start]) > M)
                return false ;
            if(rec(i+1 , A , K , M ))
                return true ;
            
        }
        return false ;
    }
	boolean partitionArray(int N, int K, int M, int [] A){
        // code here
        Arrays.sort(A);
        return rec(0 , A , K , M ) ; 
    }
}