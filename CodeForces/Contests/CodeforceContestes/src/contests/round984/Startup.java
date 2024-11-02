package contests.round984;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 * 02-Nov-2024
 */
public class Startup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < k; i++) {
				int brand = sc.nextInt();
				int cost = sc.nextInt();
				map.put(brand, map.getOrDefault(brand, 0) + cost);
			}
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
			for (Integer key : map.keySet()) {
				pq.offer(map.get(key));
			}
			int sum = 0;
			int size = pq.size();
			if (size <= n) {
				while (!pq.isEmpty()) {
					sum += pq.poll();
				}
			}
			else {
				while (n-- > 0) {
					sum += pq.poll();
				}
			}
			System.out.println(sum);
			
		}
		sc.close();
	}

}
