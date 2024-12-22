package contests.round995;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author rohithvazhathody 22-Dec-2024
 */
public class PreparingForTheExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[m];
			for (int i = 0; i < m; i++) {
				a[i] = sc.nextInt();
			}
			int[] q = new int[k];
			for (int i = 0; i < k; i++) {
				q[i] = sc.nextInt();
			}
			System.out.println(isPossible(n, m, k, a, q));
		}
		sc.close();
	}

	private static String isPossible(int n, int m, int k, int[] a, int[] q) {
		StringBuilder sb = new StringBuilder();
		Set<Integer> knownQuestion = new HashSet<>();
		for (int num : q) {
			knownQuestion.add(num);
		}
		Set<Integer> unKnownQuestion = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			if (!knownQuestion.contains(i)) {
				unKnownQuestion.add(i);
			}
		}
		if (unKnownQuestion.size() >= 2) {
			for (int i = 0; i < m; i++) {
				sb.append(0);
			}
			return sb.toString();
		}
		else if (unKnownQuestion.size() == 0) {
			for (int i = 0; i < m; i++) {
				sb.append(1);
			}
			return sb.toString();
		}
		else {
			for (int i = 0; i < m; i++) {
				int unKnown = a[i];
				if (unKnownQuestion.contains(unKnown)) {
					sb.append(1);
				}
				else {
					sb.append(0);
				}
			}
			return sb.toString();
		}
		
//		for (int i = 0; i < m; i++) {
//			int exclusion = a[i];
//			Set<Integer> currentList = new HashSet<>(everyQuestion);
//			currentList.remove(exclusion);
//			if (knownQuestion.containsAll(currentList)) {
//				sb.append(1);
//			} else {
//				sb.append(0);
//			}
//		}return sb.toString();
	}

}

/*
 * 2 3 4 5
 * 5 3 4
 * 
 */
