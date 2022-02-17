/**
 * 
 */
package problemsolving;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class LinearKeyboard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String keyBoard = sc.next();
			String s = sc.next();
			Map<Character, Integer> map = new HashMap<>();
			for (char ch : keyBoard.toCharArray()) {
				map.put(ch, keyBoard.indexOf(ch) + 1);
			}
			int time = 0;
			for (int i = 1; i < s.length(); i++) {
				int value1 = map.get(s.charAt(i));
				int value2 = map.get(s.charAt(i - 1));
				time += Math.abs(value2 - value1);
			}
			System.out.println(time);
		}
	}
}
