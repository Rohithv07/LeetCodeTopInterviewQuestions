import java.util.*;

public class WorthyMatrix {

	public static long howManyWorthy(long [][] mat, int row, int col, long k, int order) {
		long [][] dp = new long [row + 1][col + 1];
		for (int i=1; i<=col; i++) {
			dp[1][i] = mat[0][i - 1];
		}
		// column wise
		for (int i=2; i<=row; i++) {
			for (int j=1; j<=col; j++) {
				dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		// row wise
		for (int i=1; i<=row; i++) {
			for (int j=2; j<=col; j++) {
				dp[i][j] += dp[i][j - 1];
			}
		}
		// for (int i=0; i<=row; i++) {
		// 	System.out.println();
		// 	for (int j=0; j<=col; j++) {
		// 		System.out.print(dp[i][j] + " ");
		// 	}
		// }

		int count = 0;
		int minimum = Math.min(row, col);
		//System.out.println(minimum);
		int index = 0;
		while (index++ < minimum) {
			//System.out.println("Inside minimum");
			while (order < minimum + 1) {
				//System.out.println("Inside order");
				int i = order;
				int j = col;
				// int j = row;
				while (i < row + 1) {
					//System.out.println("Inside i");
					int x = i - order + 1;
					int y = j - order + 1;
					long z = dp[i][j] - dp[x - 1][j] - dp[i][y - 1] + dp[x - 1][y - 1];
					if ((z / (order * order)) < k) {
						i += 1;
					}
					else {
						int start = order;
						int end = col;
						int answer = 0;
						while (start <= end) {
							//System.out.println("BS");
							int mid = (start + end) / 2;
							x = i - order + 1;
							y = mid - order + 1;
							z = dp[i][mid] - dp[x - 1][mid] - dp[i][y - 1] + dp[x - 1][y - 1];
							if ((z / (order * order)) < k) {
								start = mid + 1;
								//System.out.println("Only here");
							}
							else {
								answer = mid;
								//System.out.println(answer);
								end = mid - 1;
							}
						}
						//System.out.println(count);
						count += col - answer + 1;
						i += 1;
					}
				}
				order += 1;
			}
			return count;

			//count += col - answer + 1;
		}
		return count;
		// long howMany = 0;
		// //howMany += findOneByOneSub(mat, row, col, k);
		// long [][] dp = new long [row][col];
		// for (int i=0; i<col; i++) {
		// 	dp[0][i] = mat[0][i];
		// }
		// // column wise
		// for (int i=1; i<row; i++) {
		// 	for (int j=0; j<col; j++) {
		// 		dp[i][j] = mat[i][j] + dp[i - 1][j];
		// 	}
		// }
		// // row wise
		// for (int i=0; i<row; i++) {
		// 	for (int j=1; j<col; j++) {
		// 		dp[i][j] += dp[i][j - 1];
		// 	}
		// }
		// for (int i=0; i<row; i++) {
		// 	for (int j=0; j<col; j++) {
		// 		long currentSum = subMatrixSum(i, j, dp);
		// 		if (currentSum / ((i - 1) * (i - 1)) >= k)
		// 			howMany += 1;
		// 	}
		// }
		// return howMany;
	}

	// public static long subMatrixSum(int a, int b, long [][] dp) {
	// 	return dp[a][b] - dp[a - 1][b] - dp[a][b - 1] + dp[a - 1][b - 1]; 
	// }

	// public static long findThePossibleSubMatrices(long [][] dp, long k) {
	// 	long answer = 0;
	// 	for (int i=0; i<dp.length; i++) {
	// 		for (int j=0; j<dp[0].length; j++) {
	// 			if (dp[i][j] / ((i + 1) * (i + 1)) >= k)
	// 				answer += 1;
	// 		}
	// 	}
	// 	return answer;
	// }

	// public static long findOneByOneSub(long [][] mat, long row, long col, long k) {
	// 	long sum = 0;
	// 	for (int i=0; i<row; i++) {
	// 		for (int j=0; j<col; j++) {
	// 			if (mat[i][j] >= k)
	// 				sum += 1;
	// 		}
	// 	}
	// 	return sum;
	// }

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			long k = sc.nextLong();
			long [][] mat = new long [row][col];
			for (int i=0; i<row; i++) {
				for (int j=0; j<col; j++) {
					mat[i][j] = sc.nextLong();
				}
			}
			System.out.println(howManyWorthy(mat, row, col, k, 1));
		}
	}
}