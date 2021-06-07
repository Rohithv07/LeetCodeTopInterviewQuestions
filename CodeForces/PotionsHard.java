import java.util.*;

public class PotionsHard {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long sum = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i=0; i<n; i++) {
			long num = sc.nextLong();
			sum += num;
			pq.offer(num);
			while (sum < 0) {
				sum -= pq.poll();
			}
		}
		System.out.println(pq.size());
	}
}