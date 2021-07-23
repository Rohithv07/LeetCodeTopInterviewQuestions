/*
Given an integer, N, return all values between one and N (inclusive) in lexicographical order.
Note: N will not exceed one million.

Ex: Given the following N…

N = 11, return [1, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9].
*/




/*
    1         2        3      .................     9
   0 to 9   0 to 9   0 to 9   ..................   0 to 9


*/


class Solution {
    public List<Integer> lexicalOrder(int n) {
        if (n == 0)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i=1; i<=9; i++) {
            dfs(i, n, result);
        }
        return result;
    }
    
    public void dfs(int number, int n, List<Integer> result) {
        if (number > n)
            return;
        result.add(number);
        for (int i=0; i<10; i++) {
            int nextPossible = number * 10 + i;
            if (nextPossible > n)
                return;
            dfs(nextPossible, n, result);
        }
    }
}