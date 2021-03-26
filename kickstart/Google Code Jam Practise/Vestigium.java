import java.util.*;

public class Vestigium {

	public static int findTrace(int [][] mat) {
		int trace = 0;
		int duplicateRow = 0;
		int duplicateCol = 0;
		int n = mat.length;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (i == j)
					trace += mat[i][j];
			}
		}
		return trace;
	}

	public static int findCommonRow(int [][] mat) {
		int countRow = 0;
		for (int i=0; i<mat.length; i++) {
			Set<Integer> set = new HashSet<>();
			int currentCount = 0;
			for (int j=0; j<mat.length; j++) {
				set.add(mat[i][j]);
			}
			if (set.size() < mat.length)
				countRow += 1;
		}
		return countRow;
	}

	public static int findCommonColumn(int [][] mat) {
		int countCol = 0;
		for (int i=0; i<mat.length; i++) {
			Set<Integer> set = new HashSet<>();
			int currentCount = 0;
			for (int j=0; j<mat.length; j++) {
				set.add(mat[j][i]);
			}
			if (set.size() < mat.length)
				countCol += 1;
		}
		return countCol;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t=1; t<=test; t++) {
			int n = sc.nextInt();
			int [][] mat = new int [n][n];
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			System.out.println("Case #" + t + ": " + findTrace(mat) + " " + findCommonRow(mat) + " " + findCommonColumn(mat));
		}
	}
}