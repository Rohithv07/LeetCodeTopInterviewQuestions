We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.

The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].

The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].

Return true if and only if the number of global inversions is equal to the number of local inversions.

Example 1:

Input: A = [1,0,2]
Output: true
Explanation: There is 1 global inversion, and 1 local inversion.
Example 2:

Input: A = [1,2,0]
Output: false
Explanation: There are 2 global inversions, and 1 local inversion.
Note:

A will be a permutation of [0, 1, ..., A.length - 1].
A will have length in range [1, 5000].
The time limit for this problem has been reduced.


class Solution {
    public boolean isIdealPermutation(int[] A) {
        // all global inversions are local inversions
        // if they  are equal then we cannot find A[i] > A[j] with i + 2 <= j
        int currentMax = 0;
        int length = A.length;
        for (int i=0; i<length - 2; i++) {
            currentMax = Math.max(currentMax, A[i]);
            if (currentMax > A[i + 2])
                return false;
        }
        return true;
        
        
        /*// brute force
        int global = findGlobal(A);
        int local = findLocal(A);
        return global == local;
    }
    
    public int findGlobal(int [] A) {
        int global = 0;
        int length = A.length;
        for (int i=0; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                if (A[i] > A[j])
                    global += 1;
            }
        }
        return global;
    }
    
    public int findLocal(int [] A) {
        int local = 0;
        int length = A.length;
        for (int i=0; i<length - 1; i++) {
            if (A[i] > A[i + 1])
                local += 1;
        }
        return local;
    }*/
    }
}
