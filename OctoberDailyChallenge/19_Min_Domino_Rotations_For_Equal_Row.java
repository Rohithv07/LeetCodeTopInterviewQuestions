In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

 

Example 1:


Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
 

Constraints:

2 <= A.length == B.length <= 2 * 104
1 <= A[i], B[i] <= 6


// there are 4 different possibilities here
// 1. Make everything in A matches A[0]
// 2. Make everything in B matches A[0]
// 3. Make everything in A matches B[0]
// 4. Make everything in B matches B[0]

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        // lets have our returning statement
        int swaps = Math.min(
        numberOfSwaps(A[0], A, B),   // means make everything in A matches A[0]
        numberOfSwaps(A[0], B, A)    // means make everything in B matches A[0]
        );
         
        // now we have dealt with 2 possibilities and 2 remains
        swaps = Math.min(swaps, numberOfSwaps(B[0], A, B));  // means make everything in A matches B[0]
        swaps = Math.min(swaps, numberOfSwaps(B[0], B, A));  // means make everything in B matches A[0]
        
        return swaps == Integer.MAX_VALUE ? -1 : swaps;
    }
    // lets complete our numberOfSwapsFunction
    public int numberOfSwaps(int target, int [] A, int [] B) {
        int count = 0;
        // we can only make a swap if element say A[index] != target but B[index] = target, if both of them are not equal to 
        // target, then we cannot make any swaps and we return Integer.MAX_VALUE
        for (int i=0; i<A.length; i++) {
            // both do not equal to the target
            if (A[i] != target && B[i] != target)
                return Integer.MAX_VALUE;
            else if (A[i] != target)
                count += 1;
        }
        return count;
    }
}
