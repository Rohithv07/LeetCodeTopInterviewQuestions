import java.util.*;

public class NezzarAndColourFulBalls {

	public static int noOfColour(int [] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int number : nums) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		int max = Integer.MIN_VALUE;
		for (int key : map.keySet()) {
			max = Math.max(max, map.get(key));
		}
		return max;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] balls = new int [n];
			for (int i=0; i<n; i++) {
				balls[i] = sc.nextInt();
			}
			System.out.println(noOfColour(balls));
		}
	}
}