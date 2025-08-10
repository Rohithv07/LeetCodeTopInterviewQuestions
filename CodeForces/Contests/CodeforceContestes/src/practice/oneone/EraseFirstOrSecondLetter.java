package practice.oneone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody 09-Aug-2025
 */
public class EraseFirstOrSecondLetter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			int numOfStrings = findNumOfStrings(s, n);
			System.out.println(numOfStrings);
		}
		sc.close();
	}

	private static int findNumOfStrings(String s, int length) {
		if (length == 1) {
			return 1;
		}
		Map<Character, Integer> freqMap = new HashMap<>();
		int distinct = 0;
		int totalCount = 0;
		for (char ch : s.toCharArray()) {
			if (!freqMap.containsKey(ch)) {
				distinct++;
				freqMap.put(ch, 1);
			} else {
				freqMap.put(ch, freqMap.get(ch) + 1);
			}
			totalCount += distinct;
		}
		return totalCount;
	}

}
