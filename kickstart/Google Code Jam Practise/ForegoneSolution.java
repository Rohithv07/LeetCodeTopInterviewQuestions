import java.util.*;

public class ForegoneSolution {

	public static String [] noFourHelper(String n) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (char ch : n.toCharArray()) {
			if (ch == '4') {
				sb1.append('2');
				sb2.append('2');
			}
			else {
				if (sb1.length() != 0)
					sb1.append('0');
				sb2.append(ch);
			}
		}
		return new String [] {sb1.toString(), sb2.toString()};
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t=1; t<=test; t++) {
			String n = sc.next();
			String [] result = noFourHelper(n);
			System.out.println("Case #" + t + ": " + result[0] + " " + result[1]);
		}
	}
}