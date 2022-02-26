You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.

Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.

 

Example 1:


Input: graph = [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]
Example 2:


Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]
 

Constraints:

n == graph.length
1 <= n <= 12
0 <= graph[i].length < n
graph[i] does not contain i.
If graph[a] contains b, then graph[b] contains a.
The input graph is always connected.


class Solution {
    public int shortestPathLength(int[][] graph) {
        
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        
        int n = graph.length;
        
        // Adjency list of graph
        
        for(int i=0;i<n;i++){
            if(!hm.containsKey(i)){
                hm.put(i, new ArrayList<Integer>());
            }
            
            int m = graph[i].length;
            for(int j=0;j<m;j++){
                hm.get(i).add(graph[i][j]);
            }
            
        }
        
        //dist 2d array
        //row: bitmask -> visited node set bits are 1
        //column: leading node
        
        int row = (int)Math.pow(2,n);
        int col = n;
        int dist[][] = new int[row][col];
        
        for(int i=0;i<row;i++){
            Arrays.fill(dist[i], -1);
        }
        
        
        //Queue: [{leading node 1, mask},{leading node 2, mask} ... ]
        LinkedList<int[]> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            
            int lead = i;
            int mask = setbit(0,i);
            
            q.add(new int[]{lead, mask});
            dist[mask][lead] = 0;
        }
        
        
        // Applying simulatneous BFS
        while(q.size()>0){
            
            
            int size = q.size();
            for(int i=0;i<size;i++){
                
                int[] path = q.remove();
                
                int lead = path[0];
                int mask = path[1];
                
                if(mask == row-1){   //all nodes visited
                    return dist[mask][lead];
                }
                
                // iterate over neighbours of lead
                if(hm.containsKey(lead)){
                    
                    for(int child: hm.get(lead)){
                    
                        int newlead = child;
                        int newmask = setbit(mask, newlead);

                        // avoid cycle: intelligent bfs : checking if this set is already visited 
                        // set : lead, mask(visited nodes)
                        if(dist[newmask][newlead]!=-1){
                            continue;
                        }

                        dist[newmask][newlead] = dist[mask][lead]+1;
                        q.add(new int[]{newlead, newmask});

                    }

                }
                
            }
            
        }
        
        
        return -1;
        
        
        
    }
    
    
    private int setbit(int mask, int i){
        return mask|(1<<i);
    }
    
    
    
    
}