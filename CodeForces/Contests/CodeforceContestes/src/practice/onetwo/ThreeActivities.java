package practice.onetwo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author rohithvazhathody 27-Oct-2025
 */
public class ThreeActivities {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[][] sking = new int[n][2];
			int[][] movie = new int[n][2];
			int[][] board = new int[n][2];
			for (int index = 0; index < n; index++) {
				sking[index][0] = sc.nextInt();
				sking[index][1] = index;
			}
			for (int index = 0; index < n; index++) {
				movie[index][0] = sc.nextInt();
				movie[index][1] = index;
			}
			for (int index = 0; index < n; index++) {
				board[index][0] = sc.nextInt();
				board[index][1] = index;
			}
			long totalFriends = findMaximizedDay(sking, movie, board);
			System.out.println(totalFriends);
		}
		sc.close();
	}

	private static long findMaximizedDay(int[][] sking, int[][] movie, int[][] board) {
		Arrays.sort(sking, new ArrayComparator());
		Arrays.sort(movie, new ArrayComparator());
		Arrays.sort(board, new ArrayComparator());
		long totalFriends = 0;
		for (int index1 = 0; index1 < 3; index1++) {
			for (int index2 = 0; index2 < 3; index2++) {
				for (int index3 = 0; index3 < 3; index3++) {
					int[] currentSking = sking[index1];
					int[] currentMovie = movie[index2];
					int[] currentBoard = board[index3];
					if (currentSking[1] == currentMovie[1] || currentMovie[1] == currentBoard[1]
							|| currentBoard[1] == currentSking[1]) {
						continue;
					}
					totalFriends = Math.max(totalFriends, (currentSking[0] + currentMovie[0] + currentBoard[0]));
				}
			}
		}
		return totalFriends;
	}

}

class ArrayComparator implements Comparator<int[]> {
	@Override
	public int compare(int[] a, int[] b) {
		return Integer.compare(b[0], a[0]); // descending on first element
	}
}

/*
 * 5 19 12 3 18 18 6 17 10 13 - 19 15 17 19 11 16 3 11 17 17 17 - 19 1 17 18 10
 * 15 8 17 3 13 12
 * 
 * 
 * 10 10 10 9
 * 
 */
