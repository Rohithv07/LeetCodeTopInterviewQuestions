package problemsolving2;

import java.util.Arrays;
import java.util.Scanner;

public class BusinessTrips {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int test = sc.nextInt();
//		while (test-- > 0) {
//		}
		int k = sc.nextInt();
		int[] raise = new int[12];
		for (int i = 0; i < 12; i++) {
			raise[i] = sc.nextInt();
		}
		int minDays = 0;
		Arrays.sort(raise);
		int total = 0;
		int index = 11;
		while (total < k && index >= 0) {
			total += raise[index];
			index--;
			minDays++;
		}
		if (total < k) {
			System.out.println("-1");
		} else {
			System.out.println(minDays);
		}
	}
}
