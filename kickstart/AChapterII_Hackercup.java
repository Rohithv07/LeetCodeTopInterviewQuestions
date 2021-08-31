import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class AChapterII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			String s = sc.next();
			int changes = sc.nextInt();
			String[] moves = new String[changes];
			for (int i = 0; i < changes; i++) {
				moves[i] = sc.next();
			}
			System.out.println("Case #" + t + ": " + findMinimumSecond(s, changes, moves));
		}
		sc.close();
	}

	private static int findMinimumSecond(String s, int changes, String[] moves) {
		if (s.length() == 1) {
			return 0;
		}
		Map<Character, List<Character>> graph = buildGraph(moves, changes);
		int result = Integer.MAX_VALUE;
		for (char c = 'A'; c <= 'Z'; c++) {
			int currentCount = 0;
			for (char ch : s.toCharArray()) {
				if (c != ch) {
					int bfsResult = bfs(ch, c, graph);
					if (bfsResult == Integer.MAX_VALUE) {
						currentCount = bfsResult;
						break;
					} else {
						currentCount += bfsResult;
					}
				}
			}
			if (currentCount != Integer.MAX_VALUE)
				result = Math.min(result, currentCount);
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private static int bfs(char ch, char c, Map<Character, List<Character>> graph) {
		Queue<Character> queue = new LinkedList<>();
		Set<Character> visited = new HashSet<>();
		int count = 0;
		queue.offer(ch);
		visited.add(ch);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				char current = queue.poll();
				if (current == c) {
					return count;
				}
				List<Character> children = graph.get(current);
				if (children != null) {
					for (Character child : children) {
						if (!visited.contains(child)) {
							queue.offer(child);
							visited.add(child);
						}
					}
				}
			}
			count += 1;
		}
		return Integer.MAX_VALUE;
	}

	private static Map<Character, List<Character>> buildGraph(String[] moves, int changes) {
		Map<Character, List<Character>> graph = new HashMap<>();
		for (String s : moves) {
			graph.computeIfAbsent(s.charAt(0), x -> new ArrayList<>()).add(s.charAt(1));
		}
		return graph;
	}
}
