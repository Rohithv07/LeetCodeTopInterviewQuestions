package practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SantaClausI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		char[][] grid = new char[H][W];
		for (int i = 0; i < H; i++) {
			grid[i] = sc.next().toCharArray();
		}
		String T = sc.next();
		int x = X - 1;
		int y = Y - 1;
		int[][] directions = { { 'U', -1, 0 }, { 'D', 1, 0 }, { 'L', 0, -1 }, { 'R', 0, 1 } };
		Set<String> visited = new HashSet<>();
		if (grid[x][y] == '@') {
			visited.add(x + "$" + y);
		}
		for (char move : T.toCharArray()) {
			int dx = 0, dy = 0;
			for (int[] dir : directions) {
				if (dir[0] == move) {
					dx = dir[1];
					dy = dir[2];
					break;
				}
			}
			int newX = x + dx;
			int newY = y + dy;
			if (newX >= 0 && newX < H && newY >= 0 && newY < W && grid[newX][newY] != '#') {
				x = newX;
				y = newY;
				if (grid[x][y] == '@') {
					visited.add(x + "$" + y);
				}
			}
		}
		System.out.println((x + 1) + " " + (y + 1) + " " + visited.size());
		sc.close();
	}
}
