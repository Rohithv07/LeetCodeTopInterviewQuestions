/**
 * 
 */
package problemsolving2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class Keyboard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String direction = sc.next();
		char[][] board = new char[3][10];
		String s = sc.next();
		StringBuilder sb = new StringBuilder();
		Map<Character, Character> left = new HashMap<>();
		Map<Character, Character> right = new HashMap<>();
		left.put('w', 'q');
		left.put('e', 'w');
		left.put('r', 'e');
		left.put('t', 'r');
		left.put('y', 't');
		left.put('u', 'y');
		left.put('i', 'u');
		left.put('o', 'i');
		left.put('p', 'o');
		left.put('s', 'a');
		left.put('d', 's');
		left.put('f', 'd');
		left.put('g', 'f');
		left.put('h', 'g');
		left.put('j', 'h');
		left.put('k', 'j');
		left.put('l', 'k');
		left.put(';', 'l');
		left.put('x', 'z');
		left.put('c', 'x');
		left.put('v', 'c');
		left.put('b', 'v');
		left.put('n', 'b');
		left.put('m', 'n');
		left.put(',', 'm');
		left.put('.', ',');
		left.put('/', '.');

		right.put('q', 'w');
		right.put('w', 'e');
		right.put('e', 'r');
		right.put('r', 't');
		right.put('t', 'y');
		right.put('y', 'u');
		right.put('u', 'i');
		right.put('i', 'o');
		right.put('o', 'p');
		right.put('a', 's');
		right.put('s', 'd');
		right.put('d', 'f');
		right.put('f', 'g');
		right.put('g', 'h');
		right.put('h', 'j');
		right.put('j', 'k');
		right.put('k', 'l');
		right.put('l', ';');
		right.put('z', 'x');
		right.put('x', 'c');
		right.put('c', 'v');
		right.put('v', 'b');
		right.put('b', 'n');
		right.put('n', 'm');
		right.put('m', ',');
		right.put(',', '.');
		right.put('.', '/');

		if (direction.equals("R")) {
			for (char ch : s.toCharArray()) {
				sb.append(left.get(ch));
			}
		} else {
			for (char ch : s.toCharArray()) {
				sb.append(right.get(ch));
			}
		}
		System.out.println(sb.toString());
	}
}
