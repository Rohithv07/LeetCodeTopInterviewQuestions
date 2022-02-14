package problemsolving;

import java.util.Scanner;

public class WhosOpposite {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			long numberOfPeople = 2 * Math.abs(a - b);
			if (a > numberOfPeople || b > numberOfPeople || c > numberOfPeople) {
				System.out.println("-1");
			}
			else {
				long possible = numberOfPeople / 2 + c;
				while (possible > numberOfPeople) {
					possible -= numberOfPeople;
				}
				System.out.println(possible);
			}
		}
	}
}
