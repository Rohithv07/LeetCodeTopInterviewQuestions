Given a 2D matrix M of dimensions RxC. Find the maximum sum submatrix in it.

Example 1:

Input:
R=4
C=5
M=[[1,2,-1,-4,-20],
[-8,-3,4,2,1],
[3,8,10,1,3],
[-4,-1,1,7,-6]]
Output:
29
Explanation:
The matrix is as follows and the
blue rectangle denotes the maximum sum
rectangle.
Thumbnail
Example 2:

Input:
R=2
C=2
M=[[-1,-2],[-3,-4]]
Output:
-1
Explanation:
Taking only the first cell is the 
optimal choice.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maximumSumRectangle() which takes the number R, C, and the 2D matrix M as input parameters and returns the maximum sum submatrix.


Expected Time Complexity:O(R*R*C)
Expected Auxillary Space:O(R*C)
 

Constraints:
1<=R,C<=500
-1000<=M[i][j]<=1000


class Solution {
    int maximumSumRectangle(int r, int c, int m[][]) {
        // code here
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            int [] store = new int [c];
            for (int j = i; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    store[k] += m[j][k];
                }
                result = Math.max(result, kadanesAlgorithm(store));
            }
        }
        return result;
    }
    
    int kadanesAlgorithm(int [] nums) {
        int current = 0;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            current += num;
            result = Math.max(result, current);
            current = current < 0 ? 0 : current;
        }
        return result;
    }
}