package contests.round984;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author rohithvazhathody 02-Nov-2024
 */
public class AnyaAnd1100 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			int length = s.length();
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i + 4 <= length; i++) {
				if (i >= 0 && i + 4 >= 0 && i + 4 <= length) {
					if (s.substring(i, i + 4).equals("1100")) {
						set.add(i);
					} else {
						set.remove(i);
					}
				}
			}
			//System.out.println(set.size());
			int q = sc.nextInt();
			StringBuilder sb = new StringBuilder(s);
			while (q-- > 0) {
				int index = sc.nextInt();
				char ch = sc.next().charAt(0);
				index--;
				sb.setCharAt(index, ch);
				String newS = sb.toString();
				for (int j = index - 3; j <= index; j++) {
					if (j >= 0 && j + 4 >= 0 && j + 4 <= length && newS.substring(j, j + 4).equals("1100")) {
						set.add(j);
					} else {
						set.remove(j);
					}
				}
				System.out.println(set.size() > 0 ? "YES" : "NO");
			}
		}
		sc.close();
	}

}

/*
 * 111000 j i
 * 
 * 
 */
