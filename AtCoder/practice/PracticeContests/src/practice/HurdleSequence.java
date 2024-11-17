/**
 * 
 */
package practice;

import java.util.Scanner;

/**
 * 
 */
public class HurdleSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] split = s.split("\\|");
		for (int i = 1; i < split.length; i++) {
			//System.out.println(ss);
			String ss = split[i];
			System.out.print(ss.length() + " ");
		}
		System.out.println();
		sc.close();
	}

}
