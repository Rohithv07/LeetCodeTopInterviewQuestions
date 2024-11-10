package codejam;

import java.util.Arrays;
import java.util.Scanner;

public class SortStringAgain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String [] split1 = s1.split("-");
		String [] lowerCase = new String [split1.length];
		int index = 0;
		for (String s : split1) {
			s = s.toLowerCase();
			lowerCase[index++] = s;
		}
		Arrays.sort(lowerCase);
		index = 0;
		int totalSum;
		String [] resultArray = new String [split1.length];
		index = 0;
		for (String s : lowerCase) {
			totalSum = 0;
			for (char ch : s.toCharArray()) {
				totalSum += (ch - 'a') + 1;
			}
			char [] array = s.toCharArray();
			Arrays.sort(array);
			StringBuilder sb = new StringBuilder(new String(array));
			if (totalSum % 2 == 0) {
				resultArray[index++] = sb.toString();
			}
			else {
				resultArray[index++] = sb.reverse().toString();
			}
			
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < resultArray.length - 1; i++) {
			result.append(resultArray[i]);
			result.append("-");
		}
		result.append(resultArray[resultArray.length - 1]);
		System.out.println(result.toString());
	}
}
