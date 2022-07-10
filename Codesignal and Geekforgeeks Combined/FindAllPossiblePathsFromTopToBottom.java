Given a N x M grid. Find All possible paths from top left to bottom right.From each cell you can either move only to right or down.

Example 1:

Input: 1 2 3
       4 5 6
Output: 1 4 5 6
        1 2 5 6 
        1 2 3 6
Explanation: We can see that there are 3 
paths from the cell (0,0) to (1,2).
Example 2:

Input: 1 2
       3 4
Output: 1 2 4
        1 3 4
Your Task:
You don't need to read input or print anything. Your task is to complete the function findAllPossiblePaths() which takes two integers n,m and grid[][]  as input parameters and returns all possible paths from the top left cell to bottom right cell in a 2d array.

Expected Time Complexity: O(2^N*M)
Expected Auxiliary Space: O(N)


Constraints:
1 <= n,m <= 10 
1 <= grid[i][j] <= n*m
n * m < 20


class Solution {
    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n,int m, int[][] grid) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        solve(res,list,0,0,n,m,grid);
        return res;
    }
    
    static void solve(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,
                            int i,int j,int n,int m,int[][]grid){
        if(i==n-1 && j==m-1){
            list.add(grid[i][j]);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        if(i==n || j==m)return;
        
        list.add(grid[i][j]);
        solve(res,list,i+1,j,n,m,grid);
        solve(res,list,i,j+1,n,m,grid);
        list.remove(list.size()-1);
        return;
        
    } 
}