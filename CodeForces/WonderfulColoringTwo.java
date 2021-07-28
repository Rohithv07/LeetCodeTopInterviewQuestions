import java.util.*;

public class WonderfulColoringTwo {

	public static int [] painTheWall(int n, int k, int [] nums) {
		if (n == 1 && k == 1)
			return new int []{1};
		int [] result = new int [n];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i=0; i<n; i++) {
			int number = nums[i];
			List<Integer> list = map.getOrDefault(number, new ArrayList<>());
			if (list.size() < k) {
				list.add(i);
				map.put(number, list);
			}
		}
		int size = 0;
		for (int key : map.keySet()) {
			size += map.get(key).size();
		}
		size -= size % k;
		int coloring = 0;
		for (int key : map.keySet()) {
			List<Integer> list = map.get(key);
			for (int i=0; i<list.size(); i++) {
				result[list.get(i)] = ++coloring;
				coloring %= k;
				size -= 1;
				if (size == 0)
					return result;
			}
		}
			return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int [] nums = new int [n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			int [] result = painTheWall(n, k, nums);
			for (int number : result) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
}