Given a binary matrix of dimensions N * M. One can perform the given operation in the matrix.

If the value of matrix[i][j] is 0, then traverse in the same direction and check the next value.
If the value of matrix[i][j] is 1, then update matrix[i][j] to 0 and change the current direction from up, right, down, or left to the directions right, down, left, and up respectively.
Initially you start from cell(0, 0), moving in right direction.

The task is to find the indices of the matrix  which leads to outside the matrix from the traversal of the given matrix from the cell (0, 0) by performing the operations.

Example 1:

Input:
matrix[][] = {{0,1},
              {1,0}}

Output: (1,1)
Explanation:




Example 2:

Input: 
matrix[][] = {{0, 1, 1, 1, 0},
                   {1, 0, 1, 0, 1},
              {1, 1, 1, 0, 0}}

Output: (2,0)
Your Task:
You don't need to read input or print anything. Complete the function endPoints() that take the matrix as input parameter and output the last cell before the pointer gets outside of the matrix.

Constrains:
1<= N, M <=1000
0<= matrix[i][j] <=1




class Solution{
    static int [] endPoints(int [][]arr, int m, int n){
        //code here
        int startX = 0;
        int startY = 0;
        int direction = 0;
         // 0 - right, 1 - down    2 - left. 3 - up
        while (startX >= 0 && startX < m && startY >= 0 && startY < n) {
            if (arr[startX][startY] == 0 && direction == 0) {
                startY++;
            }
            else if (arr[startX][startY] == 0 && direction == 1) {
                startX++;
            }
            else if (arr[startX][startY] == 0 && direction == 2) {
                startY--;
            }
            else if (arr[startX][startY] == 0 && direction == 3) {
                startX--;
            }
            else if (arr[startX][startY] == 1 && direction == 0) {
                arr[startX][startY] = 0;
                direction = 1;
            }
            else if (arr[startX][startY] == 1 && direction == 1) {
                arr[startX][startY] = 0;
                direction = 2;
            }
            else if (arr[startX][startY] == 1 && direction == 2) {
                arr[startX][startY] = 0;
                direction = 3;
            }
            else if (arr[startX][startY] == 1 && direction == 3) {
                arr[startX][startY] = 0;
                direction = 0;
            }
        }
        if (startX < 0) {
            startX++;
        }
        if (startY < 0) {
            startY++;
        } 
        if (startX >= m) {
            startX--;
        }
        if (startY >= n) {
            startY--;
        }
        return new int []{startX, startY};
    }
}