/**
 * @author rohithvazhathody
 * @date 2 Mar 2026
 * Project: CodeforceContestes
 * File: GardnerAndTheArray.java
 */

package practice.onethree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */
public class GardnerAndTheArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			Map<Integer, Integer> freqMap = new HashMap<>();
			List<List<Integer>> list = new ArrayList<>();
			for (int index = 0; index < n; index++) {
				List<Integer> temp = new ArrayList<>();
				int x = sc.nextInt();
				for (int j = 0; j < x; j++) {
					int val = sc.nextInt();
					freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
					temp.add(val);
				}
				list.add(temp);
			}
			String defaultVal = "NO";
			for (List<Integer> bitPos : list) {
				boolean flag = true;
				for (Integer pos : bitPos) {
					if (freqMap.get(pos) == 1) {
						flag = false;
						break;
					}
				}
				if (flag) {
					defaultVal = "YES";
					break;
				}
			}
			System.out.println(defaultVal);
		}
		sc.close();
	}

}
