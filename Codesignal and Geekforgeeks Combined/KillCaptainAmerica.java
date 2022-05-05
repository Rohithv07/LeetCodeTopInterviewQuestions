Captain America is hiding from Thanos in a maze full of rooms.
The maze is designed in such a way that the room, within it, leads to another room via gate. Captain America is hiding only in those rooms which are accessible directly/indirectly through every other room in the maze.
Further provided that, the movement from one room (R1) to another room (R2) is one way(unidirectional) only .
Now, you being on Thanos side, want to kill Captain America.  

 

Example 1:

Input:
N = 5 and M =5
V = [[1, 2], [2, 3], [3, 4], [4, 3], [5, 4]]
Output: 2
Explanation:
We can look closesly after forming graph 
than captain america only can hide in a 
room 3 and 4 because they are the only room 
which have gates through them. So,
answer is 2.

Example 2:

Input:
N = 2, M = 1
V = [[1, 2]]
Output: 1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function captainAmerica() which takes the integer N, an integer M and 2-d array V as input parameters and returns the Total no of rooms.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(N+M)

 

Constraints:
1 ≤ n ≤ 30000
1 ≤ m ≤ 200000
1 ≤ p,q ≤ n







//   code

class Solution{
   
     private void dfs(int node, ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,int[] vis){
         vis[node]=1;
         for(Integer it:adj.get(node)){
             if(vis[it]==0){
                  dfs(it,adj,st,vis);
             }
         }
         st.push(node);
     }
     
     private void dfs_(int node,  ArrayList<ArrayList<Integer>> transpose,int[] vis,int par,int[] parent,int[] no){
         vis[node]=1;
        
         parent[node]=par;
         no[par]++;
         for(Integer it:transpose.get(node)){
             if(vis[it]==0){
                  dfs_(it,transpose,vis,par,parent, no);
             }
         }
     }
   
    private void dfs__(int node,int[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> adjn,int[] parent){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            int par1=parent[node];
            int par2=parent[it];
            if(par1==par2){
                continue;
            }
            adjn.get(par1).add(par2);
            if(vis[it]==0){
                dfs__(it,vis,adj,adjn,parent);
            }
        }
    }
   
   int captainAmerica(int N, int M, int V[][]){
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for(int i=0;i<N;i++){
           adj.add(new ArrayList<>());
       }
       for(int i=0;i<M;i++){
           adj.get(V[i][0]-1).add(V[i][1]-1);
       }
        int[] vis=new int[N];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<N;i++){
            if(vis[i]==0){
                dfs(i,adj,st,vis);
            }
        }
        ArrayList<ArrayList<Integer>> transpose=new ArrayList<>();
       for(int i=0;i<N;i++){
           transpose.add(new ArrayList<>());
           vis[i]=0;
       }
       for(int i=0;i<M;i++){
           transpose.get(V[i][1]-1).add(V[i][0]-1);
       }
       int[] parent=new int[N];
       int par=0;
       int[] no=new int[N];
       while(!st.isEmpty()){
           int node=st.pop();
           if(vis[node]==0){
               dfs_(node,transpose,vis,par,parent,no);
               par++;
               }
       }
     
       
        ArrayList<ArrayList<Integer>> adjn=new ArrayList<>();
        for(int i=0;i<par;i++){
         adjn.add(new ArrayList<>());   
        }
        Arrays.fill(vis,0);
        for(int i=0;i<N;i++){
            if(vis[i]==0){
                dfs__(i,vis,adj,adjn,parent);
            }
        }
        int outDegree=0;
        for(int i=0;i<par;i++){
            if(adjn.get(i).size()==0){
                outDegree++;
            }
        }
        if(outDegree>1 || outDegree==0){
            return 0;
        }
        else{
            for(int i=0;i<par;i++){
                 if(adjn.get(i).size()==0){
                  return no[i];
            }
            }
        }
        return -1;
        
   }
}