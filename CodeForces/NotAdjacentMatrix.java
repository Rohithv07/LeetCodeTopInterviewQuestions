import java.util.*;

public class NotAdjacentMatrix {

	public static int [][] findMatrix(int n) {
		int [][] result = new int [n][n];
		for (int [] mat : result) {
			Arrays.fill(mat, -1);
		}
		int starter = 1;
		for (int i=0; i<result.length; i++) {
			for (int j=0; j<result.length; j++) {
				if ((i + j) % 2 == 0) {
					result[i][j] = starter;
					starter += 1;
				}
			}
		}
		for (int i=0; i<result.length; i++) {
			for (int j=0; j<result.length; j++) {
				if (result[i][j] == -1) {
					result[i][j] = starter;
					starter += 1;
				}
			}
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			if (n == 1)
				System.out.println(1);
			else if (n == 2)
				System.out.println("-1");
			else {
				int [][] result = findMatrix(n);
				for (int i=0; i<result.length; i++) {
					//System.out.println();
					for (int j=0; j<result.length; j++) {
						System.out.print(result[i][j] + " ");
					}
					System.out.println();
				}
			}
			//System.out.println();
		}
	}
}