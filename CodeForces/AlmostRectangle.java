import java.util.*;

public class AlmostRectangle {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			char [][] grid = new char[n][n];
			for (int i=0; i<n; i++) {
				String line = sc.next();
				for (int j=0; j<n; j++) {
					grid[i][j] = line.charAt(j);
				}
			}
			int count = 0;
			int whichRow1 = 0;
			int whichColumn1 = 0;
			int whichRow2 = 0;
			int whichColumn2 = 0;
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (grid[i][j] == '*' && count == 0) {
						whichRow1 = i;
						whichColumn1 = j;
						count++;
					}
					else if (grid[i][j] == '*' && count == 1) {
						whichRow2 = i;
						whichColumn2 = j;
					}
				}
			}
			if (whichColumn1 == whichColumn2 && whichColumn1 + 1 < n && whichColumn2 + 1 < n) {
				grid[whichRow1][whichColumn2 + 1] = '*';
				grid[whichRow2][whichColumn1 + 1] = '*';
			}
			else if (whichColumn1 == whichColumn2 && whichColumn1 - 1 >= 0 && whichColumn2 - 1 >= 0) {
				grid[whichRow1][whichColumn2 - 1] = '*';
				grid[whichRow2][whichColumn1 - 1] = '*';
			}
			if (whichRow1 == whichRow2 && whichRow1 + 1 < n && whichRow2 + 1 < n) {
				grid[whichRow1 + 1][whichColumn2] = '*';
				grid[whichRow2 + 1][whichColumn1] = '*';
			}
			else if (whichRow1 == whichRow2 && whichRow1 - 1 >= 0 && whichRow2 - 1 >= 0) {
				grid[whichRow1 - 1][whichColumn2] = '*';
				grid[whichRow2 - 1][whichColumn1] = '*';
			}
			else {
				grid[whichRow1][whichColumn2] = '*';
				grid[whichRow2][whichColumn1] = '*';
			}
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					System.out.print(grid[i][j]);
				}
				System.out.println();
			}
		}
	}
}