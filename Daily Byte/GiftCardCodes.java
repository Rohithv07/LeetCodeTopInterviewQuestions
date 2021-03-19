/*
You are given a string S (that consists of only alphanumerical characters) and asked to reformat it into a gift card code. S has N dashes that separates the string into N + 1 groups of characters. Every gift card code needs to contain all uppercase characters and have exactly K characters in each group, except the first group (but the first group must have at least one character). Given S, reformat it into a gift card code and return the result.

Ex: Given the following values of S and K...

S = “49DkeDb39LXI”, K = 3, return "49D-KED-B39-LXI".
Ex: Given the following values of S and K...

S = “9Dklsi3nsEKE92”, K = 3 return "9D-KLS-I3N-SEK-E92".
*/

import java.util.*;

public class GiftCardCodes {

	public static String reformat(String s, int k) {
		String upperCaseString = s.toUpperCase();
		int length = upperCaseString.length();
		int modValue = length % k;
		StringBuilder sb = new StringBuilder();
		int trackK = k;
		if (modValue == 0) {
			for (int i=0; i<length; i++) {
				if (trackK == 0) {
					sb.append("-");
					trackK = k - 1;
					sb.append(upperCaseString.charAt(i));
				}
				else {
					sb.append(upperCaseString.charAt(i));
					trackK -= 1;
				}
			}
		}
		else {
			String firstPart = upperCaseString.substring(0, modValue);
			sb.append(firstPart);
			sb.append("-");
			for (int i=modValue; i<length; i++) {
				if (trackK == 0) {
					sb.append("-");
					trackK = k - 1;
					sb.append(upperCaseString.charAt(i));
				}
				else {
					sb.append(upperCaseString.charAt(i));
					trackK -= 1;
				}
			}
		}
		return sb.toString();

	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int k = sc.nextInt();
		System.out.println(reformat(s, k));
	}
}