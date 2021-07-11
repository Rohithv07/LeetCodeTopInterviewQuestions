// change class Name to solution

import java.util.*;

public class Solution {

	public static long findNumber(long [][] mat) {
		long count = check(mat[0][0], mat[0][1], mat[0][2]);
		count += check(mat[2][0], mat[2][1], mat[2][2]);
		count  += check(mat[0][0], mat[1][0], mat[2][0]);
		count += check(mat[0][2], mat[1][2], mat[2][2]);
		Map<Long, Long> map = new HashMap<>();
		countAp(map, mat[0][0], mat[2][2]);
		countAp(map, mat[0][2], mat[2][0]);
		countAp(map, mat[1][0], mat[1][2]);
		countAp(map, mat[0][1], mat[2][1]);
		long maxValue = 0;
		for (long key : map.keySet()) {
			maxValue = Math.max(maxValue, map.get(key));
		}
		return count + maxValue;
	}

	public static void countAp(Map<Long, Long> map, long x, long y) {
		long sum = x + y;
		if (sum % 2 == 1)
			return;
		if (!map.containsKey(sum))
			map.put(sum, 1l);
		else
			map.put(sum, map.get(sum) + 1);
	}

	public static long check(long a, long b, long c) {
		return a + c == 2 * b ? 1l : 0l;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			long [][] mat = new long [3][3];
			mat[0][0] = sc.nextLong();
			mat[0][1] = sc.nextLong();
			mat[0][2] = sc.nextLong();
			mat[1][0] = sc.nextLong();
			mat[1][2] = sc.nextLong();
			mat[2][0] = sc.nextLong();
			mat[2][1] = sc.nextLong();
			mat[2][2] = sc.nextLong();
			System.out.println("Case #" + t + ": " + findNumber(mat));
		}
	}
}

/*
ref : 
int res = check(a[0][0], a[0][1], a[0][2]);
        res += check(a[2][0], a[2][1], a[2][2]);
        res += check(a[0][0], a[1][0], a[2][0]);
        res += check(a[0][2], a[1][2], a[2][2]);

        map<int, int> cnt;

        auto add = [&](int x, int y) {
            int s = x + y;
            if (s % 2) return;
            cnt[s / 2]++;
        };

        add(a[0][0], a[2][2]);
        add(a[0][2], a[2][0]);
        add(a[1][0], a[1][2]);
        add(a[0][1], a[2][1]);

        int maxVal = 0;
        for (auto i: cnt) {
            maxVal = max(maxVal, i.second);
        }

        cout << res + maxVal << "\n";

*/