import java.util.*;

public class ProductOneModuloN {

	public static int gcd(int a, int b) {
		if (b != 0)
			return gcd(b, a % b);
		return a;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> result = new ArrayList<>();
		long product = 1;
		int maxSize = 0;
		for (int i=1; i<n; i++) {
			if (gcd(i, n) == 1) {
				result.add(i);
				product = (product * i) % n;
				if (product == 1) {
					maxSize = result.size();
				}
			}
		}
		System.out.println(maxSize);
		for (int i=0; i<maxSize; i++)
			System.out.print(result.get(i) + " ");

	}
}