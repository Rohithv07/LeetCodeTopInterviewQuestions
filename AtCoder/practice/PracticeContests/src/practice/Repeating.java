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
public class Repeating {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int [n];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if (map.containsKey(arr[i])) {
				System.out.print(map.get(arr[i]) + 1 + " ");
			}
			else {
				System.out.print(-1 + " ");
			}
			map.put(arr[i], i);
		}
		sc.close();
	}

}
