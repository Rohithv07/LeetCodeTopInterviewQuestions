import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long n = sc.nextLong();
			long temp = n;
			long maxCount = 0;
			long maxInt = 0;
			for (int i = 2; i <= Math.sqrt(n); i++) {
				int count = 0;
				while (n % i == 0) {
					count++;
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
			} else {
				System.out.println(maxCount);
				while (temp % (maxInt * maxInt) == 0) {
					System.out.print(maxInt + " ");
					temp = temp / maxInt;
				}
				System.out.println(temp);
			}
		}
	}

}