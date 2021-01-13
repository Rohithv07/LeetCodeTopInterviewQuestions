There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.


Input Format

1st argument given is an Integer x.
2nd argument given is an Integer y.
3rd argument given is an Integer N, number of circles.
4th argument given is an Integer R, radius of each circle.
5th argument given is an Array A of size N, where A[i] = x cordinate of ith circle
6th argument given is an Array B of size N, where B[i] = y cordinate of ith circle
Output Format

Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
Constraints

0 <= x, y, R <= 100
1 <= N <= 1000
Center of each circle would lie within the grid
For Example

Input:
    x = 2
    y = 3
    N = 1
    R = 1
    A = [2]
    B = [3]
Output:
    NO
   
Explanation:
    There is NO valid path in this case


public class Solution {
    public  String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        
        Graph g = new Graph((A+1)*(B+1));
        Map<Integer, pos> map = new HashMap<Integer, pos>();
        populateGraph(g, A, B, map);
        
        return bfs(g, getPosition(A, B, A), map, D, E, F) ? "YES" : "NO";
    }

     class Graph {
        private int V; // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency Lists

        // Constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++)
                adj[i] = new LinkedList();
        }

        // Function which adds an edge from v -> w
        void addEdge(int v, int w) {
            adj[v].add(w);
        }
    }
    
    private  void populateGraph(Graph g, int x, int y, Map<Integer, pos> map) {
    
        for(int j =0; j<= y; j++) {
            for(int i=0; i<= x; i++) {
                addNeighbours(g, i, j, x, y, map);
            }
        }
        
    }
    
     class pos {
        public int x; public int y;
        pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private  void addNeighbours(Graph g, int i, int j, int x, int y, Map<Integer, pos> map) {
        map.put(getPosition(i, j, x), new pos(i, j));
        if(isNumberInGraph(i+1, j, x, y)) g.addEdge(getPosition(i, j, x), getPosition(i+1, j, x));
        if(isNumberInGraph(i+1, j+1, x, y)) g.addEdge(getPosition(i, j, x), getPosition(i+1, j+1, x));
        if(isNumberInGraph(i, j+1, x, y)) g.addEdge(getPosition(i, j, x), getPosition(i, j+1, x));
        if(isNumberInGraph(i-1, j+1, x, y)) g.addEdge(getPosition(i, j, x), getPosition(i-1, j+1, x));
        if(isNumberInGraph(i-1, j, x, y)) g.addEdge(getPosition(i, j, x), getPosition(i-1, j, x));
        if(isNumberInGraph(i-1, j-1, x, y)) g.addEdge(getPosition(i, j, x), getPosition(i-1, j-1, x));
        if(isNumberInGraph(i, j-1, x, y)) g.addEdge(getPosition(i, j, x), getPosition(i, j-1, x));
        if(isNumberInGraph(i+1, j-1, x, y)) g.addEdge(getPosition(i, j, x), getPosition(i+1, j-1, x));
    }
    
    private  boolean isNumberInGraph(int i, int j, int x, int y) {
        
        if(i < 0 || i > x) return false;
        if(j < 0 || j > y) return false;
        
        return true;
    }
    
    private  int getPosition(int i, int j, int x) {
        return j*(x+1) + i;
    }
    
    private  boolean bfs(Graph g, int z, Map<Integer, pos> map, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        boolean isVisited[] = new boolean[z+1];
        isVisited[0] = true;
        while(!q.isEmpty()) {
            int pop = q.remove();
            if(pop == z) {
                return true;
            }
            LinkedList l = g.adj[pop];
            Iterator<Integer> it = l.listIterator(); 
            while(it.hasNext()) {
                int n = it.next();
                if(isVisited[n]) {
                    continue;
                }
                isVisited[n] = true;
                if(doesPointLieInAnyCircles(n, D, E, F, map)) continue;
                q.add(n);
            }
        }
        
        return false;
    }
    
    private  boolean doesPointLieInAnyCircles(int k, int D, ArrayList<Integer> E, ArrayList<Integer> F, Map<Integer, pos> map) {
    
        for(int i=0; i< E.size(); i++) {
            int cx = E.get(i);
            int cy = F.get(i);
            pos p = map.get(k);
            
            if(doesPointLieInCircle(p.x, p.y, D, cx, cy)) return true;
        }
        
        return false;
    }
    
    private  boolean doesPointLieInCircle(int i, int j, int r, int cx, int cy) {
        
        if(distance(i, j, cx, cy) <= r) return true;
        
        return false;
    }
    
     private  double distance(int x1, int y1, int x2, int y2) 
    { 
        // Calculating distance 
        return Math.sqrt(Math.pow(x2 - x1, 2) +  
                Math.pow(y2 - y1, 2)); 
    } 

}
