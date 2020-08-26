package com.rohith.datastructures;

public class UnionAndFind {
	int vertices, edges;
	Edge edge[];
	public class Edge {
		int src, dest;
	}
	UnionAndFind(int v, int e) {
		vertices = v;
		edges = e;
		edge = new Edge[edges];
		for (int i=0; i<e; i++) {
			edge[i] = new Edge();
		}
	}
	public static int find(int [] parent, int v) {
		if (parent[v] == -1)
			return v;
		return find(parent, parent[v]);
	}
	public static void union(int [] parent, int x, int y) {
		int xSet = find(parent, x);
		int ySet = find(parent, y);
		parent[xSet] = ySet;
	}
	public static boolean isCycle(UnionAndFind graph) {
		int [] parent = new int[graph.vertices];
		for (int i=0; i<graph.vertices; i++)
			parent[i] = -1;
		for (int i=0; i<graph.edges; i++) {
			int x = UnionAndFind.find(parent, graph.edge[i].src);
			int y = UnionAndFind.find(parent, graph.edge[i].dest);
			if (x == y)
				return true;
			UnionAndFind.union(parent, x, y);
		}
		return false;
	}

	public static void main(String[] args) {
		/* Let us create the following graph  
        0  
        | \  
        |  \  
        1---2 */
        int V = 3, E = 3; 
        UnionAndFind graph = new UnionAndFind(V, E); 
  
        // add edge 0-1 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
  
        // add edge 1-2 
        graph.edge[1].src = 1; 
        graph.edge[1].dest = 2; 
  
        // add edge 0-2 
        graph.edge[2].src = 0; 
        graph.edge[2].dest = 2; 
  
        if (graph.isCycle(graph)) 
            System.out.println( "graph contains cycle" ); 
        else
            System.out.println( "graph doesn't contain cycle" );

	}

}
