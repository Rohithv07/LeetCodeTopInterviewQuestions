/**
 * 
 */
package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 */
public class Pairing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<>();
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int num4 = sc.nextInt();
		map.put(num1, map.getOrDefault(num1, 0) + 1);
		map.put(num2, map.getOrDefault(num2, 0) + 1);
		map.put(num3, map.getOrDefault(num3, 0) + 1);
		map.put(num4, map.getOrDefault(num4, 0) + 1);
		int count = 0;
		for (Integer key : map.keySet()) {
			int val = map.get(key);
			count += (val / 2);
		}
		System.out.println(count);
		sc.close();
	}

}
