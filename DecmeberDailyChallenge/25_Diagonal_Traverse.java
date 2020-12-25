Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

 

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:

 

Note:

The total number of elements of the given matrix will not exceed 10,000.




class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int [0];
        int row = matrix.length;
        int col = matrix[0].length;
        int [] result = new int [row * col];
        int r = 0;
        int c = 0;
        for (int i=0; i<result.length; i++) {
            result[i] = matrix[r][c];
            // top
            if ((r + c) % 2 == 0) {
                if (c == col - 1)
                    r++;
                else if (r == 0)
                    c++;
                else {
                    r--;
                    c++;
                }
            }
            // down
            else {
                if (r == row - 1)
                    c++;
                else if (c == 0)
                    r++;
                else {
                    c--;
                    r++;
                }
            }
        }
        return result;
    }
}
