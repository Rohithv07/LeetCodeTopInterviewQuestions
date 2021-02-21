/*
Given a positive integer n, return its corresponding column title in an excel spreadsheet.

Ex: Given the following values for n...

n = 1, return “A”.
n = 2, return “B”.
n = 3, return “C”.
n = 26, return “Z”. 
n = 27, return “AA”. 
n = 28, return “AB”. 
*/

import java.util.*;

public class SpreadsheetColumn {

	public static String columnTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			sb.insert(0, (char)('A' + n % 26));
			n /= 26;
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(columnTitle(n));
	}
}