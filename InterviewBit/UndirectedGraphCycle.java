Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast three nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
1 <= A, M <= 3105

1 <= B[i][0], B[i][1] <= A



Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].



Output Format
Return 1 if cycle is present else return 0.



Example Input
Input 1:

 A = 5
 B = [  [1. 2]
        [1, 3]
        [2, 3]
        [1, 4]
        [4, 5]
     ]
Input 2:

 A = 3
 B = [  [1. 2]
        [1, 3]
     ]


Example Output
Output 1:

 1
Output 2:

 0


public class Solution {
    public int solve(int A, int[][] B) {
        boolean vis[]=new boolean[A];
        ArrayList g[]=new ArrayList[A];
        for(int i=0;i<A;i++) {
            g[i]=new ArrayList();
        }
        for(int i=0;i<B.length;i++) {
            g[B[i][0]-1].add(B[i][1]-1);
            g[B[i][1]-1].add(B[i][0]-1);
        }
        for(int i=0;i<A;i++){
            if(!vis[i]) {
            boolean iscycle=dfs(g,vis,i,A,-1);
            if(iscycle)
                return 1;
            }
        }
        return 0;
        }
    public boolean dfs(ArrayList<Integer> g[],boolean vis[],int i,int A,int p){
        vis[i]=true;
        boolean res=false;
        for(int j=0;j<g[i].size();j++) {
            int in = g[i].get(j);
            if(vis[in] && p!=in)
            return true;
            if(!vis[in]) {
                res = res || dfs(g,vis,in,A,i);
            }
        }
        return res;
    }
}
