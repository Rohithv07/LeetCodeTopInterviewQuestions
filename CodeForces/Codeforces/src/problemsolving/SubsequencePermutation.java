package problemsolving;

import java.util.Arrays;
import java.util.Scanner;

public class SubsequencePermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			char [] toCharArray = s.toCharArray();
			char [] copyArray = s.toCharArray();
			Arrays.sort(copyArray);
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (copyArray[i] != toCharArray[i]) {
					count += 1;
				}
			}
			System.out.println(count);
		}
	}
}
