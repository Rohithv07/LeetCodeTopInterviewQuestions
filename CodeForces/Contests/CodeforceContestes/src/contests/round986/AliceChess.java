package contests.round986;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author rohithvazhathody 10-Nov-2024
 */
public class AliceChess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int targetRow = sc.nextInt();
			int targetCol = sc.nextInt();
			String s = sc.next();
			Map<Character, int[]> map = new HashMap<>();
			map.put('N', new int[] { 0, 1 });
			map.put('S', new int[] { 0, -1 });
			map.put('E', new int[] { 1, 0 });
			map.put('W', new int[] { -1, 0 });
			boolean result = bfs(map, targetRow, targetCol, 0, 0, s, 0);
			System.out.println(result ? "YES" : "NO");
		}
		sc.close();
	}

	private static boolean bfs(Map<Character, int[]> map, int targetRow, int targetCol, int i, int j, String s,
			int index) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		int repeat = 0;
		while (!queue.isEmpty() && repeat < 25) {
			int size = queue.size();
			while (size-- > 0) {
				int[] top = queue.poll();
				int row = top[0];
				int col = top[1];
				if (row == targetRow && col == targetCol) {
					return true;
				}
//				char current = s.charAt(index % s.length());
//				if (track.containsKey(current)) {
//					if (track.get(current)[0] == row && track.get(current)[1] == col)
//						return false;
//				}
//				track.put(current, new int [] {row, col});
				int next[] = map.get(s.charAt(index % s.length()));
				int nextRow = next[0] + row;
				int nextCol = next[1] + col;
				queue.offer(new int[] { nextRow, nextCol });
			}
			index = (index + 1) % s.length();
			if (index == 0) {
				repeat++;
			}
		}
		return false;
	}

}
