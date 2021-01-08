/*
This question is asked by Facebook. Given an undirected graph determine whether it is bipartite.
Note: A bipartite graph, also called a bigraph, is a set of graph vertices decomposed into two disjoint sets such that no two graph vertices within the same set are adjacent.

Ex: Given the followinig graph...

graph = [[1, 3], [0, 2], [1, 3], [0, 2]]
0----1
|    |
|    |
3----2
return true.
Ex: Given the followinig graph...

graph = [[1, 2], [0, 2, 3], [0, 1, 3], [0, 2]]
0----1
|  / |
| /  |
3----2
return false.

*/


import java.util.*;

class IsBipartiteUnionFind {

	public static boolean isBipartite(int [][] graph) {
		UnionFind uf = new UnionFind(graph.length);
		for (int i=0; i<graph.length; i++) {
			for (int j=0; j<graph[i].length; j++) {
				if (uf.find(i) == uf.find(graph[i][j]))
					return false;
				uf.union(graph[i][0], graph[i][j]);
			}
		}
		return true;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] graph = new int [n][2];
		for (int i=0; i<n; i++) {
			for (int j=0; j<2; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		System.out.println(isBipartite(graph));
	}
}

class UnionFind {
	int size;
	int noOfComponent;
	int [] parent;
	int [] rank;

	UnionFind(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("n <= 0 is not possible");
		size = n;
		noOfComponent = n;
		parent = new int [n];
		rank = new int [n];
		for (int i=0; i<n; i++)
			parent[i] = i;
	}

	int find(int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ)
			return;
		if (rank[rootQ] > rank[rootP]) {
			parent[rootP] = rootQ;
		}
		else {
			parent[rootQ] = rootP;
			if (rank[rootP] == rank[rootQ])
				rank[rootP] += 1;
		}
		noOfComponent --;
	}

	boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	int getComponent() {
		return noOfComponent;
	}

	int getSize()  {
		return size;
	}
}



