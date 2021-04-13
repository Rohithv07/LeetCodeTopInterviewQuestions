import java.util.*;

public class BinaryStringMex {

	private static int max = (int) 1e6;
	private static int [] nums0 =  new int [max];
	private static int [] nums1 = new int [max];
	private static int [] dp0 = new int [max + 2];
	private static int [] dp1 = new int [max + 2];

	public static void mex(String s) {
		int n = s.length();
		int position = -1;
		for (int i=0; i<n; i++) {
			if (s.charAt(i) == '0') {
				for (int j=position+1; j<=i; j++) 
					nums0[j] = i;
				position = i;
			}
		}

		for (int i=position + 1; i<n; i++) {
			nums0[i] = n;
		}
		if (nums0[0] == n) {
			System.out.println("0");
			return;
		}
		position = -1;
		for (int i=0; i<n; i++) {
			if (s.charAt(i) == '1') {
				for (int j=position+1; j<=i; j++) 
					nums1[j] = i;
				
				position = i;
			}
		}
		for (int i=position+1; i<n; i++) {
			nums1[i] = n;
		}
		dp0[n] = 0;
		dp0[n+1] = 0;
		dp1[n] = 0;
		dp1[n+1] = 0;
		for (int i=n-1; i>=0; i--) {
			dp0[i] = dp0[i + 1];
			if (s.charAt(i) == '0' && nums1[i] < n) {
				dp0[i] = Math.max(dp0[i], dp0[nums1[i] + 1] + 1);
			}
			if (s.charAt(i) == '1' && nums0[i] < n) {
				dp0[i] = Math.max(dp0[i], dp0[nums0[i] + 1] + 1);
			}
			dp1[i] = dp1[i + 1];
			if (nums1[i] < n)
				dp1[i] = Math.max(dp1[i], dp0[nums1[i] + 1] + 1);
		}
		int x = dp1[0] + 1;
		int count = nums1[0] + 1;
		StringBuilder sb = new StringBuilder();
		sb.append("1");
		for (int i=1; i<x; i++) {
			if (count >= n) {
				sb.append("0");
				continue;
			}
			if (nums0[count] >= n) {
				sb.append("0");
				count = nums0[count] + 1;
				continue;
			}
			if (dp0[nums0[count] + 1] < x - i - 1) {
				sb.append("0");
				count = nums0[count] + 1;
			}
			else {
				sb.append("1");
				count = nums1[count] + 1;
			}
 		}
 		System.out.println(sb.toString());
	}
	// public static boolean isASubSequence(String s1, String s2) {
	// 	int index = 0;
	// 	for (int i=0; i<s2.length(); i++) {
	// 		if (s1.charAt(index) == s2.charAt(i))
	// 			index += 1;
	// 		if (index == s1.length())
	// 			return true;
	// 	}
	// 	return false;
	// }

	// public static String mex(String s) {
	// 	Queue<String> queue = new LinkedList<>();
	// 	queue.offer("1");
	// 	while (true) {
	// 		String current = queue.poll();
	// 		if (!isASubSequence(current, s)) {
	// 			return current;
	// 		}
	// 		String next = current;
	// 		StringBuilder sb1 = new StringBuilder(current);
	// 		StringBuilder sb2 = new StringBuilder(next);
	// 		sb1.append("0");
	// 		sb2.append("1");
	// 		queue.offer(sb1.toString());
	// 		queue.offer(sb2.toString());
	// 	}
	// }

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-- > 0) {
			String s = sc.next();
			mex(s);
		}
	}
}