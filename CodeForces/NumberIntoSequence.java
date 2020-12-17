import java.util.*;
public class NumberIntoSequence {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long temp = n;
			int maxCount = 0;
			int maxInt = 0;
			for (int i=2; i<=Math.sqrt(n); i++) {
				int count = 0;
				while (n % i == 0) {
					count += 1;
					n /= i;
				}
				if (maxCount < count) {
					maxCount = count;
					maxInt = i;
				}
			}
			if (maxInt == 0) {
				System.out.println(1);
				System.out.println(temp);
			}
			else {
				System.out.println(maxCount);
				while (temp % (maxInt * maxInt) == 0) {
					System.out.println(maxInt + " ");
					temp /= maxInt;
				}
				System.out.println(temp);
			}
		}
	}
}