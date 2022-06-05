The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9


class Solution {
    public int totalNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, n, 0);
        System.out.println(result);
        return result.size();
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> current, int n, int pos) {
        if (pos == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=0; i<n; i++) {
            current.add(i);
            if (isValid(current)) {
                backtrack(result, current, n, pos + 1);
            }
            current.remove(current.size() - 1);
        }
    }
    
    public boolean isValid(List<Integer> current) {
        int limit = current.size() - 1;
        for (int i=0; i<limit; i++) {
            int diff = Math.abs(current.get(i) - current.get(limit));
            if (diff == 0 || diff == limit - i)
                return false;
        }
        return true;
    }
}