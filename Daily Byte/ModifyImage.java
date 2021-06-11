import java.util.*;

public class ModifyImage {

	public static int [][] buildImage(int [][] mat, int row, int col) {
		if (row == 1 && col == 1)
			return mat;
		int [][] result = new int [row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				int currentSum = mat[i][j];
				int neighbour = 0;
				if (i - 1 >= 0) {
					currentSum += mat[i - 1][j];
					neighbour += 1;
				}
				if (i + 1 < row) {
					currentSum += mat[i + 1][j];
					neighbour += 1;
				}
				if (j - 1 >= 0) {
					currentSum += mat[i][j - 1];
					neighbour += 1;
				}
				if (j + 1 < col) {
					currentSum += mat[i][j + 1];
					neighbour += 1;
				}
				if (i + 1 < row && j + 1 < col) {
					currentSum += mat[i + 1][j + 1];
					neighbour += 1;
				}
				if (i + 1 < row && j - 1 >= 0) {
					currentSum += mat[i + 1][j - 1];
					neighbour += 1;
				}
				if (i - 1 >= 0 && j - 1 >= 0) {
					currentSum += mat[i - 1][j - 1];
					neighbour += 1;
				}
				if (i - 1 >= 0 && j + 1 < col) {
					currentSum += mat[i - 1][j + 1];
					neighbour += 1;
				}
				result[i][j] = currentSum / (neighbour == 8 ? neighbour : neighbour + 1);
			}
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int [][] mat = new int [row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		int [][] resultImage = buildImage(mat, row, col);
		for (int [] imageRow : resultImage) {
			System.out.println();
			for (int i=0; i<col; i++) {
				System.out.print(imageRow[i] + " ");
			}
		}
	}
}