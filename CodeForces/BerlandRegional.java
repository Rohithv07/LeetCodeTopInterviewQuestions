import java.util.*;

public class BerlandRegional {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long [] u = new long [n];
			long [] s = new long [n];
			for (int i=0; i<n; i++) {
				u[i] = sc.nextLong();
			}
			for (int i=0; i<n; i++) {
				s[i] = sc.nextLong();
			}
			Map<Long, List<Long>> map = new HashMap<>();
			for (int i=0; i<n; i++) {
				long key = u[i] - 1;
				long value = s[i];
				map.computeIfAbsent(key, x -> new ArrayList<>()).add(value);
			}
			List<List<Long>> sorted = new ArrayList<>();
			for (long key : map.keySet()) {
				List<Long> value = map.get(key);
				Collections.sort(value);
				sorted.add(value);
			}
			//System.out.println(sorted);
			long [] answer = new long [n];
			List<List<Long>> prefixSum = new ArrayList<>();
			for (List<Long> v : sorted) {
				List<Long> temp = new ArrayList<>();
				for (int i=0; i<v.size(); i++) {
					if (i == 0)
						temp.add(v.get(i));
					else
						temp.add(temp.get(i - 1) + v.get(i));
				}
				prefixSum.add(temp);
			}
			//System.out.println(prefixSum);
			for (List<Long> v : prefixSum) {
				for (int i=1; i<=v.size(); i++) {
					int left = (int)v.size() % i;
					//System.out.print(left + " ");
					long delete = 0;
					if (left > 0) {
						delete = v.get(left - 1);
						//answer[i - 1] += (v.get(v.size() - 1) - delete);
					}
					// System.out.println();
					//System.out.print(delete + " ");
					// System.out.print(v.get(v.size() - 1) + " ");
					answer[i - 1] += (v.get(v.size() - 1) - delete);
				}
			}
			for (long number : answer) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
}