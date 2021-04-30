import java.util.*;

public class AverageHeight {

	public static int [] findResult(int [] a, int n) {
		int [] result = new int [n];
		int first = 0;
		int last = n - 1;
		for (int number : a) {
			if (number % 2 == 0)
				result[first++] = number;
			else
				result[last--] = number;
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			int [] result = findResult(nums, n);
			for (int number : result) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
}