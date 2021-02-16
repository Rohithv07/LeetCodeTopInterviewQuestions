import java.util.*;

public class PrimeGame {

	private static final int N = (int)1e6 + 5;
	private static int [] result = new int [N];
	public static String whoWins(int x, int y) {
		if (x == 1) {
			return "Chef";
		}
		List<Integer> list = countPrime();
		int count = 0;
		int first = list.get(0);
		for (int i=0; i<N; i++) {
			if (first <= i) {
				count ++;
				first ++;
			}
			result[i] = count;
		}
		return result[x] <= y ? "Chef" : "Divyam";

	}

	public static List<Integer> countPrime() {
		List<Integer> list = new ArrayList<>();
		int count = 0;
		boolean [] trackPrime = new boolean[N];
		for (int i=2; i*i<N; i++) {
			if (!trackPrime[i]) {
				for (int j=2; j*i<N; j++) {
					trackPrime[i * j] = true;
				}
			}
		}
		for (int i=2; i<N; i++) {
			if (!trackPrime[i])
				list.add(i);
		}
		return list;
	}

	

	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(whoWins(x, y));
		}
	}
}