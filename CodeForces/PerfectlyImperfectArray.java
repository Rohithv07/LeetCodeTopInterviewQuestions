import java.util.*;

public class PerfectlyImperfectArray {

	public static String isThereSquare(int [] nums, int n) {
		if (n == 1 && isSquare(nums[0]))
			return "NO";
		if (n == 1 && isSquare(nums[0]))
			return "YES";
		boolean isItPossible = false;
		for (int i=0; i<n; i++) {
			int root = (int)Math.sqrt(nums[i]);
			if (root * root != nums[i])
				isItPossible = true;
		}
		return isItPossible ? "YES" : "NO";

	}

	public static boolean isSquare(int n) {
		return Math.ceil(Math.sqrt(n)) == Math.floor(Math.sqrt(n));
	}

	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(isThereSquare(nums, n));
		}
	}
}