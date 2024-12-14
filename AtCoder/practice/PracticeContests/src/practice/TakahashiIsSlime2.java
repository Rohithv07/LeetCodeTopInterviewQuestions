///**
// * 
// */
//package practice;
//
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
///**
// * 
// */
//public class TakahashiIsSlime2 {
//
//	/**
//	 * @param args
//	 */
//
//	private static final int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int row = sc.nextInt();
//		int col = sc.nextInt();
//		int limit = sc.nextInt();
//		int tRow = sc.nextInt();
//		int tCol = sc.nextInt();
//		tRow--;
//		tCol--;
//		long[][] mat = new long[row][col];
//		for (int i = 0; i < row; i++) {
//			for (int j = 0; j < col; j++) {
//				mat[i][j] = sc.nextLong();
//			}
//		}
//		System.out.println(findMaxPower(mat, row, col, limit, tRow, tCol));
//		sc.close();
//	}
//
//	private static long findMaxPower(long[][] mat, int row, int col, int limit, int tRow, int tCol) {
//		PriorityQueue<Triple> pq = new PriorityQueue<>((t1, t2) -> Long.compare(t2.strength, t1.strength));
//		pq.offer(new Triple(tRow, tCol, 0));
//		boolean[][] visited = new boolean[row][col];
//		long currentStrength = mat[tRow][tCol];
//		visited[tRow][tCol] = true;
//		while (!pq.isEmpty()) {
//			Triple current = pq.poll();
//			int currentRow = current.row;
//			int currentCol = current.col;
//			long strength = current.strength;
//			if (strength >= ((currentStrength + limit - 1) / limit)) {
//				break;
//			}
//			currentStrength += strength;
//			for (int[] d : directions) {
//				int newRow = d[0] + currentRow;
//				int newCol = d[1] + currentCol;
//				if (newRow < 0 || newCol < 0 || newRow >= row || newCol >= col || visited[newRow][newCol]) {
//					continue;
//				}
//				//System.out.println();
//				visited[newRow][newRow] = true;
//				pq.add(new Triple(newRow, newCol, mat[newRow][newCol]));
//			}
//		}
//		return currentStrength;
//	}
//
//}
//
//class Triple {
//	int row;
//	int col;
//	long strength;
//
//	public Triple(int row, int col, long strength) {
//		this.row = row;
//		this.col = col;
//		this.strength = strength;
//	}
//}

/**
 * 
 */

package practice;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 */
public class TakahashiIsSlime2 {

	/**
	 * @param args
	 */

	private static final int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int limit = sc.nextInt();
		int tRow = sc.nextInt();
		int tCol = sc.nextInt();
		tRow--;
		tCol--;
		long[][] mat = new long[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				mat[i][j] = sc.nextLong();
			}
		}
		System.out.println(findMaxPower(mat, row, col, limit, tRow, tCol));
		sc.close();
	}

	private static long findMaxPower(long[][] mat, int row, int col, int limit, int tRow, int tCol) {
		PriorityQueue<long[]> strength = new PriorityQueue<>((l1, l2) -> Long.compare(l1[0], l2[0]));
        strength.offer(new long[]{0, tRow, tCol});
        boolean[][] seen = new boolean[row][col];
        seen[tRow][tCol] = true;
        long answer = mat[tRow][tCol];
        while (!strength.isEmpty()) {
            long[] temp = strength.poll();
            long val = temp[0];
            int x = (int) temp[1];
            int y = (int) temp[2];
            if (val >= (answer + limit - 1) / limit) break;
            answer += val;
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col || seen[nx][ny]) continue;
                seen[nx][ny] = true;
                strength.offer(new long[]{mat[nx][ny], nx, ny});
            }
        }
		return answer;
	}

}

class Triple {
	int row;
	int col;
	long strength;

	public Triple(int row, int col, long strength) {
		this.row = row;
		this.col = col;
		this.strength = strength;
	}
}

