/**
 * 
 */
package problemsolving;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class ComputerGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			char[][] grid = new char[2][n];
			for (int i = 0; i < 2; i++) {
				String s = sc.next();
				for (int j = 0; j < n; j++) {
					grid[i][j] = s.charAt(j);
				}
			}
			Queue<int[]> queue = new LinkedList<>();
			boolean[][] visited = new boolean[2][n];
			queue.offer(new int[] { 0, 0 });
			visited[0][0] = true;
			int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 },
					{ -1, 1 } };
			boolean possible = false;
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					int[] current = queue.poll();
					if (current[0] == 1 && current[1] == n - 1) {
						possible = true;
						break;
					}
					for (int[] dir : direction) {
						int x = dir[0] + current[0];
						int y = dir[1] + current[1];
						if (x < 0 || y < 0 || x >= 2 || y >= n || visited[x][y] || grid[x][y] == '1') {
							continue;
						}
						visited[x][y] = true;
						queue.offer(new int[] { x, y });
					}
				}
				if (possible) {
					break;
				}
			}
			System.out.println(possible ? "YES" : "NO");
		}
	}
}
