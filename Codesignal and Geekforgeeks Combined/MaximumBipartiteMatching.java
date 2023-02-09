There are M job applicants and N jobs.  Each applicant has a subset of jobs that he/she is interested in. Each job opening can only accept one applicant and a job applicant can be appointed for only one job. Given a matrix G with M rows and N columns where G(i,j) denotes ith applicant is interested in the jth job. Find the maximum number of applicants who can get the job.

Example 1:

Input: 
M = 3, N = 5
G = {{1,1,0,1,1},{0,1,0,0,1},
{1,1,0,1,1}}
Output: 3
Explanation: There is one of the possible
assignment-
First applicant gets the 1st job.
Second applicant gets the 2nd job.
Third applicant gets the 4th job.
Example 2:

Input:
M = 6, N = 2
G = {{1,1},{0,1},{0,1},{0,1},
{0,1},{1,0}}
Output: 2
Explanation: There is one of the possible
assignment-
First applicant gets the 1st job.
Second applicant gets the 2nd job.
 

Your Task:
You don't need to read to print anything. Your task is to complete the function maximumMatch() which takes matrix G as input parameter and returns the maximum number of applicants who can get the job.

Expected Time Complexity: O(N3).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N, M ≤ 100



//User function Template for Java

class Solution
{
    public int maximumMatch(int[][] g)
    {
        // Code here
        int m = g.length;
        int n = g[0].length;
        int [] match = new int [n];
        Arrays.fill(match, -1);
        int result = 0;
        for (int i = 0; i < m; i++) {
            boolean [] visited = new boolean [n];
            if (dfs(i, g, match, visited)) {
                result++;
            }
        }
        return result;
    }
    
    private boolean dfs(int node, int [][] graph, int [] match, boolean [] visited) {
        for (int v = 0; v < graph[0].length; v++) {
            if (graph[node][v] == 1 && !visited[v]) {
                visited[v] = true;
                if (match[v] == -1 || dfs(match[v], graph, match, visited)) {
                    match[v] = node;
                    return true;
                }
            }
        }
        return false;
    }
}