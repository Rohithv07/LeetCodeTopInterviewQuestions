/**
 * 
 */
package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */
public class Humidifier1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(sc.nextInt(), sc.nextInt());
		}
		int initial = 0;
		int index = 0;
		for (int i = 1; i <= 100 && index < n; i++) {
			if (initial > 0) {
				initial -= 1;
			}
			if (map.containsKey(i)) {
				initial += map.get(i);
				index++;
			}
		}
		System.out.println(initial);
		sc.close();
	}

}
