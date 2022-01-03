class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] indegree = new int [n + 1];
        for (int [] t : trust) {
            int normalPerson = t[0];
            int possibleJudge = t[1];
            indegree[normalPerson] -= 1;
            indegree[possibleJudge] += 1;
        }
        for (int i=1; i<=n; i++) {
            if (indegree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}