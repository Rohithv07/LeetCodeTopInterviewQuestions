import java.util.*;

public class TMTDocument {

	public static String tmtSubsequence(int n, String s) {
		if (s.charAt(0) == 'M')
			return "no";
		int countT = 0;
		int countM = 0;
		boolean flag = true;
		for (char ch : s.toCharArray()) {
			if (ch == 'T')
				countT++;
			else {
				countM++;
				if (countM > countT)
					flag = false;
			}
		}
		if (countM * 2 != countT)
			flag = false;
		countT = 0;
		countM = 0;
		for (int i=n-1; i>=0; i--) {
			char ch = s.charAt(i);
			if (ch == 'T')
				countT++;
			else {
				countM++;
				if (countM > countT)
					flag = false;
			}
		}
		return flag ? "yes" : "no";
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println(tmtSubsequence(n, s));
		}
	}
}