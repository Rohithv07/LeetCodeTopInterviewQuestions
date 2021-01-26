import java.util.*;

public class BallInBerland {

	public static long combination(long number) {
		return number * (number - 1) / 2;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int boys = sc.nextInt();
			int girls = sc.nextInt();
			int k = sc.nextInt();
			long comb = combination(k);
			int [] arrayBoys = new int[boys];
			int [] arrayGirls = new int[girls];
			for (int i=0; i<k; i++) {
				arrayBoys[sc.nextInt() - 1] += 1;
			}
			for (int i=0; i<k; i++) {
				arrayGirls[sc.nextInt() - 1] += 1;
			}
			for (int i=0; i<boys; i++) {
				comb -= combination(arrayBoys[i]);
			}
			for (int i=0; i<girls; i++) {
				comb -= combination(arrayGirls[i]);
			}
			System.out.println(comb);
		}
	}
}