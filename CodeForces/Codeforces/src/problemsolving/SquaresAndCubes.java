package problemsolving;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SquaresAndCubes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			Set<Integer> track = new HashSet<>();
			for (int i = 1; i * i <= n; i++) {
				track.add(i * i);
			}
			for (int i = 1; i * i * i <= n; i++) {
				track.add(i * i * i);
			}
			System.out.println(track.size());
		}
	}
}
