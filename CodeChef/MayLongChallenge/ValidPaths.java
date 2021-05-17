import java.util.*;
public class ValidPaths {

	private static final int N = (int)1e5 + 5;
	private static int [] vertices = new int [N];
	private static Map<Integer, List<Integer>> graph = new HashMap<>();
	private static int result;
	private static final int MOD = (int)1e9 + 7;


	public static int dfs(int i, int j) {
		vertices[i] = 1;
		result += 1;
		List<Integer> children = graph.get(i);
		for (Integer child : children) {
			if (child == j)
				continue;
			dfs(child, i);
			result += ((vertices[child] * vertices[i])) % MOD;
			vertices[i] += 2 * vertices[child];
			vertices[i] %= MOD;
			result %= MOD;
		}
		return vertices[i];
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			for (int i=1; i<=n; i++) {
				vertices[i] = 0;
				graph.remove(i);
			}
			for (int i=1; i<n; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
				graph.computeIfAbsent(v, x -> new ArrayList<>()).add(u);

			}
			result = 0;
			dfs(1, 1);
			System.out.println(result);
		}
	}
}