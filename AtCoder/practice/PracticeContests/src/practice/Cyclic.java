/**
 * 
 */
package practice;

import java.util.Scanner;

/**
 * 
 */
public class Cyclic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb1.append(s.charAt(1));
		sb1.append(s.charAt(2));
		sb1.append(s.charAt(0));
		sb2.append(s.charAt(2));
		sb2.append(s.charAt(0));
		sb2.append(s.charAt(1));
		System.out.println(sb1.toString() + " " + sb2.toString());
		sc.close();
	}

}
