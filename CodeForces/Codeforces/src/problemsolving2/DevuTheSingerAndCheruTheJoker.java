package problemsolving2;

import java.util.Scanner;

public class DevuTheSingerAndCheruTheJoker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] time = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			time[i] = sc.nextInt();
			sum += time[i];
		}
		if (sum + (n - 1) * 10 > d) {
			System.out.println("-1");
		} else {
			System.out.println((d - sum) / 5);
		}

	}
}
