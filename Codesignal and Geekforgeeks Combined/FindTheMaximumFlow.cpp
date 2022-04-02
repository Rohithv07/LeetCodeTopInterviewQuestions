Given a graph with N vertices numbered 1 to N and M edges, The task is to find the max flow from vertex 1 to vertex N.

Example 1:

Input:
N = 5, M =  4
Edges[]= { {1, 2, 1} , {3, 2, 2}, {4, 2, 3}, {2, 5, 5} }
Output:
1 
Explanation: 
1 - 2 - 3
   / \
  4   5 
1 unit can flow from 1 -> 2 - >5 
 

Example 2:

Input:
N = 4 , M = 4
Edges[] = { {1, 2, 8}, {1, 3, 10}, {4, 2, 2}, {3, 4, 3} }
Output:
5 
Explanation:
  1 - 2 
  |   |
  3 - 4
3 unit can flow from 1 -> 3 -> 4
2 unit can flow from 1 -> 2 -> 4
Total max flow from 1 to N = 3+2=5
Your Task: 
You don't need to read input or print anything. Your task is to complete the function solve() which takes the N (the number of vertices) ,M (the number of Edges) and the array Edges[] (Where Edges[i] denoting an undirected edge between Edges[i][0] and Edges[i][1] with a flow capacity of Edges[i][2] ), and returns the integer denoting the maximum flow from 1 to N.

Expected Time Complexity: O( max_flow* M)
Expected Auxiliary Space: O(N+M)

Where max_flow is the maximum flow from 1 to N

Constraints:
1 <= N,M,Edges[i][2] <= 1000
1 <= Edges[i][0],Edges[i][1] <= N'







class Solution
{
public:
    int BFS(vector<vector<int>> &graph,vector<int> &parent,int source,int sink,int N)
   {
       int min_cap=INT_MAX;
       fill(parent.begin(), parent.end(), -1);
       vector<bool> visited(N,false);
       queue<int> q;
       
       q.push(source);
       visited[source]=true;
       parent[source]=-1;
       
       while(q.empty()==false)
       {
           auto u=q.front();
           q.pop();
           
           //adjacents
           
           for(int v=0;v<N;v++)
           {
               if(visited[v]==false && graph[u][v]!=0)
               {
                   if(v==sink)
                   {
                       parent[v]=u;
                       min_cap=min(min_cap,graph[u][v]);
                       return min_cap;
                   }
                   
                   q.push(v);
                   visited[v]=true;
                   min_cap=min(min_cap,graph[u][v]);
                   parent[v]=u;
               }
           }
       }
       
       return 0;
   }
   
   int fordFulkerson(vector<vector<int>> &graph,int source,int sink,int N)
   {
       vector<int> parent(N,-1);
       
       int res=0;
       
       while(BFS(graph,parent,source,sink,N)!=0)
       {
           int min_cap=BFS(graph,parent,source,sink,N);
           
           res+=min_cap;
           
           //considering all the edged in this path.
           
           int v=sink;
           while(v!=source)
           {
               int u=parent[v];
               graph[u][v]-=min_cap;
               graph[v][u]+=min_cap;
               v=parent[v];
           }
       }
       
       return res;
   }
   
   int solve(int N,int M,vector<vector<int>> Edges)
   {
       // code here
       vector<vector<int>> graph;
       
       for(int i=0;i<N;i++)
       {
           vector<int> v1;
           for(int j=0;j<N;j++)
           {
               v1.push_back(0);
           }
           graph.push_back(v1);
       }
       
       for(auto x: Edges)
       {
           int u=x[0]-1;
           int v=x[1]-1;
           int wt=x[2];
           
           graph[u][v]+=wt;
           graph[v][u]+=wt;
       }
       
       return fordFulkerson(graph,0,N-1,N);
       
   }
}