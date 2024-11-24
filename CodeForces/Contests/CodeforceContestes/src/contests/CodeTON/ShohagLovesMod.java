package contests.CodeTON;

import java.util.Scanner;

/**
 * @author rohithvazhathody 23-Nov-2024
 */
public class ShohagLovesMod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				int seq = i + (i - 1);
				System.out.print(seq + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}

/*
 * 2 3 4 5
 * 
 * 2 3 => 2 3 2 4 => 2 1 2 5 => 2 1 3 4 3 5 4 5
 * 
 */
