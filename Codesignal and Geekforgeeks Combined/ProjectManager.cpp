
An IT company is working on a large project. The project is broken into N modules and distributed to different teams. Each team can work parallelly. The amount of time (in months) required to complete each module is given in an array duration[ ] i.e. time needed to complete ith module is duration[i] months. 
You are also given M dependencies such that for each i (1 ≤ i ≤ M)  dependencies[i][1]th module can be started after dependencies[i][0]th module is completed.
As the project manager, compute the minimum time required to complete the project.
Note: It is guaranteed that a module is not dependent on itself.

Example 1:

Input:
N = 6, M = 6
duration[] = {1, 2, 3, 1, 3, 2}
dependencies[][]:
[[5, 2]
 [5, 0]
 [4, 0] 
 [4, 1]
 [2, 3]
 [3, 1]]
Output: 
8
Explanation: 
graph
The Graph of dependency forms this and 
the project will be completed when Module 
1 is completed which takes 8 months.
Example 2:

Input:
N = 3, M = 3
duration[] = {5, 5, 5}
dependencies[][]:
[[0, 1]
 [1, 2]
 [2, 0]]
Output: 
-1
Explanation: 
There is a cycle in the dependency graph 
hence the project cannot be completed.
Your Task:
Complete the function minTime() which takes N, M, duration array, and dependencies array as input parameter and return the minimum time required. return -1 if the project can not be completed. 

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
0 ≤ M ≤ 2*105
1 ≤ duration[i] ≤ 105
0 ≤ dependencies[i][j] < N

class Solution {
	public:
    int minTime(vector<pair<int, int>> &d, int dur[], int n, int m) {
    	vector<int> indeg(n, 0), topo, dp(n, 0), adj[n];
    	queue<int> q;
    	for(int i=0;i<m;i++)
    	    indeg[d[i].second]++,adj[d[i].first].push_back(d[i].second);
    	for (int i = 0; i < n; i++)
    	    if (indeg[i] == 0)
    	        q.push(i), dp[i] = dur[i];
    	while (!q.empty()) {
    		auto x = q.front(); q.pop();
    		topo.push_back(x);
    		for (auto v : adj[x]) {
    			dp[v] = max(dp[v], dur[v] + dp[x]);
    			if (--indeg[v]==0)q.push(v);
    		}
    	}
    	if (topo.size() != n)return -1; // contains cycle !!!
    	return *max_element(dp.begin(), dp.end());
    }
};
