


// ref video : https://youtu.be/FWAIf_EVUKE

//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        return solve(grid);
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        SolveSudoku(grid);
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
    
    static boolean solve(int [][] grid) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (grid[i][j] == 0) {
                    for (int num=1; num<=9; num++) {
                        if (isPossible(grid, i, j, num)) {
                            grid[i][j] = num;
                            if (SolveSudoku(grid)) {
                                return true;
                            }
                            else {
                                grid[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean isPossible(int [][] grid, int row, int col, int num) {
        for (int i=0; i<9; i++) {
            if (grid[row][i] == num) {
                return false;
            }
            if (grid[i][col] == num) {
                return false;
            }
            if (grid[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}