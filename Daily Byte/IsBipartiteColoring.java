import java.util.*;

public class IsBipartiteColoring {

	public static boolean isBipartite(int [][] graph) {
		int n = graph.length;
		int [] coloring = new int [n];
		for (int i=0; i<n; i++) {
			if (coloring[i] == 0 && !isValid(graph, coloring, 1, i))
				return false;
		}
		return true;
	}

	public static boolean isValid(int [][] graph, int [] coloring, int color, int node) {
		if (coloring[node] != 0)
			return coloring[node] == color;
		coloring[node] = color;
		for (int next : graph[node]) {
			if (!isValid(graph, coloring, -color, next))
				return false;
		}
		return true;
	}


	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] graph = new int[n][2];
		for (int i=0; i<n; i++) {
			for (int j=0; j<2; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		System.out.println(isBipartite(graph));
	}
}