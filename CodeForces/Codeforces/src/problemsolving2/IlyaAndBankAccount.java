/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class IlyaAndBankAccount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (num >= 0) {
			System.out.println(num);
		} else {
			num = num * -1;
			int last = num % 10;
			int secondLast = 0;
			int store = num;
			int counter = 0;
			while (counter < 2) {
				secondLast = store % 10;
				store /= 10;
				counter++;
			}
			String value = String.valueOf(num);
			StringBuilder sb = new StringBuilder();
			sb.append("-");
			if (secondLast > last) {
				for (int i = 0; i < value.length(); i++) {
					if (i != value.length() - 2) {
						sb.append(value.charAt(i));
					}
				}
			} else {
				for (int i = 0; i < value.length() - 1; i++) {
					sb.append(value.charAt(i));
				}
			}
			String result = sb.toString();
			if (result.charAt(1) == '0') {
				System.out.println(result.substring(1));
			} else
				System.out.println(result);
		}
	}
}
