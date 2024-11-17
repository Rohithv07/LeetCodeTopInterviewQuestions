/**
 * 
 */
package practice;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 */
public class OneTwoThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int countOne = 0;
		int countTwo = 0;
		int countThree = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '1') {
				countOne++;
			}
			else if (ch == '2') {
				countTwo++;
			}
			else if (ch == '3') {
				countThree++;
			}
		}
		if (countOne == 1 && countTwo == 2 && countThree == 3) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		sc.close();
	}

}
