/**
 * 
 */
package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 */
public class Humidifier3 {

	/**
	 * @param args
	 */
	private static final int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int d = sc.nextInt();
		char[][] mat = new char[row][col];
		Queue<int[]> queue = new LinkedList<>();
		int total = 0;
		for (int i = 0; i < row; i++) {
			String s = sc.next();
			for (int j = 0; j < col; j++) {
				mat[i][j] = s.charAt(j);
				if (mat[i][j] == 'H') {
					queue.offer(new int[] { i, j, 0 });
					total++;
				}
			}
		}
		if (total == 0) {
			System.out.println(0);
		} else {
			int humidified = bfs(queue, mat, row, col, d, total);
			System.out.println(humidified);
		}
		sc.close();

	}

	private static int bfs(Queue<int[]> queue, char[][] mat, int row, int col, int d, int total) {
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentRow = current[0];
			int currentCol = current[1];
			int currentDistance = current[2];
			if (currentDistance >= d) {
				continue;
			}

			for (int[] dir : directions) {
				int nextRow = current[0] + dir[0];
				int nextCol = current[1] + dir[1];
				if (nextRow < 0 || nextCol < 0 || nextRow >= row || nextCol >= col || mat[nextRow][nextCol] != '.') {
					continue;
				}
				int distance = Math.abs(currentRow - nextRow) + Math.abs(currentCol - nextCol);
				if (distance > d) {
					continue;
				}
				total++;
				mat[nextRow][nextCol] = 'H';
				queue.offer(new int[] { nextRow, nextCol, currentDistance + 1 });
			}
		}
		return total;
	}

}

/*
 * 5 6 2 ##...H H..... ..H.#. .HH... .###..
 * 
 * 
 * 
 */
