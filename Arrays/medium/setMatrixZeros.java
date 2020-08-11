Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?



Solution 1: O(m+n) space

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean [] rowZero = new boolean[matrix.length];
        boolean [] colZero = new boolean[matrix[0].length];
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                if (matrix[i][j] == 0){
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (rowZero[i] == true || colZero[j] == true)
                    matrix[i][j] = 0;
            }
        }
    }
}

Solution 2: O(column) space

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean [] colZero = new boolean[matrix[0].length];
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                if (matrix[i][j] == 0){
                    colZero[j] = true;
                }
            }
        }
        for (int i=0; i<matrix.length; i++){
            boolean rowZero = false;
            for(int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == 0)
                    rowZero = true;
            }
            for (int j=0; j<matrix[0].length; j++){
                if (rowZero == true || colZero[j] == true)
                    matrix[i][j] = 0;
            }
        }
    }
}

Solution 3: O(1) space
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstrowZero = false;
        for (int i=0; i<matrix[0].length; i++){
            if (matrix[0][i] == 0)
                    firstrowZero = true;
            }
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == 0)
                    matrix[0][j] = 0;
            }
        }
        for (int i=1; i<matrix.length; i++){
            boolean rowZero = false;
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == 0)
                    rowZero = true;
            }
            for (int j=0; j<matrix[0].length; j++){
                if (rowZero == true || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            
        }
        if (firstrowZero){
            for (int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }
    }
}
