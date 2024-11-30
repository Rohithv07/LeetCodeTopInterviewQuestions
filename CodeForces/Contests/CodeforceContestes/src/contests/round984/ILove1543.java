package contests.round984;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 * 02-Nov-2024
 */
public class ILove1543 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int [][] mat = new int [row][col];
		Queue<int []> queue = new LinkedList<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		int [][] rotated = new int [row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				rotated[j][row - i - 1] = mat[i][j];
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (rotated[i][j] == 1) {
					queue.offer(new int [] {i, j, 1});
				}
			}
		}
		boolean isFound = false;
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int [] val = queue.poll();
				int currentRow = val[0];
				int currentCol = val[1];
				int currentVal = val[2];
				if (currentVal == 3) {
					isFound = true;
					break;
				}
				if (currentRow % 2 == 0) {
					int rightCol = currentCol + 1;
					int current = 0;
					int downRow = current;
					// down and right
					if (currentVal == 1) {
						if (currentRow + 1 >= 0 && currentCol + 1 >= 0 && currentRow + 1 < row && currentCol + 1 < col 
								&& (rotated[currentRow][currentCol + 1] == 5 || rotated[currentRow + 1][currentCol] == 5)){
							queue.offer(new int [] {});
							
						}
					}
					
				}
				else {
					// down and left
				}
			}
			if (isFound) {
				count++;
			}
		}
		System.out.println(count);
		
		sc.close();
	}

}
